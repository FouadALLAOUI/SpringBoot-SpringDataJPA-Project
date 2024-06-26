package com.fouad.exemple.student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fouad.exemple.studentprofile.StudentProfile;
import com.fouad.exemple.school.School;
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
    @OneToOne(
            mappedBy = "student", // same name of the var in studentprofile
            cascade = CascadeType.ALL //in case of delete
    )
    private StudentProfile studentProfile;

    @ManyToOne
    @JoinColumn(
            name = "school_id"
    )
    @JsonBackReference
    private School school;

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

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

}
