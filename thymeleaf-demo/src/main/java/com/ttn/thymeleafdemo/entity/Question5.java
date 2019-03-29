package com.ttn.thymeleafdemo.entity;

public class Question5 {
    String uname;
    String location;
    boolean isAdmin;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Question5(String uname, String location, boolean isAdmin) {
        this.uname = uname;
        this.location = location;
        this.isAdmin = isAdmin;
    }
}
