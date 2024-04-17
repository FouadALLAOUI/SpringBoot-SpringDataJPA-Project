package com.fouad.exemple;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

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

    public StudentResponseDto findStudentById(Integer id){
        //var student = this.repository.findById(id).orElse(new Student());
        //return this.studentMapper.tostudentResponseDto(student) ;
        return this.repository.findById(id)
                .map(studentMapper::tostudentResponseDto)
                .orElse(null);
    }

    public List<StudentResponseDto> findAllStudent(){
        return  this.repository.findAll()
                .stream()
                .map(studentMapper::tostudentResponseDto)
                .collect(Collectors.toList());
    }

    public List<StudentResponseDto> findStudentByName( String name){
        return  this.repository.findAllByFirstnameContaining(name)
                .stream()
                .map(studentMapper::tostudentResponseDto)
                .collect(Collectors.toList());
    }

    public void delete(Integer id){
        this.repository.deleteById(id);
    }

}
