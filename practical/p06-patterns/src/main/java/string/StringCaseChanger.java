package string;

public class StringCaseChanger implements StringTransformer{
    @Override
    public void execute(StringDrink drink) {
        StringBuilder str = new StringBuilder(drink.getText());
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (Character.isLowerCase(curr)) {
                str.replace(i, i+1, String.valueOf(Character.toUpperCase(curr)));
            }
            else {
                str.replace(i, i+1, String.valueOf(Character.toLowerCase(curr)));
            }
        }
        drink.setText(str.toString());
    }
}
