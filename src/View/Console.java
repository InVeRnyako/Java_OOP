package View;

import java.util.Scanner;

import Presenter.Presenter;
import View.Commands.FindPerson;
import View.Commands.FindPersonCommands.FindPersonMenu;
import View.Commands.ListPersonsCommands.ListPersonMenu;

public class Console implements View {

    private Presenter presenter;
    private Scanner scanner;
    private Boolean work = true;
    private Menu menu;
    private FindPersonMenu findPersonMenu;
    private ListPersonMenu listPersonMenu;
    private FindPerson findPerson;

    public Console() {
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        findPersonMenu = new FindPersonMenu(this);
        listPersonMenu = new ListPersonMenu(this);
        findPerson = new FindPerson(this);
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

    public void findPersonSubmenu(Integer personId) {
        findPersonMenu.setPersonId(personId);
        while (work) {
            print(findPersonMenu.print());
            String choice = scanner.nextLine();
            if (checkFindPerson(choice)) {
                findPersonMenu.execute(Integer.parseInt(choice));
            }
        }
        work = true;
    }

    public void listPersonsMenu() {
        while (work) {
            print(listPersonMenu.print());
            String choice = scanner.nextLine();
            if (checkListPersonsMenu(choice)) {
                listPersonMenu.execute(Integer.parseInt(choice));
            }
        }
        work = true;
    }

    public String getPersonInfo(Integer personId) {
        return presenter.getPersonInfo(personId);
    }

    public FindPerson getFindPerson() {
        return findPerson;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    private Boolean checkMain(String toCheck) {
        return toCheck.matches("[0-9]+") && Integer.parseInt(toCheck) - 1 < menu.getCommandsAmount()
                && Integer.parseInt(toCheck) > 0;
    }

    private Boolean checkFindPerson(String toCheck) {
        return toCheck.matches("[0-9]+") && Integer.parseInt(toCheck) - 1 < findPersonMenu.getCommandsAmount()
                && Integer.parseInt(toCheck) > 0;
    }

    private Boolean checkListPersonsMenu(String toCheck) {
        return toCheck.matches("[0-9]+") && Integer.parseInt(toCheck) - 1 < listPersonMenu.getCommandsAmount()
                && Integer.parseInt(toCheck) > 0;
    }

    public void fail() {
        print("Ошибка ввода.");
    }

    public void listPersons() {
        print(presenter.listPersons());
    }

    public void quit() {
        work = false;
    }

    public void loadTestTree() {
        presenter.loadTestTree();
    }

    public String read() {
        return scanner.nextLine();
    }

    public Boolean addPerson(String fullName, String yearOfBirth, String yearOfDeath) {
        return presenter.addPerson(fullName, yearOfBirth, yearOfDeath);
    }

    public Integer findPerson(String nameToLookFor) {
        return presenter.findPerson(nameToLookFor);
    }

    public void removePerson(Integer personId) {
        presenter.removePerson(personId);
    }

    public void showListSortedByBirthDate() {
        print(presenter.showListSortedByBirthDate());
        quit();
    }

    public void showListSortedByName() {
        print(presenter.showListSortedByName());
        quit();
    }

    public void addKid(Integer personId, Integer idToLink) {
        presenter.addKid(personId, idToLink);
    }

    public void addPerent(Integer personId, Integer idToLink) {
        presenter.addParent(personId, idToLink);
    }

    public void findParents(Integer personId) {
        if (personId == null)
            print("ОШИБКА");
        String parents = presenter.findParents(personId);
        if (parents != null)
            print(parents);
        else
            print("<Нет>");
    }

    public void findKids(Integer personId) {
        if (personId == null)
            print("ОШИБКА");
        String kids = presenter.findKids(personId);
        if (kids != null)
            print(kids);
        else
            print("<Нет>");
    }

    public void loadFile() {
        print(presenter.loadFile());
    }

    public void saveFile() {
        print(presenter.saveFile());
    }
}
