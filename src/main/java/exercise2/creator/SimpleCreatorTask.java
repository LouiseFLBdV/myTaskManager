package exercise2.creator;

import exercise2.objects.SaveObject;
import exercise2.objects.Task;
import exercise2.objects.User;

import java.util.List;

public class SimpleCreatorTask implements CreatorTask {
    private String userName;
    private String taskTitle;
    private String taskDesc;
    private SaveObject myObject;
    private List<User> userList;
    public SimpleCreatorTask(String[] args, SaveObject myObject){

        this.userName = args[1].substring(4);
        this.taskTitle = args[2].substring(4);
        this.taskDesc = args[3].substring(4);
        this.myObject = myObject;
    }

    @Override
    public SaveObject createTask() {
        for (User temp:myObject.getUsers()) {
            if (temp.getUserName().equals(userName)){
                userList.add(temp);
                myObject.getTasks().add(new Task(userList, taskTitle, taskDesc));
                break;
            }
        }
        return myObject;
    }
}
