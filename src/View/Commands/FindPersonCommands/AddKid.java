package View.Commands.FindPersonCommands;

import View.Console;
import View.Commands.FindPersonCommand;

public class AddKid extends FindPersonCommand{

    private String desription = "Выбрать ребенка";

    public AddKid(Integer personId, Console console) {
        super(personId, console);
    }

    @Override
    public String getDescription() {
        return desription;
    }

    @Override
    public void execute() {
        // (TODO)
        // найти ребенка
        // добавить родителя и ребенка в список
        
    }


    
}
