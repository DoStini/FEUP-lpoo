package shape;

public class Circle implements AreaShape {

    @Override
    public double getArea() {
        return Math.PI * Math.pow(getRadius(), 2);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle");
    }

    private double radius;
}
