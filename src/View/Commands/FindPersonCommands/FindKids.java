package View.Commands.FindPersonCommands;

import View.Console;
import View.Commands.FindPersonCommand;

public class FindKids extends FindPersonCommand{

    private String desription = "Показать список детей";

    public FindKids(Integer personId, Console console) {
        super(personId, console);
    }

    @Override
    public String getDescription() {
        return desription;
    }

    @Override
    public void execute() {
        // TODO
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }
    
}
