package client;
import bar.Bar;
import bar.StringBar;
import strategy.OrderingStrategy;
import string.*;

public class HumanClient implements Client {

    OrderingStrategy strat;

    public HumanClient(OrderingStrategy strat) {
        this.strat = strat;
    }

    @Override
    public void happyHourStarted(Bar bar) {
        strat.happyHourStarted((StringBar) bar);
    }

    @Override
    public void happyHourEnded(Bar bar) {
        strat.happyHourEnded((StringBar) bar);
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        strat.wants(drink, recipe, bar);
    }
}
