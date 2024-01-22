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

    public Students getStudents(Students students) {
        return students;
    }

    public Students getStudents() {
        return new Students("My Student", 123);
    }
}
