package com.training.learning.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Students {
    private String fullName;
    private String studentAddress;
    int id;

    public Students(String fullName, int id) {
        this.fullName = fullName;
        this.id = id;
    }

    public String studentInfo() {
        setFullName("King");
        setStudentAddress("123 ABC Street");
        setId(23);
        return "Contract injection returns: " + this;
    }

    @Override
    public String toString() {
        return "Students:    \n" +
                "\nfullName: '" + getFullName() + '\'' +
                ",\n address:' " + getStudentAddress() + '\'' +
                ", \nid: " + getId();
    }
}
