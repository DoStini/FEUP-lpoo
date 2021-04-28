import java.util.ArrayList;
import java.util.List;

public class MediumPizza implements Pizza {

    private List<Ingredient> ingredientList = new ArrayList<>();
    private double price;

    @Override
    public boolean addIngredient(Ingredient ingredient) {
        if (ingredientList.contains(ingredient))
            return false;

        ingredientList.add(ingredient);
        return true;
    }

    @Override
    public List<Ingredient> getIngredients() {
        return ingredientList;
    }

    @Override
    public int getIngredientCount() {
        return ingredientList.size();
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }


}
