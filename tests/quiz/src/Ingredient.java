public class Ingredient {
    private String name;
    public Ingredient(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!obj.getClass().equals(Ingredient.class))
            return false;

        return ((Ingredient) obj).getName().equals(name);
    }

    public String getName() {
        return name;
    }
}
