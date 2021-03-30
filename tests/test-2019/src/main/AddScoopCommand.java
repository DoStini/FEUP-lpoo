package main;

import java.util.Stack;

public class AddScoopCommand extends Command {
    private Flavor flavor;

    public AddScoopCommand(Flavor flavor) {
        super();
        this.flavor = flavor;
    }

    @Override
    public void undo() {
        Icecream icecream = icecreams.pop();
        icecream.removeScoop(flavor);
    }

    @Override
    public void execute(Icecream icecream) {
        icecream.addScoop(flavor);
        icecreams.push(icecream);
    }
}
