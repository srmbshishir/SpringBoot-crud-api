package com.example.crudrestapitry.Model;

import javax.persistence.*;

@Entity
@Table(name= "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="class")
    private long classNum;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassNum(long classNum) {
        this.classNum = classNum;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getClassNum() {
        return classNum;
    }
}
