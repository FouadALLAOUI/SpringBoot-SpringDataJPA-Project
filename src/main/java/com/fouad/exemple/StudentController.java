package com.fouad.exemple;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private  final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentController(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    @PostMapping("/students")
    public StudentResponseDto post(@RequestBody StudentDTO dto){
             var student = studentMapper.toStudent(dto);
        var savedStudent =  repository.save(student);
        return studentMapper.tostudentResponseDto(savedStudent);
    }

    @GetMapping("/students/{student-id}")
    public Student findStudentById(@PathVariable("student-id") Integer id){
        return  repository.findById(id).orElse(new Student());
    }

    @GetMapping("/students")
    public List<Student> findAllStudent(){
        return  repository.findAll();
    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentByName(@PathVariable("student-name") String name){
        return  repository.findAllByFirstnameContaining(name);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable("student-id") Integer id){
        repository.deleteById(id);
    }







}
