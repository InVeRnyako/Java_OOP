package View.Commands;

import View.Console;

public abstract class FindPersonCommand extends Command{

    Integer personId;

    public FindPersonCommand(Integer personId, Console console) {
        super(console);
    }


    
}
