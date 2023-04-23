package View.Commands;

import View.Console;

public class Load extends Command{

    private String desription = "Загрузить данные из файла";


    public Load(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return desription;
    }

    @Override
    public void execute() {
        getConsole().loadFile();
    }
    
}
