package View;

import java.util.Scanner;

import Presenter.Presenter;
import View.Commands.FindPersonCommands.FindPersonMenu;

public class Console implements View {

    private Presenter presenter;
    private Scanner scanner;
    private Boolean work = true;
    private Menu menu;
    private FindPersonMenu findPersonMenu;

    public Console() {
        scanner = new Scanner(System.in);
        menu = new Menu(this);
    }

    @Override
    public void print(String outString) {
        System.out.println(outString);
    }

    @Override
    public void start() {
        while (work) {
            print((menu.print()));
            String choice = scanner.nextLine();
            if (checkMain(choice)) {
                menu.execute(Integer.parseInt(choice));
            } else {
                fail();
            }
        }
    }

    public void findPersonSubmenu(Integer personId){
        findPersonMenu = new FindPersonMenu(this, personId);
        while (work) {
            print(findPersonMenu.print());
            String choice = scanner.nextLine();
            if (checkFindPerson(choice)){
                findPersonMenu.execute(Integer.parseInt(choice));
            }
        }
        work = true;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    private Boolean checkMain(String toCheck) {
        return toCheck.matches("[0-9]+") && Integer.parseInt(toCheck) - 1 < menu.getCommandsAmount()
                && Integer.parseInt(toCheck) > 0;
    }

    private Boolean checkFindPerson(String toCheck){
        return toCheck.matches("[0-9]+") && Integer.parseInt(toCheck) - 1 < findPersonMenu.getCommandsAmount()
                && Integer.parseInt(toCheck) > 0;
        
    }

    public void fail() {
        System.out.println("Ошибка ввода.");
    }

    public void listPersons(){
        System.out.println(presenter.listPersons());
    }

    public void quit(){
        work = false;
    }

    public void loadTestTree() {
        presenter.loadTestTree();
    }

    public String read(){
        return scanner.nextLine();
    }

    public Boolean addPerson(String fullName, String yearOfBirth, String yearOfDeath){
        return presenter.addPerson(fullName, yearOfBirth, yearOfDeath);
    }

    public Integer findPerson(String nameToLookFor){
        return presenter.findPerson(nameToLookFor);
    }

    public void removePerson(Integer personId) {
        presenter.removePerson(personId);
    }
}
