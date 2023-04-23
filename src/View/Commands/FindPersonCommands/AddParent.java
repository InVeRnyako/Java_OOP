package View.Commands.FindPersonCommands;

import View.Console;
import View.Commands.FindPersonCommand;

public class AddParent extends FindPersonCommand {

    private String desription = "Выбрать родителя";

    public AddParent(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return desription;
    }

    @Override
    public void execute(Integer personId) {
        Integer idToLink = getConsole().getFindPerson().justId();
        if (idToLink != null)
            getConsole().addPerent(personId, idToLink);
    }
}
