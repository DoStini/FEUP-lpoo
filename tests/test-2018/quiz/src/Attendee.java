public class Attendee extends Person {

    private boolean paid;

    public Attendee(String name, int age) {
        super(name, age);
        paid = false;
    }

    public Attendee(String name) {
        this(name, 0);
    }

    public boolean hasPaid() {
        return paid;
    }

    @Override
    public String toString() {
        return "Attendee " + getName() + (hasPaid() ? " has" : " hasn't") + " paid its registration.";
    }
}
