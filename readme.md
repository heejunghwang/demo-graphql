# graphql - spring boot example

## How to set the property

1. add dependency in gradle

```
    // graphql 설정
    compile 'com.graphql-java-kickstart:graphql-spring-boot-starter:5.7.3'

    // to embed Altair tool
    runtime 'com.graphql-java-kickstart:altair-spring-boot-starter:5.7.3'

    // to embed GraphiQL tool
    runtime 'com.graphql-java-kickstart:graphiql-spring-boot-starter:5.7.3'

    // to embed Voyager tool
    runtime 'com.graphql-java-kickstart:voyager-spring-boot-starter:5.7.3'

    // testing facilities
    testCompile 'com.graphql-java-kickstart:graphql-spring-boot-starter-test:5.7.3'
```

2. add graphql servlet config
You should add the this config in application.yml file for setting servlet. If you are not using it, you can manually config the setting in servlet. (Ref : https://github.com/graphql-java-kickstart/graphql-java-servlet) 

```
graphql:
      servlet:
           mapping: /graphql
           enabled: true
           corsEnabled: true
           exception-handlers-enabled: true
      tools:
          schema-location-pattern: "**/*.graphqls"
          # Enable or disable the introspection query. Disabling it puts your server in contravention of the GraphQL
          # specification and expectations of most clients, so use this option with caution
          introspection-enabled: true
```

This property will work like this function.

```java
servlet.addListener(new GraphQLServletListener() {
    @Override
    GraphQLServletListener.RequestCallback onRequest(HttpServletRequest request, HttpServletResponse response) {

        return new GraphQLServletListener.RequestCallback() {
            @Override
            void onSuccess(HttpServletRequest request, HttpServletResponse response) {

            }

            @Override
            void onError(HttpServletRequest request, HttpServletResponse response, Throwable throwable) {

            }

            @Override
            void onFinally(HttpServletRequest request, HttpServletResponse response) {

            }
        }
    }

    @Override
    GraphQLServletListener.OperationCallback onOperation(GraphQLContext context, String operationName, String query, Map<String, Object> variables) {

        return new GraphQLServletListener.OperationCallback() {
            @Override
            void onSuccess(GraphQLContext context, String operationName, String query, Map<String, Object> variables, Object data) {

            }

            @Override
            void onError(GraphQLContext context, String operationName, String query, Map<String, Object> variables, Object data, List<GraphQLError> errors) {

            }

            @Override
            void onFinally(GraphQLContext context, String operationName, String query, Map<String, Object> variables, Object data) {

            }
        }
    }
})
```

Now, every request can be done with following URL : `/graphql`

3. graphiql
GraphiQL becomes accessible at the root `/graphiql` if graphiql-spring-boot-starter is added as a dependency to a boot application. You can add this config like this in application.yml

```
graphql:
      servlet:
           mapping: /graphql
           enabled: true
           corsEnabled: true
           exception-handlers-enabled: true
      tools:
          schema-location-pattern: "**/*.graphqls"
          # Enable or disable the introspection query. Disabling it puts your server in contravention of the GraphQL
          # specification and expectations of most clients, so use this option with caution
          introspection-enabled: true
```

Now, you can access this URL in your browser : `http://localhost:8080/graphiq`

4. add `graphqls` file
graphqls has the info for graphql. For example, `shoesshop.graphqls` has

```
type Query {
    shoes: [Shoes]
}

type Shoes {
    id: Int
    brand: Brand
    name: String
}

enum Brand {
    ADIDAS,
    PUMA
}
```

Following objects should be have in Java objects to get the right query.
You can implement `GraphQLQueryResolver` to get the query result and `GraphQLMutationResolver` for mutating objects.

5. run Query in your graphiql
When you go to `http://localhost:8080/graphiql`, you can query like below.

```
{
    shoes {
        id
        brand
    }
}
```

6. mutation (how to insert)
You can use mutation query like this.

```
mutation createPet {
  createPet(input: {
    type: DOG,
    name: "test@test.cz",
    age: 11
  }) {
    type
    name
    age
  }
}
```

You can check the result.
```
{
  pets {
    name
    age
    type
  }
}
```

7. reference
* https://github.com/sambenskin/graphql-spring-boot-tutorial

