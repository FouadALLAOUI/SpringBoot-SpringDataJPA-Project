package com.fouad.exemple;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class StudentService {
    private  final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(StudentDTO dto){
        var student = studentMapper.toStudent(dto);
        var savedStudent =  repository.save(student);
        return studentMapper.tostudentResponseDto(savedStudent);
    }

    public Student findStudentById(Integer id){
        return  this.repository.findById(id).orElse(new Student());
    }

    public List<Student> findAllStudent(){
        return  this.repository.findAll();
    }

    public List<Student> findStudentByName( String name){
        return  this.repository.findAllByFirstnameContaining(name);
    }

    public void delete(Integer id){
        this.repository.deleteById(id);
    }

}
