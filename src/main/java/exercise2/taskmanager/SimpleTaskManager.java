package exercise2.taskmanager;

import exercise2.Initializer.InitializeWithFile;
import exercise2.Initializer.InitializerType;
import exercise2.objects.SaveObject;
import exercise2.output.SimpleOutputDatabase;
import exercise2.output.SimpleOutputFile;
import exercise2.creator.*;
import exercise2.displayer.ConcreteDisplay;
import exercise2.displayer.Displayer;
import exercise2.displayer.SimpleDisplay;
import exercise2.output.Output;

public class SimpleTaskManager implements TaskManager {
    InitializerType initializerType;
    Displayer displayer;
    Output output;
    SaveObject myObject;
    CreatorUser creatorUser;
    CreatorTask creatorTask;
    String[] args;
    public SimpleTaskManager(String[] args){
        initializerType = new InitializeWithFile();
        output = new SimpleOutputDatabase();
        this.args = args;
    }

    @Override
    public void start() {
        if (args.length == 0){
//            args = new String[]{"-addGroupTask", "-un=Task1", "-un=to do task1", "-un=userName1", "-un=userName2"};
//            args = new String[]{"-showAllUsers"};
            args = new String[]{"-showAllUsers", "-un=userName2"};
        }

        myObject = initializerType.initialize();
        args();
        writeFile();
    }

    public void writeFile() { output.output(this.myObject); }
    public void display(){ displayer.display(); }
    SaveObject createUser(){ return creatorUser.createUser(); }
    SaveObject createTask(){ return creatorTask.createTask(); }

    void args(){
        switch (args[0]){
            case "-createUser":
                creatorUser = new SimpleCreatorUser(args, myObject);
                myObject = createUser();
                break;
            case "-showAllUsers":
                displayer = new SimpleDisplay(myObject);
                display();
                break;
            case "-addTask":
                creatorTask = new SimpleCreatorTask(args, myObject);
                myObject = createTask();
                break;
            case "-showTasks":
                displayer = new ConcreteDisplay(myObject, args[1].substring(4));
                display();
                break;
            case "-addGroupTask":
                creatorTask = new GroupCreatorTask(args, myObject);
                myObject = createTask();
                break;
            default:
                System.out.println(args[0]);
                System.out.println("-createUser|-showAllUsers|-addTask|-showTasks|-addGroupTask");
        }
    }
}
