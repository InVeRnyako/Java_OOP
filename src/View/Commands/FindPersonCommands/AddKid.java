package View.Commands.FindPersonCommands;

import View.Console;
import View.Commands.FindPersonCommand;

public class AddKid extends FindPersonCommand {

    private String desription = "Выбрать ребенка";

    public AddKid(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return desription;
    }

    @Override
    public void execute(Integer personId) {
        Integer idToLink = getConsole().getFindPerson().justId();
        if (idToLink != null) {
            getConsole().addKid(personId, idToLink);
        }
    }
}
