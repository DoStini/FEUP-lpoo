package client;
import bar.BarObserver;
import bar.StringBar;
import string.*;

public interface Client extends BarObserver {
    void wants(StringDrink drink, StringRecipe recipe, StringBar bar);
}
