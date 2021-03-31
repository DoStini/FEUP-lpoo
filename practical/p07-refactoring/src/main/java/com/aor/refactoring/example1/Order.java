package com.aor.refactoring.example1;

import java.util.ArrayList;
import java.util.List;

public class Order implements HasValue {
    private List<OrderLine> lines;
    private double value = 0;

    public Order() {
        lines = new ArrayList<>();
    }

    public void add(Product product, int quantity) {
        OrderLine orderLine = new OrderLine(product, quantity);
        lines.add(orderLine);
        value += orderLine.value();
    }

    @Override
    public double value() {
        return value;
    }

    public boolean isElegibleForFreeDelivery() {
        return value > 100;
    }

    public String printOrder() {
        StringBuffer printBuffer = new StringBuffer();

        for (OrderLine line : lines)
            printBuffer.append(line);

        printBuffer.append("Total: " + value);

        return printBuffer.toString();
    }
}