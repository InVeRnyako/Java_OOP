package View.Commands.FindPersonCommands;

import java.util.ArrayList;
import java.util.List;

import View.Console;
import View.Commands.FindPersonCommand;

public class FindPersonMenu {
    private List<FindPersonCommand> findPersonList;

    public FindPersonMenu(Console console, Integer personId){
        findPersonList = new ArrayList<>();
        findPersonList.add(new AddParent(personId, console));
        findPersonList.add(new AddKid(personId, console));
        findPersonList.add(new FindKids(personId, console));
        findPersonList.add(new RemovePerson(personId, console));
        findPersonList.add(new BackToMain(null, console));
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < findPersonList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(findPersonList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(Integer choice){
        findPersonList.get(choice - 1).execute();
    }

    public int getCommandsAmount(){
        return findPersonList.size();
    }
}
