package exercise2.output;

import exercise2.objects.SaveObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SimpleOutputFile implements Output {
    @Override
    public void output(SaveObject myObject) {
        try {
            FileOutputStream outputStream = new FileOutputStream("save.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(myObject);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
