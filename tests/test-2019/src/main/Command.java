package main;

import java.util.Stack;

public abstract class Command {

    protected Stack<Icecream> icecreams;

    public Command() {
        this.icecreams = new Stack<>();
    }

    public abstract void execute(Icecream icecream);

    public abstract void undo();
}
