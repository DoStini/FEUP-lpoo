public abstract class Person extends User implements Comparable{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person(String name, Integer age) {
        super(name, age);
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this(name, 0);
    }

    @Override
    public int compareTo(Object o) {
        if (o.equals(this))
            return 0;
        return name.compareTo(((Person) o).name);
    }
}