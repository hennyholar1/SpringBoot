package com.training.learning.controller;

import com.training.learning.domain.Services;
import com.training.learning.domain.Students;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
public class AppController {

    private final Services services;
    private final Students students;

// Contractor injection style
    public AppController(Services services, Students students) {
        this.services = services;
        this.students = students;
    }

//    Services ser = new Services(123);

    @ResponseBody // It will treat as a response body
    @GetMapping({"/info", "/"})
    public String studentInfo() {
        return "Hello world!!!!";
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
        return students.studentInfo();
    }
}
