package exercise2.Initializer;

import exercise2.objects.SaveObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileInitialize implements InitializerFile {
    @Override
    public SaveObject initialize() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("save.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (SaveObject) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
