package example.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import example.animal.Animal;
import example.animal.Pet;
import example.shoes.Brand;
import example.shoes.Shoes;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hwang on 21/05/2019.
 */
@Component
public class Query implements GraphQLQueryResolver {

    public List<Pet> pets() {
        List<Pet> pets = new ArrayList<>();
        Pet aPet = new Pet();
        aPet.setId(1l);
        aPet.setName("Bill");
        aPet.setAge(9);
        aPet.setType(Animal.MAMMOTH);
        pets.add(aPet);
        return pets;
    }

    public List<Shoes> getShoes(){
        List<Shoes> shoesList = new ArrayList<>();
        Shoes shoes = new Shoes();
        shoes.setBrand(Brand.ADIDAS);
        shoes.setName("limited edition");
        shoes.setId(1234);
        shoesList.add(shoes);
        return shoesList;
    }
}