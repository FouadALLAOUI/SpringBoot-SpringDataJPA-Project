package com.fouad.exemple.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

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



}