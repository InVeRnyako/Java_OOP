package View.Commands.FindPersonCommands;

import View.Console;
import View.Commands.FindPersonCommand;

public class BackToMain extends FindPersonCommand{

    private String desription = "Вернуться в главное меню";

    public BackToMain(Integer personId, Console console) {
        super(personId, console);
    }
    @Override
    public String getDescription() {
        return desription;
    }

    @Override
    public void execute() {
        getConsole().quit();
        
    }
}
