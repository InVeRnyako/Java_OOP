package View.Commands.FindPersonCommands;

import View.Console;
import View.Commands.FindPersonCommand;

public class AddParent extends FindPersonCommand{

    private String desription = "Выбрать родителя";

    public AddParent(Integer personId, Console console) {
        super(personId, console);
    }

    @Override
    public String getDescription() {
        return desription;
    }

    @Override
    public void execute() {
        // (TODO)
        // найти родителя
        // добавить родителя и ребенка в список
        
    }


    
}
