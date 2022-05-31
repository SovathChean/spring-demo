package com.example.sprintdemo.repository;

import com.example.sprintdemo.model.UserModel;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

    UserModel findUserById(Integer id);

}
