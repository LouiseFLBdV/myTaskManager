package com.stefanini.taskmanager.entities;

import com.stefanini.taskmanager.anotation.Email;
import com.stefanini.taskmanager.anotation.EmailField;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="tasktable")
@Email(message = "Task {task title} {task description} has been assigned to {username}")
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "task_title")
    @EmailField(field = "taskTitle")
    private String taskTitle;


    @Column(name = "description")
    @EmailField(field = "description")
    private String description;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_task"
            , joinColumns = @JoinColumn(name = "task_id")
            , inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;


    public Task(String taskTitle, String description) {
        this.taskTitle = taskTitle;
        this.description = description;
    }

    public Task(List<User> users, String taskTitle, String description) {
        this.users = users;
        this.taskTitle = taskTitle;
        this.description = description;
    }

    public Task() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
