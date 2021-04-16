package exercise2.displayer;

import exercise2.objects.SaveObject;
import exercise2.objects.Task;
import exercise2.objects.User;

public class ConcreteDisplay implements Displayer {
    private SaveObject myObject;
    private String userName;
    public ConcreteDisplay(SaveObject myObject, String userName){
        this.myObject = myObject;
        this.userName = userName;
    }
    public void display() {
        for (User user:myObject.getUsers()) {
            if (user.getUserName().equals(userName)){
                System.out.println(user.getUserName() + " tasks:");
                int temp = 1;
                for (Task task:myObject.getTasks()) {
                    for (User userTask:task.getAdditionUsers()) {
                        if (user.getUserName().equals(userTask.getUserName())){
                            System.out.println("\ttask " + temp + ":");
                            System.out.println("\t\t" + task.getTaskTitle());
                            System.out.println("\t\t" + task.getDescription());
                            temp++;
                        }
                    }
                }
                if (temp==1){
                    System.out.println("haven't tasks");
                }
                System.out.println("--------------------------");
            }
        }
    }
}
