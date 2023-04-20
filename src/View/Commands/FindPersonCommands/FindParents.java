package View.Commands.FindPersonCommands;

import View.Console;
import View.Commands.Command;
import View.Commands.FindPersonCommand;

public class FindParents extends FindPersonCommand {

    private String desription = "Показать список родителей";

    public FindParents(Integer personId, Console console) {
        super(personId, console);
    }

    @Override
    public String getDescription() {
        return desription;
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

}
