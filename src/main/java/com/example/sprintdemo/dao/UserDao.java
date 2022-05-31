package com.example.sprintdemo.dao;

import com.example.sprintdemo.model.UserModel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserModel, Integer> {

    UserModel findUserById(Integer id);

}
