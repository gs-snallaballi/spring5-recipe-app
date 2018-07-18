package guru.springframework;

import guru.springframework.domain.*;
import guru.springframework.repositories.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Saiteja on 7/18/18
 */
@Component
public class Intializer{

    private RecipeRepository recipeRepository;
    private IngredientRepository ingredientRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private CategoryRepository categoryRepository;
    private NotesRepository notesRepository;

    public Intializer(RecipeRepository recipeRepository, IngredientRepository ingredientRepository, UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository, NotesRepository notesRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
        this.notesRepository=notesRepository;
    }

    void init(){
        Recipe recipe=new Recipe();
        recipe.setCookTime(5);
        recipe.setDescription("Perfect Guacamole");
        recipe.setDifficulty(Difficulty.EASY);
        recipe.setDirections("direction");

        Ingredient ingredient=new Ingredient();
        Ingredient ingredient1=new Ingredient();

        ingredient.setDescription("Avocados");
        ingredient.setAmount(BigDecimal.valueOf(2));
        ingredient.setRecipe(recipe);

        ingredient1.setDescription("Salt");
        ingredient1.setAmount(BigDecimal.valueOf(0.5));
        UnitOfMeasure unitOfMeasure=unitOfMeasureRepository.findByDescription("Tablespoon");

        Category category=categoryRepository.findByDescription("American");
        Category category1=categoryRepository.findByDescription("Fast Food");

        Set<Category> categorySet=new HashSet<>();
        categorySet.add(category);
        categorySet.add(category1);

        ingredient1.setUom(unitOfMeasure);
        ingredient1.setRecipe(recipe);

        Notes notes=new Notes();
        notes.setRecipe(recipe);
        notes.setRecipeNotes("Perfect Guacamole Notes");

        recipe.setCategories(categorySet);
        recipeRepository.save(recipe);
        notesRepository.save(notes);
        ingredientRepository.save(ingredient);
        ingredientRepository.save(ingredient1);

    }

    public static void main(String[] args) {

    }
}
