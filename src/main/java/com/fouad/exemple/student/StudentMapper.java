package com.fouad.exemple.student;

import com.fouad.exemple.school.School;
import com.fouad.exemple.student.Student;
import com.fouad.exemple.student.StudentDTO;
import com.fouad.exemple.student.StudentResponseDto;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toStudent(StudentDTO dto){
        var student = new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());
        var school = new School();
        school.setId(dto.schoolId());
        student.setSchool(school);

        return student;
    }

    public StudentResponseDto tostudentResponseDto(Student student){
        return  new StudentResponseDto(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail()
        );
    }

}
