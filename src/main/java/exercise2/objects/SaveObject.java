package exercise2.objects;

import java.io.Serializable;
import java.util.List;

public class SaveObject implements Serializable {
    List<User> users;
    List<Task> tasks;

    public SaveObject(List<User> users, List<Task> tasks) {
        this.users = users;
        this.tasks = tasks;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
