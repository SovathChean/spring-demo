package com.example.sprintdemo.dao;

import com.example.sprintdemo.model.UserModel;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserModel, Integer> {

    Optional<UserModel> findUserById(Integer id);

}
