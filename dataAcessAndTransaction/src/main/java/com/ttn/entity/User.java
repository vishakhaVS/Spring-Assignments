package com.ttn.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;




@Entity
@Table(name = "user")
public class User {
    String username;
    String password;
    String name;
    int age;
    String dob;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    int id;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public User(String username, String password, String name, int age, String dob, int id) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dob='" + dob + '\'' +
                ", id=" + id +
                '}';
    }
}




