package com.tms.Homework_17_TMS;

public class Author {
    String lastName;
    String firstname;
    String title;

    public Author(String lastName, String firstname, String title) {
        this.lastName=lastName;
        this.firstname = firstname;
        this.title=title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
