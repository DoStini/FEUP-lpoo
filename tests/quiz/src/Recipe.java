import java.util.ArrayList;
import java.util.List;

public abstract class Recipe {
    protected List<Ingredient> ingredientList = new ArrayList<>();

    public Recipe() {
        this.ingredientList = new ArrayList<>();
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public Pizza makeMediumPizza() {
        Pizza pizza = new MediumPizza();

        for (Ingredient ing: ingredientList) {
            pizza.addIngredient(ing);
        }

        return pizza;
    };
}
