package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/studentlist")
    public List<Student> getStudentList(){
    List<Student> list=studentService.getStudentList();
    return list;
}

    @PostMapping("/uploaddetails")
    public Student uploaddata(@RequestBody Student k){
    Student data=studentService.saveStudentData(k);
    return data;
    }

    @PostMapping("/uploadlist")
    public List<Student> uploadList(@RequestBody List<Student> l){
        List<Student> list=studentService.saveStudentList(l);
        return list;
    }

    @GetMapping("/finddatabyid")
    public Student data(@RequestParam int id){
        Student data= studentService.getStudentData(id);
        return data;
        }

    @GetMapping("/findbyid/{id}")
    public Student databyid(@PathVariable int id){
        Student databyId= studentService.getStudentData(id);
        return databyId;
    }
}
