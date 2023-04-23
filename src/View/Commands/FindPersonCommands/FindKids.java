package View.Commands.FindPersonCommands;

import View.Console;
import View.Commands.FindPersonCommand;

public class FindKids extends FindPersonCommand{

    private String desription = "Показать список детей";

    public FindKids(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return desription;
    }

    @Override
    public void execute(Integer personId) {
        getConsole().findKids(personId);
    }
    
}
