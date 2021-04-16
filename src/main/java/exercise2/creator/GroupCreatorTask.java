package exercise2.creator;

import exercise2.objects.SaveObject;
import exercise2.objects.Task;
import exercise2.objects.User;

import java.util.ArrayList;
import java.util.List;

public class GroupCreatorTask implements CreatorTask {
    private String taskDesc;
    private String taskTitle;
    private String[] args;
    private SaveObject myObject;
    private List<User> users;

    public GroupCreatorTask(String[] args, SaveObject myObject) {
        this.args = args;
        this.myObject = myObject;
        this.taskTitle = args[1].substring(4);
        this.taskDesc = args[2].substring(4);
        users = new ArrayList<>();
    }

    @Override
    public SaveObject createTask() {
        for (int i = 3; i < args.length; i++){
            for (User temp:myObject.getUsers()) {
                if (temp.getUserName().equals(args[i].substring(4))){
                    users.add(temp);
                    break;
                }
            }
        }

        myObject.getTasks().add(new Task(users, taskTitle, taskDesc));
        users.forEach(value->{
            value.setTask(myObject.getTasks().get(myObject.getTasks().size()-1));
        });
        System.out.println(users);
        return myObject;
    }
}
