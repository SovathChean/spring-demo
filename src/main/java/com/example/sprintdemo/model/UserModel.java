package com.example.sprintdemo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String username;
    private GenderEnum gender;
    private LocalDate dob;
    private Integer createdBy;
    private LocalDate createdAt;
    private Integer updatedBy;
    private LocalDate updatedAt;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public GenderEnum getGender() {
        return this.gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDate getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public UserModel id(Integer id) {
        setId(id);
        return this;
    }

    public UserModel username(String username) {
        setUsername(username);
        return this;
    }

    public UserModel gender(GenderEnum gender) {
        setGender(gender);
        return this;
    }

    public UserModel dob(LocalDate dob) {
        setDob(dob);
        return this;
    }

    public UserModel createdBy(Integer createdBy) {
        setCreatedBy(createdBy);
        return this;
    }

    public UserModel createdAt(LocalDate createdAt) {
        setCreatedAt(createdAt);
        return this;
    }

    public UserModel updatedBy(Integer updatedBy) {
        setUpdatedBy(updatedBy);
        return this;
    }

    public UserModel updatedAt(LocalDate updatedAt) {
        setUpdatedAt(updatedAt);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", gender='" + getGender() + "'" +
            ", dob='" + getDob() + "'" +
            ", createdBy='" + getCreatedBy() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedBy='" + getUpdatedBy() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            "}";
    }
}
