package exercise2.Initializer;

import exercise2.objects.SaveObject;

import java.io.File;

public class InitializeWithFile implements InitializerType{
    InitializerFile initializerFile;
    @Override
    public SaveObject initialize() {
        File temp = new File("save.txt");
        if(!temp.exists()){
            initializerFile = new FileInitializeDefault();
        }else{
            initializerFile = new FileInitialize();
        }
        return initializerFile.initialize();
    }
}
