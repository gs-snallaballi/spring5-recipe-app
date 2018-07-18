package guru.springframework.controllers;

import guru.springframework.domain.Category;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import guru.springframework.services.IngredientService;
import guru.springframework.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by jt on 6/1/17.
 */
@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeService recipeService;
    private IngredientService ingredientService;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeService recipeService, IngredientService ingredientService) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {

        Category categoryOptional = categoryRepository.findByDescription("American");
        UnitOfMeasure unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Cat Id is: " + categoryOptional.getId());
        System.out.println("UOM ID is: " + unitOfMeasureOptional.getId());

        return "index";
    }

    @RequestMapping("/recipes")
    public String showRecipes(Model model) {
        List<Recipe> recipes = recipeService.getRecipes();
        System.out.println("Recipes List: "+recipes);
        Map<Recipe, List<Ingredient>> recipeIngredients=new HashMap<>();
        for (int i = 0; i < recipes.size(); i++) {
            List<Ingredient> ingredients = ingredientService.findAllIngredients(recipes.get(i));
            System.out.println("Ingredients for "+recipes.get(i).getDescription()+" are: "+ ingredients);
            recipeIngredients.put(recipes.get(i), ingredients);
        }
        model.addAttribute("recipes",recipeIngredients);
        return "recipe";
    }
}
