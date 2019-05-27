import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import example.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PetTest {

    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;

    @Test
    public void testCreatePet() throws IOException{
        ObjectNode variables = new ObjectMapper().createObjectNode();
        variables.put("type", "DOG");
        variables.put("name", "petName");
        variables.put("age", 10);

        ObjectNode v2 = new ObjectMapper().createObjectNode();
        v2.put("pet", variables);

        GraphQLResponse response = graphQLTestTemplate.perform("create-pet.graphql", v2);
        assertNotNull(response);
        assertNotNull(response.get("$.data.createPet.name"));
    }

    @Test
    public void testGetPets() throws IOException {
        GraphQLResponse response = graphQLTestTemplate.postForResource("post-pets.graphql");
        assertNotNull(response);
        assertTrue(response.isOk());
    }


}
