package guru.springframework.services;

import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Saiteja on 7/18/18
 */
@Service
public class IngredientServiceImpl implements IngredientService {

    private IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> findAllIngredients(Recipe recipe) {

        return ingredientRepository.findAllByRecipe(recipe);
    }
}
