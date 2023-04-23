package View.Commands;

import View.Console;

public abstract class FindPersonCommand{

    private Console console;

    public FindPersonCommand(Console console){
        this.console = console;
    }

    public Console getConsole(){
        return console;
    }

    public abstract String getDescription();
    public abstract void execute(Integer id);
}

