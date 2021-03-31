package com.aor.refactoring.example1;

public class OrderLine implements HasValue {
    private Product product;
    private int quantity;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return product.getName() + "(x" + quantity + "): " + (value()) + "\n";
    }

    @Override
    public double value() {
        return product.getPrice()*quantity;
    }
}
