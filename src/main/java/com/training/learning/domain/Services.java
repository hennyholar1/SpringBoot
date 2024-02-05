package com.training.learning.domain;

import org.springframework.stereotype.Component;

@Component
public class Services {
    private int id = 234;
    public Services(int id) {
        this.id = id;
    }

    public int doNothing() {
        System.out.println("Id is: " + id);
        return id;
    }

    public String doSomething(String input, int id) {
        return "Returning : " + input + " with and id: " + id;
    }

    public SpringBootDemo getStudents(SpringBootDemo students) {
        return students;
    }

    public SpringBootDemo getStudents() {
        return new SpringBootDemo("My Student", 123);
    }
}