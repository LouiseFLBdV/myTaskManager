package exercise2.Initializer;

import exercise2.objects.SaveObject;
import exercise2.objects.Task;
import exercise2.objects.User;

import java.util.ArrayList;
import java.util.List;

public class FileInitializeDefault implements InitializerFile {
    @Override
    public SaveObject initialize() {
        List<User> users = new ArrayList<>();
        List<Task> tasks = new ArrayList<>();
        List<User> userList = new ArrayList<>();
        User user1 = new User("firstName1", "lastName1", "userName1");
        User user2 = new User("firstName2", "lastName2", "userName2");
        userList.add(user1);
        Task task1 = new Task(userList, "task1", "do task1");
        user1.setTask(task1);
        users.add(user1);
        users.add(user2);
        tasks.add(task1);
        return new SaveObject(users, tasks);
    }
}
