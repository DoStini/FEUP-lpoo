package string;

public class StringReplacer implements StringTransformer {
    private char a;
    private char x;

    public StringReplacer(char a, char x) {
        this.a = a;
        this.x = x;
    }

    @Override
    public void execute(StringDrink drink) {
        drink.setText(drink.getText().replace(a,x));
    }
}
