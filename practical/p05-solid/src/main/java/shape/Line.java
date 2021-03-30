package shape;

public class Line implements Shape {
    private double lenght;

    public double getLenght() {
        return lenght;
    }

    public void setLenght(double lenght) {
        this.lenght = lenght;
    }

    public Line(double lenght) {
        this.lenght = lenght;
    }

    @Override
    public void draw() {
        System.out.println("Line");
    }
}
