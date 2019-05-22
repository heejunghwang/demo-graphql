package example.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import example.animal.Pet;
import example.animal.PetInput;
import example.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by hwang on 21/05/2019.
 */
@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private PetRepository petRepository;

    public Pet createPet(PetInput petInput){
        Pet pet = new Pet();
        pet.setAge(petInput.getAge());
        pet.setName(petInput.getName());
        pet.setType(petInput.getType());
        return petRepository.save(pet);
    }
}
