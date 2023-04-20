package View.Commands.FindPersonCommands;

import View.Console;
import View.Commands.FindPersonCommand;

public class RemovePerson extends FindPersonCommand {
    private String desription = "Удалить человека из данных";
    private Integer personId;

    public RemovePerson(Integer personId, Console console) {
        super(personId, console);
        this.personId = personId;
    }

    @Override
    public String getDescription() {
        return desription;
    }

    @Override
    public void execute() {
        getConsole().removePerson(personId);
        getConsole().quit();
    }

}
