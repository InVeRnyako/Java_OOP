package Model;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SaveFile implements Serializable {
    private String saveFileName;
    private String path = System.getProperty("user.dir");
    private String result;

    public SaveFile(String saveName) {
        saveFileName = path.concat("/" + saveName + ".data");
    }

    public SaveFile() {
        saveFileName = path.concat("/test.data");
    }

    public void saveData(Object objectToSave) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveFileName))) {
            oos.writeObject(objectToSave);
            result = "Данные успешно сохранены";
        } catch (Exception ex) {
            result = "Ошибка: " + ex.getMessage();
        }

    }

    public String getResult(){
        return result;
    }

    public Object readData() {
        Object importObject = new Tree();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(saveFileName))) {
            importObject = ois.readObject();
            result = "Данные из файла успешно загружены.";
        } catch (Exception ex) {
            result = "Ошибка считывания файла: " + ex.getMessage();
        }
        return importObject;
    }

}
