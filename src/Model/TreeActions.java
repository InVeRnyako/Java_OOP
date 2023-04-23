package Model;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import Model.Person.Person;
import Model.Person.PersonComparatorByBirthDate;
import Model.Person.PersonComparatorByName;
import Presenter.Presenter;

public class TreeActions<E extends Person> implements TreeData {
    Tree<E> tree;
    Presenter presenter;

    public TreeActions(Tree<E> tree) {
        this.tree = tree;
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public TreeActions() {
        this.tree = new Tree<E>();
    }

    @Override
    public String saveFile() {
        SaveFile sf = new SaveFile();
        sf.saveData(tree);
        return sf.getResult();
    }

    @Override
    public String loadFile() {
        SaveFile sf = new SaveFile();
        Object dataFromFile = sf.readData();
        if (dataFromFile instanceof Tree) {
            Tree<E> readTree = new Tree<>();
            readTree = (Tree) (dataFromFile);
            tree.setParentsData(readTree.getParentsData());
            tree.setEData(readTree.getEData());
        }
        return sf.getResult();
    }

    public String showAll() {
        StringBuilder outputString = new StringBuilder();
        String prefix = "";
        for (E e : tree.getEData()) {
            outputString.append(prefix);
            outputString.append(e);
            prefix = "\n";
        }
        return outputString.toString();
    }

    public List<E> sortByName() {
        List<E> outList = new ArrayList<E>(tree.getEData());
        outList.sort(new PersonComparatorByName());
        return outList;
    }

    public String sortByNameString() {
        return listToFormatedString(sortByName());
    }

    public List<E> sortByBirthDate() {
        List<E> outList = new ArrayList<E>(tree.getEData());
        outList.sort(new PersonComparatorByBirthDate());
        return outList;
    }

    public String sortByBirthDateString() {
        return listToFormatedString(sortByBirthDate());
    }

    private String listToFormatedString(List<E> list) {
        StringBuilder out = new StringBuilder();
        String prefix = "";
        for (E e : list) {
            out.append(prefix);
            out.append(e.toString());
            prefix = "\n";
        }
        return out.toString();
    }

    public HashSet<Integer> findAllKidsId(Integer parentId) {
        HashSet<Integer> kidsIdSet = new HashSet<>();
        for (Parent parentKidPair : tree.getParentsData()) {
            if (parentId.equals(parentKidPair.getIdParent())) {
                kidsIdSet.add(parentKidPair.getIdKid());
            }
        }
        return kidsIdSet;
    }

    public HashSet<Integer> findAllParentsId(Integer kidId) {
        HashSet<Integer> parentsIdSet = new HashSet<>();
        for (Parent parentKidPair : tree.getParentsData()) {
            if (kidId.equals(parentKidPair.getIdKid()))
                parentsIdSet.add(kidId);
        }
        return parentsIdSet;
    }

    public HashSet<E> idToPersonSet(HashSet<Integer> inputIdSet) {
        HashSet<E> outSet = new HashSet<>();
        for (E person : tree.getEData()) {
            if (inputIdSet.contains(person.getId()))
                outSet.add(person);
        }
        return outSet;
    }

    public E findPersonByName(String nameInput) {
        for (E person : tree.getEData()) {
            if (person.getName().contains(nameInput))
                return person;
        }
        return null;
    }

    public Integer findPersonIdByName(String nameToLookFor) {
        for (E person : tree.getEData())
            if (person.getName().toLowerCase().contains(nameToLookFor.toLowerCase()))
                return person.getId();
        return null;
    }

    public void addE(E newPerson) {
        if (newPerson == null)
            return;
        tree.getEData().add(newPerson);
    }

    public void addPerson(Person newPerson) {
        if (newPerson == null)
            return;
        tree.getEData().add((E) newPerson);
    }

    public Boolean addPersonByText(String fullName, String yearOfBirth, String yearOfDeath) {
        if (fullName.equals(""))
            fullName = null;
        E personToadd = (E) new Person(getFreeId(), fullName);
        if (yearOfBirth.equals(""))
            personToadd.setBirthYear(null);
        else
            personToadd.setBirthYear(Year.parse(yearOfBirth));
        if (yearOfDeath.equals(""))
            personToadd.setDeathYear(null);
        else
            personToadd.setDeathYear(Year.parse(yearOfDeath));
        addPerson(personToadd);

        return true;
    }

    public void removePerson(Integer indexToRemove) {
        tree.getEData().removeIf((t) -> t.getId().equals(indexToRemove));
    }

    public void addParent(Integer kidId, Integer parentId) {
        if (kidId != parentId)
            tree.getParentsData().add(new Parent(kidId, parentId));
    }

    public void loadTestTree() {
        tree = new Tree<>();
        addPerson(new Person(0, "Михаил Федорович", Year.of(1613), Year.of(1645)));
        addPerson(new Person(1, "Евдокия Стрешнева"));
        addPerson(new Person(2, "Мария Милославская"));
        addPerson(new Person(3, "Алексей Михайлович", Year.of(1645), Year.of(1676)));
        addParent(3, 0);
        addParent(3, 1);

        addPerson(new Person(4, "Наталья Нарышкина"));
        addPerson(new Person(5, "Федор Алексеевич", Year.of(1676), Year.of(1682)));
        addParent(5, 2);
        addParent(5, 3);

        addPerson(new Person(6, "Иван V", Year.of(1682), Year.of(1696)));
        addPerson(new Person(7, "Софья Алексеевна", Year.of(1682), Year.of(1689)));
        addParent(7, 2);
        addParent(7, 3);

        addPerson(new Person(8, "Евдокия Лопухина"));
        addPerson(new Person(9, "Петр I", Year.of(1682), Year.of(1725)));
        addParent(9, 3);
        addParent(9, 4);
    }

    public Integer getFreeId() {
        Integer id = 0;
        for (Person person : tree) {
            if (person.getId() != id)
                return id;
            id++;
        }
        return id;
    }

    public String getPersonInfo(Integer personId) {
        for (E person : tree.getEData()) {
            if (person.getId() == personId)
                return person.toString();
        }
        return null;
    }

    public String findParents(Integer personId) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Parent parentKidPair : tree.getParentsData()) {
            if (personId.equals(parentKidPair.getIdKid())) {
                stringBuilder.append(getPersonInfo(parentKidPair.getIdParent()));
                stringBuilder.append(", ");
            }
        }
        if (stringBuilder.length() > 0){
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length() - 1);
            return stringBuilder.toString();
        }
        else
            return null;
    }

    public String findKids(Integer personId) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Parent parentKidPair : tree.getParentsData()) {
            if (personId.equals(parentKidPair.getIdParent())){
                stringBuilder.append(getPersonInfo(parentKidPair.getIdKid()));
                stringBuilder.append(", ");
            }
        }
        if (stringBuilder.length()>0){
            stringBuilder.delete(stringBuilder.length() -2 , stringBuilder.length() -1 );
            return stringBuilder.toString();
        }
        return null;
    }

}
