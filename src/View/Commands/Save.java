package View.Commands;

import View.Console;

public class Save extends Command{

    private String desription = "Сохранить данные в файл";


    public Save(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return desription;
    }

    @Override
    public void execute() {
        getConsole().saveFile();
    }
    
}
