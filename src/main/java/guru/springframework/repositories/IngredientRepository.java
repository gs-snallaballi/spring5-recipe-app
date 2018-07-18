package guru.springframework.repositories;

import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Saiteja on 7/18/18
 */
public interface IngredientRepository extends CrudRepository<Ingredient,Long> {

    List<Ingredient> findAllByRecipe(Recipe recipe);

}
