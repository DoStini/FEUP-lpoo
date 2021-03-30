package shape;

public class Ellipse implements AreaShape {
    private double xRadius;
    private double yRadius;

    @Override
    public double getArea() {
        return Math.PI * getxRadius() * getyRadius();
    }

    public double getxRadius() {
        return xRadius;
    }

    public void setxRadius(double xRadius) {
        this.xRadius = xRadius;
    }

    public double getyRadius() {
        return yRadius;
    }

    public void setyRadius(double yRadius) {
        this.yRadius = yRadius;
    }

    @Override
    public void draw() {
        System.out.println("Ellipse");
    }

    public Ellipse(double xRadius, double yRadius) {
        this.xRadius = xRadius;
        this.yRadius = yRadius;
    }
}
