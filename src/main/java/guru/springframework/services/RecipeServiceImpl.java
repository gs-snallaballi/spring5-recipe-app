package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Saiteja on 7/18/18
 */
@Service
public class RecipeServiceImpl implements RecipeService{

    private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> getRecipes() {
        return (List)recipeRepository.findAll();
    }
}
