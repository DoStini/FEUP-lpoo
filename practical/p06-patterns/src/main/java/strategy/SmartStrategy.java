package strategy;

import bar.StringBar;
import string.*;

import java.util.LinkedList;
import java.util.Queue;

public class SmartStrategy implements OrderingStrategy{

    class Order {
        private StringDrink drink;
        private StringRecipe recipe;
        private StringBar bar;

        public Order(StringDrink drink, StringRecipe recipe, StringBar bar) {
            this.drink = drink;
            this.recipe = recipe;
            this.bar = bar;
        }

        public StringDrink getDrink() {
            return drink;
        }

        public StringRecipe getRecipe() {
            return recipe;
        }

        public StringBar getBar() {
            return bar;
        }
    }

    public SmartStrategy() {
        happyHour = false;
        this.orders = new LinkedList<Order>();
    }

    Queue<Order> orders;
    private boolean happyHour;

    private void order(StringBar bar) {
        while (!orders.isEmpty() && happyHour) {
            Order order = orders.poll();
            order.bar.order(order.drink, order.recipe);
        }
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        orders.add(new Order(drink, recipe, bar));
        if (bar.isHappyHour())
            order(bar);
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        happyHour = true;
        order(bar);
    }

    @Override
    public void happyHourEnded(StringBar bar) {
        happyHour = false;
    }
}
