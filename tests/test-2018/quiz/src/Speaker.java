public class Speaker extends Person {
    public Speaker(String name, int age) {
        super(name, age);
        fee = 0;
    }

    private int fee;

    public Speaker(String name) {
        this(name, 0);
    }

    public int getFee() {
        return fee;
    }

    @Override
    public String toString() {
        return "Speaker " + getName() + " has a fee value of " + getFee() + ".";
    }
}
