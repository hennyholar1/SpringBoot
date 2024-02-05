package com.training.learning.dao;

import com.training.learning.domain.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Students, Integer> {
    @Query("SELECT fullName FROM Students")
    public List<String> getListOfFirstNames();

}
