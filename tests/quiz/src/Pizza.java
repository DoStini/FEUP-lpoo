import java.util.List;

public interface Pizza {

    boolean addIngredient(Ingredient ingredient1);

    List<Ingredient> getIngredients();

    int getIngredientCount();

    double getPrice();

    void setPrice(double price);
}
