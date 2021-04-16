package exercise2.objects;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="tasktable")
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String taskTitle;

    private String description;
    @OneToMany(mappedBy = "task")
    private List<User> additionUsers;

    public Task(List<User> users, String taskTitle, String description) {
        this.additionUsers = users;
        this.taskTitle = taskTitle;
        this.description = description;
    }

    public Task() {

    }


    public String getTaskTitle() {
        return taskTitle;
    }

    public String getDescription() {
        return description;
    }

    public List<User> getAdditionUsers() {
        return additionUsers;
    }

    public void setAdditionUsers(List<User> additionUsers) {
        this.additionUsers = additionUsers;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public void setDescription(String description1) {
        this.description = description1;
    }
}
