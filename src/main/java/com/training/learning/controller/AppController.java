package com.training.learning.controller;

import com.training.learning.dao.StudentRepository;
import com.training.learning.domain.Services;
import com.training.learning.domain.SpringBootDemo;
import com.training.learning.domain.Students;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
public class AppController {

    private final StudentRepository studentRepository;
    private final Services services;
    private final SpringBootDemo springBootDemo;

// Contractor injection style
    public AppController(Services services, SpringBootDemo springBootDemo, StudentRepository studentRepository) {
        this.services = services;
        this.springBootDemo = springBootDemo;
        this.studentRepository = studentRepository;
    }

    @ResponseBody // It will treat as a response body
    @GetMapping({"/info", "/"})
    public List<Students> studentInfo() {
        return studentRepository.findAll();
        //return path_to_non_static_file(.jsp or thymeleaf)
    }

    @GetMapping("/home")
    public String welcomeHome() {
        return "Welcome home dear programmer";
    }

    @GetMapping("/user")
    public String requestParam(@RequestParam("name") String name, @RequestParam("id") int id) {
        return services.doSomething(name, id);
    }

    @GetMapping("/user/{name}/{id}")
    public String pathParam(@PathVariable("name") String name, @PathVariable("id") int id) {
        return services.doSomething(name, id);
    }

    @GetMapping("/nothing")
    public int getMyId() {
        return services.doNothing();
    }

    @GetMapping("/stu")
    public String holder() {
        return springBootDemo.studentInfo();
    }
}
