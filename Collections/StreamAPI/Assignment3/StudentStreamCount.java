package Assignment3;

import java.util.ArrayList;
import java.util.List;

class Student {
    private int rollNo;
    private String name;
    private int mark;

    public Student(int rollNo, String name, int mark) {
        this.rollNo = rollNo;
        this.name = name;
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }
}

public class StudentStreamCount {
    public static void main(String[] args) {
        List<Student> al = new ArrayList<>();
        al.add(new Student(101, "Aniket", 45));
        al.add(new Student(102, "Bhavna", 78));
        al.add(new Student(103, "Chirag", 50));
        al.add(new Student(104, "Divya", 88));
        al.add(new Student(105, "Esha", 39));

        // Count students with minimum 50 marks using filter and count
        long count = al.stream()
                       .filter(student -> student.getMark() >= 50)
                       .count();

        System.out.println("Number of students who cleared the test (>= 50 marks): " + count);
    }
}