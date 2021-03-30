package main;

import java.util.LinkedList;
import java.util.Stack;

public class IcecreamMachine {
    private Icecream icescream;
    Stack<Command> commands;

    public IcecreamMachine(Icecream icescream) {
        this.commands = new Stack<>();
        this.icescream = icescream;
    }

    public IcecreamMachine executeCommand(Command command) {
        command.execute(icescream);
        commands.push(command);
        return this;
    }

    public void undoLastCommand() {
        if (!commands.empty()) {
            Command cmd = commands.pop();
            cmd.undo();
        }
    }
}
