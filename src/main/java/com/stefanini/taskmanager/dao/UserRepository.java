package com.stefanini.taskmanager.dao;

import com.stefanini.taskmanager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
