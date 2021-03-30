
import org.junit.jupiter.api.Test;
import string.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringDrinkTest {
    @Test
    public void stringDrink() {
        StringDrink drink = new StringDrink("ABCD");
        assertEquals("ABCD", drink.getText());
        drink.setText("DCBA");
        assertEquals("DCBA", drink.getText());
    }
}
