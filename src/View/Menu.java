package View;

import java.util.ArrayList;
import java.util.List;

import View.Commands.*;

public class Menu {
    private List<Command> mainMenuList;

    public Menu(Console console){
        mainMenuList = new ArrayList<>();
        mainMenuList.add(new ListPersons(console));
        mainMenuList.add(new FindPerson(console));
        mainMenuList.add(new AddPerson(console));
        mainMenuList.add(new Save(console));
        mainMenuList.add(new Load(console));
        mainMenuList.add(new LoadTestTree(console));
        mainMenuList.add(new Quit(console));
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        String prefix = "=== Главное меню.\n";
        for (int i = 0; i < mainMenuList.size(); i++) {
            stringBuilder.append(prefix);
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(mainMenuList.get(i).getDescription());
            prefix = "\n";
        }
        return stringBuilder.toString();
    }

    void execute(int choice){
        mainMenuList.get(choice - 1).execute();
    }

    public int getCommandsAmount(){
        return mainMenuList.size();
    }
}
