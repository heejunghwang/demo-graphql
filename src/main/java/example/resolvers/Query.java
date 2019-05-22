package example.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import example.repository.PetRepository;
import example.animal.Animal;
import example.animal.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hwang on 21/05/2019.
 */
@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private PetRepository petRepository;

    public List<Pet> pets() {
//        List<Pet> pets = new ArrayList<>();
//        Pet aPet = new Pet();
//        aPet.setId(1l);
//        aPet.setName("Bill");
//        aPet.setAge(9);
//        aPet.setType(Animal.MAMMOTH);
//        pets.add(aPet);
        return petRepository.findAll();
//        return pets;
    }
}