package View.Commands;

import View.Console;

public class FindPerson extends Command {

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
        Integer id = justId();
        if (id == null)
            getConsole().print("Совпадений нет");
        else {
            getConsole().print(getConsole().getPersonInfo(id));
            getConsole().findPersonSubmenu(id);
        }
    }

    public Integer justId() {
        getConsole().print("Введите имя:");
        String nameToLookFor = getConsole().read();
        Integer id = null;
        if (nameToLookFor.equals(""))
            getConsole().fail();
        else {
            id = getConsole().findPerson(nameToLookFor);
        }
        return id;
    }

}
