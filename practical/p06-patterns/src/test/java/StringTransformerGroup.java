import java.util.List;
import string.*;

public class StringTransformerGroup implements StringTransformer {

    private List<StringTransformer> transformers;

    public StringTransformerGroup(List<StringTransformer> transformers) {
        this.transformers = transformers;
    }

    @Override
    public void execute(StringDrink drink) {
        for (StringTransformer strt: transformers)
            strt.execute(drink);
    }
}
