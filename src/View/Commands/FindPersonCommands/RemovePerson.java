package View.Commands.FindPersonCommands;

import View.Console;
import View.Commands.FindPersonCommand;

public class RemovePerson extends FindPersonCommand {


    private String desription = "Удалить человека из данных";

    public RemovePerson(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return desription;
    }

    @Override
    public void execute(Integer personId) {
        getConsole().removePerson(personId);
        getConsole().quit();
    }

}
