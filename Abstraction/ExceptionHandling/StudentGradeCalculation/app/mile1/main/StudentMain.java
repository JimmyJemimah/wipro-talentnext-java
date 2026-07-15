package app.mile1.main;

import app.mile1.bean.Student;
import app.mile1.service.StudentReport;
import app.mile1.service.StudentService;

public class StudentMain {
    static Student data[] = new Student[4];

    public StudentMain() {
        for (int i = 0; i < data.length; i++) {
            data[i] = new Student();
        }
        
        data[0] = new Student(null, new int[]{85, 75, 95}, "Sekar");
        data[1] = new Student(null, new int[]{11, 22, 33}, null);
        data[2] = null;
        data[3] = new Student(null, null, "Manoj");
    }

    public static void main(String[] args) {
        new StudentMain();
        StudentReport report = new StudentReport();

        System.out.println("--- Student Validation & Grading ---");
        for (Student student : data) {
            try {
                String validationResult = report.validate(student);
                if ("VALID".equals(validationResult)) {
                    String finalGrade = report.findGrades(student);
                    student.setGrade(finalGrade);
                    System.out.println("Student Name: " + student.getName() + " | Grade: " + student.getGrade());
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }

        System.out.println("\n--- Service Statistics Counts ---");
        StudentService service = new StudentService();
        System.out.println("Number of objects with Null Marks Array: " + service.findNumberOfNullMarksArray(data));
        System.out.println("Number of objects with Null Name: " + service.findNumberOfNullName(data));
        System.out.println("Number of Null Student Objects: " + service.findNumberOfNullObjects(data));
    }
}