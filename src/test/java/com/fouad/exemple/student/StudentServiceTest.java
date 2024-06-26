package com.fouad.exemple.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    //which service to test
    @InjectMocks // inject dependencies
    private  StudentService studentService;

    //declare the dependencies
    @Mock
    private StudentRepository repository;
    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_successfully_save_a_student(){
        // Given
        StudentDTO dto = new StudentDTO("Don", "RIO", "riodan@gmail.com", 24);
        Student student = new Student("Don", "RIO", "riodan@gmail.com", 24);
        Student savedStudent = new Student("Don", "RIO", "riodan@gmail.com", 24);
        savedStudent.setId(1);

        //Mock the calls
        when(studentMapper.toStudent(dto)).thenReturn(student);
        when(repository.save(student)).thenReturn(savedStudent);
        when(studentMapper.tostudentResponseDto(savedStudent))
                .thenReturn(new StudentResponseDto("Don", "RIO", "riodan@gmail.com"));

        //When
        StudentResponseDto responseDto = studentService.saveStudent(dto);

        //Then
        assertEquals(dto.firstname(), responseDto.firstname());
        assertEquals(dto.lastname(), responseDto.lastname());
        assertEquals(dto.email(), responseDto.email());

        // verify with time
        verify(studentMapper,times(1)).toStudent(dto);
        verify(repository, times(1)).save(student);
        verify(studentMapper, times(1)).tostudentResponseDto(savedStudent);
    }

    @Test
    public  void  should_return_all_students(){
        //Given
        List<Student> students = new ArrayList<>();
        students.add(new Student("Don", "RIO", "riodan@gmail.com",26));

        //Mock The calls
        when(repository.findAll()).thenReturn(students);
        when(studentMapper.tostudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto("Ron","RIO","riodan@gmail.com"));

        //When
        List<StudentResponseDto> responseDtos = studentService.findAllStudent();

        //Then
        assertEquals(students.size(), responseDtos.size());
        verify(repository, times(1)).findAll();

    }

    @Test
    public void should_return_student_by_id(){
        //Given
        Integer studentId = 1;
        Student student = new Student("Don", "RIO", "riodan@gmail.com",26);

        when(repository.findById(studentId))
                .thenReturn(Optional.of(student));
        when(studentMapper.tostudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto("Don","RIO","riodan@gmail.com"));

        //when
        StudentResponseDto dto = studentService.findStudentById(studentId);

        //Then
        assertEquals(dto.firstname(), student.getFirstname());
        assertEquals(dto.lastname(), student.getLastname());
        assertEquals(dto.email(), student.getEmail());

        verify(repository, times(1)).findById(studentId);

    }

    @Test
    public void should_find_student_by_name(){
        //Given
        String studentName = "Don";
        List<Student> students = new ArrayList<>();
        students.add(new Student("Don", "RIO", "riodan@gmail.com",26));

        //Mock The calls
        when(repository.findAllByFirstnameContaining(studentName)).thenReturn(students);
        when(studentMapper.tostudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto("Don","RIO","riodan@gmail.com"));

        //When
        var responseDto = studentService.findStudentByName(studentName);

        //then
        assertEquals(students.size(), responseDto.size());
        verify(repository,times(1))
                .findAllByFirstnameContaining(studentName);

    }







}