package com.stefanini.taskmanager.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="tasktable")
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "task_title")
    private String taskTitle;

    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_task"
            , joinColumns = @JoinColumn(name = "task_id")
            , inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users;

    public void addUser(User user){
        if(users==null){
            users = new HashSet<>();
        }
        users.add(user);
    }
    public Task(String taskTitle, String description) {
        this.taskTitle = taskTitle;
        this.description = description;
    }

    public Task(User user, String taskTitle, String description) {
        addUser(user);
        this.taskTitle = taskTitle;
        this.description = description;
    }

    public Task(Set<User> users, String taskTitle, String description) {
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
