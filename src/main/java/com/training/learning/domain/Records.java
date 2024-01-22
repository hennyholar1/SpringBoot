package com.training.learning.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "StudentRecord")
public class Records {
    private String fullName;
    private String studentAddress;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
}
