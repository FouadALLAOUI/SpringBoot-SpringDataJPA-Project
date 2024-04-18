package com.fouad.exemple.student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before-All");
    }

    @BeforeEach // Run before running any test
    void setUp() {
        System.out.println("Before");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After");
    }

    @Test
    public void testMethod1(){
        System.out.println("My First test method");
    }

    @Test
    public void testMethod2(){
        System.out.println("My Second test method");
    }

}