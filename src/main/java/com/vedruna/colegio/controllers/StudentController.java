package com.vedruna.colegio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.colegio.dto.StudentAllInfo;
import com.vedruna.colegio.dto.StudentDTO;
import com.vedruna.colegio.dto.StudentInfoDTO;

import com.vedruna.colegio.services.StudentServiceI;

@RestController
@RequestMapping("api/v1/student")
@CrossOrigin
public class StudentController {

    @Autowired
    StudentServiceI studentService;

    @GetMapping
    public List<StudentDTO> getAllStudent(){
        return studentService.showAllStudent();
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable Integer id){
        return studentService.showStudentById(id);
    }

    @GetMapping("/infoStudent/{id}")
    public StudentInfoDTO getInfoStudentById(@PathVariable Integer id){
        return studentService.showStudentInfoById(id);
    }

    @PostMapping("/addStudent")
    public void addAllStudent(@RequestBody StudentAllInfo studentAllInfo){
        studentService.addStudent(studentAllInfo);
    }

    @DeleteMapping("/deleteStudentInfo/{id}")
    public void deleteStudentInfo(@PathVariable Integer id){
        studentService.deleteStudent(id);
    }
    
}
