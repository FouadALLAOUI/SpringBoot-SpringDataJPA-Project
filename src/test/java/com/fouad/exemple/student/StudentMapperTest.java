package com.fouad.exemple.student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent(){

        StudentDTO dto = new StudentDTO("Rio","Dan", "zez@hhz.com", 12);

        Student student = mapper.toStudent(dto);

        assertEquals(dto.firstname(), student.getFirstname());
        assertEquals(dto.lastname(), student.getLastname());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());
    }

    @Test
    public  void  shouldMapStudentToStudentResponseDTO(){
        Student student = new Student("RIO", "DAN", "riodan@gmail.com", 24);
        StudentResponseDto responseDto = mapper.tostudentResponseDto(student);

        assertEquals(student.getFirstname(), responseDto.firstname());
        assertEquals(student.getLastname(), responseDto.lastname());
        assertEquals(student.getEmail(),responseDto.email());

    }


}