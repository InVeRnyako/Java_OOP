package View.Commands.FindPersonCommands;

import View.Console;
import View.Commands.FindPersonCommand;

public class BackToMain extends FindPersonCommand{

    private String desription = "Вернуться в главное меню";

    public BackToMain(Console console) {
        super(console);
    }
    @Override
    public String getDescription() {
        return desription;
    }

    @Override
    public void execute(Integer personId) {
        getConsole().quit();
    }
}
