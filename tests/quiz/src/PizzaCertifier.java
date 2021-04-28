import java.util.ArrayList;
import java.util.List;

public abstract class PizzaCertifier {

    protected List<Ingredient> ingredientList = new ArrayList<>();

    protected Recipe recipe;

    public PizzaCertifier() {
        this.ingredientList = new ArrayList<>();
    }

    public boolean isCertified(Pizza pizza) {

        if (pizza.getIngredientCount() != recipe.getIngredientList().size())
            return false;

        for (Ingredient ing : pizza.getIngredients()) {
            if (!recipe.getIngredientList().contains(ing))
                return false;
        }

        for (Ingredient ing : recipe.getIngredientList())
            if (!pizza.getIngredients().contains(ing))
                return false;
        return true;
    }

}
