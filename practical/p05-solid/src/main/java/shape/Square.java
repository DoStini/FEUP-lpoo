package shape;

public class Square implements AreaShape {
    private double side;

    @Override
    public double getArea() {
        return  Math.pow(getSide(), 2);
    }

    @Override
    public void draw() {
        System.out.println("Square");
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public Square(double side) {
        this.side = side;
    }
}
