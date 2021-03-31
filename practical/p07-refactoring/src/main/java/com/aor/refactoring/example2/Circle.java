package com.aor.refactoring.example2;

public class Circle extends Shape {
    private double radius;

    public Circle(int x, int y, int r) {
        super(x, y);
        radius = r;
    }

    @Override
    public double getArea() {
        return Math.PI*Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public void draw(GraphicFramework graphics) {
        graphics.drawCircle(x, y, radius);
    }
}
