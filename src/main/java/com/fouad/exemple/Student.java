package com.fouad.exemple;

import jakarta.persistence.*;

@Entity // map and represent tab in db
@Table(name = "T_STUDENT")   // specify the name of the table
public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "c_fname", length = 20)
    private String firstname;
    //@Column
    private String lastname;
    @Column(unique = true)
    private String email;
    //@Column
    private int age;
    @Column(updatable = false)
    private String some_column;

    public Student() {
    }

    public Student(String firstname, String lastname, String email, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
