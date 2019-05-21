package example.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import example.animal.Pet;
import example.animal.PetInput;
import org.springframework.stereotype.Component;

/**
 * Created by hwang on 21/05/2019.
 */
@Component
public class Mutation implements GraphQLMutationResolver {

    public Pet createPet(PetInput petInput){
        //TODO
        return null;
    }
}
