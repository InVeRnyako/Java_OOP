package Presenter;

import Model.TreeActions;
import View.View;

public class Presenter {

    private View view;
    private TreeActions service;

    public Presenter(View view, TreeActions service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
        service.setPresenter(this);
    }

    public String listPersons() {
        return service.showAll();
    }

    public void loadTestTree() {
        service.loadTestTree();
    }

    public Boolean addPerson(String fullName, String yearOfBirth, String yearOfDeath) {
        return service.addPersonByText(fullName, yearOfBirth, yearOfDeath);
    }

    public Integer findPerson(String nameToLookFor) {
        return service.findPersonIdByName(nameToLookFor);
    }

    public void removePerson(Integer personId) {
        service.removePerson(personId);
    }

    public String getPersonInfo(Integer personId) {
        return service.getPersonInfo(personId);
    }

    public String showListSortedByName() {
        return service.sortByNameString();
    }

    public String showListSortedByBirthDate() {
        return service.sortByBirthDateString();
    }

    public void addKid(Integer personId, Integer idToLink) {
        service.addParent(idToLink, personId);
    }

    public void addParent(Integer personId, Integer idToLink) {
        service.addParent(personId, idToLink);
    }

    public String findParents(Integer personId) {
        return service.findParents(personId);
    }

    public String findKids(Integer personId) {
        return service.findKids(personId);
    }

    public String loadFile() {
        return service.loadFile();
    }

    public String saveFile() {
        return service.saveFile();
    }

}
