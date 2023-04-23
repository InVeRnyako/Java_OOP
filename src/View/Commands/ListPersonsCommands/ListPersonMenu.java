package View.Commands.ListPersonsCommands;

import java.util.ArrayList;
import java.util.List;

import View.Console;
import View.Commands.Command;

public class ListPersonMenu{

    private List<Command> listPersonsCommands;

    public ListPersonMenu(Console console){
        listPersonsCommands = new ArrayList<>();
        listPersonsCommands.add(new SortedByBirthDate(console));
        listPersonsCommands.add(new SortedByName(console));
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("=== Выберите способ сортировки: \n");
        String prefix = "";
        for (int i = 0; i < listPersonsCommands.size(); i++) {
            stringBuilder.append(prefix);
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(listPersonsCommands.get(i).getDescription());
            prefix = "\n";
        }
        return stringBuilder.toString();
    }

    public void execute(Integer choice){
        listPersonsCommands.get(choice - 1).execute();
        
    }

    public int getCommandsAmount(){
        return listPersonsCommands.size();
    }


}
