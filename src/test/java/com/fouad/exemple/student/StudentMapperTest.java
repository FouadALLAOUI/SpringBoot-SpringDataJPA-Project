package com.fouad.exemple.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    @BeforeEach // Run before running any test
    void setUp() {
        System.out.println("Before");
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