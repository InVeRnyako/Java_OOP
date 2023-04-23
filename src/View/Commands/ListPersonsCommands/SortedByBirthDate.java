package View.Commands.ListPersonsCommands;

import View.Console;
import View.Commands.Command;

public class SortedByBirthDate extends Command {

    private String desription = "Сортировка по дате рождения";

    public SortedByBirthDate(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return desription;
    }

    @Override
    public void execute() {
        getConsole().showListSortedByBirthDate();
    }
    
}
