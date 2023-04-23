package View.Commands.FindPersonCommands;

import View.Console;
import View.Commands.FindPersonCommand;

public class FindParents extends FindPersonCommand {

    private String desription = "Показать список родителей";

    public FindParents(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return desription;
    }

    @Override
    public void execute(Integer personId) {
        getConsole().findParents(personId);
    }

}
