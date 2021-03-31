package com.aor.refactoring.example2;

public abstract class Shape {
    protected double x;
    protected double y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Shape createShape(int x, int y, int w, int h) {
        return new Rectangle(x,y,w,h);
    }

    public static Shape createShape(int x, int y, int r) {
        return new Circle(x,y,r);
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract void draw(GraphicFramework graphics);
}
