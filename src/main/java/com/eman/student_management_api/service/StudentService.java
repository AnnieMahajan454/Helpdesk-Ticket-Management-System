package com.eman.student_management_api.service;

import com.eman.student_management_api.dto.StudentResponse;
import com.eman.student_management_api.dto.UpdateStudentRequest;
import com.eman.student_management_api.repository.StudentRepository;
import com.eman.student_management_api.model.Student;
import com.eman.student_management_api.dto.CreateStudentRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    //constructor
    public StudentService(StudentRepository studentRepository){
        this.studentRepository= studentRepository;
    }

    //shared validation, used by both create and update
    private void validateCgpa(Double cgpa){
        if (cgpa > 4.0){
            throw new IllegalArgumentException("Cgpa must be less then 4");
        }
    }

    //post (create)
    public Student saveStudent(CreateStudentRequest request){
        validateCgpa(request.getCgpa());

        Student student = new Student();
        student.setName(request.getName());
        student.setCgpa(request.getCgpa());

        return studentRepository.save(student);
    }

    //get (read)
    public List<StudentResponse> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentResponse> responses = new ArrayList<>();

        for (Student student : students){
            StudentResponse response = new StudentResponse(
                    student.getId(),
                    student.getName(),
                    student.getCgpa()
            );
            responses.add(response);
        }
        return responses;
    }

    //get by id
    public StudentResponse getStudentById(Long id){
        Student student = studentRepository.findById(id).orElseThrow();
        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getCgpa());
    }

    //put (update)
    public StudentResponse updateStudent(Long id, UpdateStudentRequest request) {
        validateCgpa(request.getCgpa());

        Student existingStudent = studentRepository.findById(id).orElseThrow();
        existingStudent.setName(request.getName());
        existingStudent.setCgpa(request.getCgpa());
        Student savedStudent = studentRepository.save(existingStudent);

        return new StudentResponse(
                savedStudent.getId(),
                savedStudent.getName(),
                savedStudent.getCgpa()
        );
    }

    //delete
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}