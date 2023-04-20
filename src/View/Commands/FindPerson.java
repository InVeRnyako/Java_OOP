package View.Commands;

import View.Console;

public class FindPerson  extends Command{

    private String desription = "Найти человека по имени.";

    public FindPerson(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return desription;
    }

    @Override
    public void execute() {
        // Запросить имя
        getConsole().print("Введите имя:");
        String nameToLookFor = getConsole().read();
        if (nameToLookFor.equals(""))
            getConsole().fail();
        else{
            // Найти человека по имени
            Integer id = getConsole().findPerson(nameToLookFor);
            // Перейти в меню человека и передать туда id
            if (id == null)
                getConsole().print("Совпадений нет");
            else{
                getConsole().findPersonSubmenu(id);
            }
        }

        
    }
    
}
