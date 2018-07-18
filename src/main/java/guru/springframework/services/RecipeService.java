package guru.springframework.services;

import guru.springframework.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Saiteja on 7/18/18
 */

public interface RecipeService {
    List<Recipe> getRecipes();

}
