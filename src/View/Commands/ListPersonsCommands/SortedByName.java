package View.Commands.ListPersonsCommands;

import View.Console;
import View.Commands.Command;

public class SortedByName extends Command {

    private String description = "Сортировка по имени";

    public SortedByName(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void execute() {
        getConsole().showListSortedByName();
    }
    
}
