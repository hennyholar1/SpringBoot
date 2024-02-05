package com.training.learning.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.stream.IntStream;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "StudentRecord")
public class Students {
    private String fullName;
    private String studentAddress;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    public Students(String fullName, String studentAddress) {
        this.fullName = fullName;
        this.studentAddress = studentAddress;
    }
}
