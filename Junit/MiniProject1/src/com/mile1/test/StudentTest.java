package com.mile1.test;

import static org.junit.Assert.*;
import org.junit.Test;

// Mock imports for your service layer and exceptions
import com.mile1.bean.Student;
import com.mile1.service.StudentService;
import com.mile1.service.StudentReport;
import com.mile1.exception.NullStudentException;
import com.mile1.exception.NullNameException;
import com.mile1.exception.NullMarksArrayException;

public class StudentTest {

    private final StudentService studentService = new StudentService();
    private final StudentReport studentReport = new StudentReport();

    // --- GRADE CALCULATION FOR VALID OBJECTS ---
    
    @Test
    public void testTC1_CalculateGradeA() throws Exception {
        int[] marks = {95, 90, 92};
        Student student = new Student("Amit", marks);
        assertEquals("A", studentReport.validate(student));
    }

    @Test
    public void testTC2_CalculateGradeD() throws Exception {
        int[] marks = {50, 55, 48};
        Student student = new Student("Rahul", marks);
        assertEquals("D", studentReport.validate(student));
    }

    @Test
    public void testTC3_CalculateGradeF() throws Exception {
        int[] marks = {20, 30, 15};
        Student student = new Student("Rajesh", marks);
        assertEquals("F", studentReport.validate(student));
    }

    // --- THROW ERROR MESSAGE FOR INVALID OBJECTS ---

    @Test(expected = NullStudentException.class)
    public void testTC4_NullStudentObject() throws Exception {
        studentReport.validate(null);
    }

    @Test(expected = NullNameException.class)
    public void testTC5_NullStudentName() throws Exception {
        int[] marks = {80, 85, 90};
        Student student = new Student(null, marks);
        studentReport.validate(student);
    }

    @Test(expected = NullMarksArrayException.class)
    public void testTC6_NullMarksArray() throws Exception {
        Student student = new Student("Suresh", null);
        studentReport.validate(student);
    }

    // --- COUNTING THE NULL ---

    @Test
    public void testTC7_FindNumberOfNullName() {
        Student[] students = {
            new Student(null, new int[]{80, 70}),
            new Student("Kiran", new int[]{90, 85}),
            new Student(null, new int[]{60, 65})
        };
        assertEquals(2, studentService.findNumberOfNullName(students));
    }

    @Test
    public void testTC8_FindNumberOfNullObjects() {
        Student[] students = {
            new Student("Vijay", new int[]{75, 80}),
            null,
            new Student("Jay", new int[]{85, 90}),
            null
        };
        assertEquals(2, studentService.findNumberOfNullObjects(students));
    }

    @Test
    public void testTC9_FindNumberOfNullMarks() {
        Student[] students = {
            new Student("Arun", null),
            new Student("Deepak", new int[]{60, 70}),
            new Student("Rohan", null)
        };
        assertEquals(2, studentService.findNumberOfNullMarks(students));
    }
}