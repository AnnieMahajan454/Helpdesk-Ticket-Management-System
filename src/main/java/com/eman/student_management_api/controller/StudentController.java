package com.eman.student_management_api.controller;

import com.eman.student_management_api.dto.CreateStudentRequest;
import com.eman.student_management_api.dto.StudentResponse;
import com.eman.student_management_api.dto.UpdateStudentRequest;
import com.eman.student_management_api.model.Student;
import com.eman.student_management_api.service.StudentService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;



import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping("/students")
    // a rule registered by spring when it scans @RestController :
    // any HTTP POST request arriving at the URL path /students should be routed to this exact method
    public Student createStudent(@RequestBody CreateStudentRequest request){
        return studentService.saveStudent(request);
    }

    @GetMapping("/students")
    public List<StudentResponse> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public StudentResponse getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PutMapping("/students/{id}")
    public StudentResponse updateStudent(@PathVariable Long id, @RequestBody UpdateStudentRequest student){
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

}

