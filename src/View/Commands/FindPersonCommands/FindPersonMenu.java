package View.Commands.FindPersonCommands;

import java.util.ArrayList;
import java.util.List;

import View.Console;
import View.Commands.FindPersonCommand;

public class FindPersonMenu {
    private List<FindPersonCommand> findPersonList;
    private Integer personId;

    public FindPersonMenu(Console console){
        findPersonList = new ArrayList<>();
        findPersonList.add(new AddParent(console));
        findPersonList.add(new AddKid(console));
        findPersonList.add(new FindKids(console));
        findPersonList.add(new FindParents(console));
        findPersonList.add(new RemovePerson(console));
        findPersonList.add(new BackToMain(console));
    }

    public void setPersonId(Integer id){
        this.personId = id;
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        String prefix = "=== Выберите действие с найденным человеком:\n";
        for (int i = 0; i < findPersonList.size(); i++) {
            stringBuilder.append(prefix);
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(findPersonList.get(i).getDescription());
            prefix = "\n";
        }
        return stringBuilder.toString();
    }

    public void execute(Integer choice){
        findPersonList.get(choice - 1).execute(personId);
    }

    public int getCommandsAmount(){
        return findPersonList.size();
    }
}
