package app.mile1.service;

import app.mile1.bean.Student;

public class StudentService {

    public int findNumberOfNullMarksArray(Student[] s) {
        int c = 0;
        if (s != null) {
            for (Student student : s) {
                if (student != null) {
                    if (student.getMarks() == null) {
                        c++;
                    }
                }
            }
        }
        return c;
    }

    public int findNumberOfNullName(Student[] s) {
        int c = 0;
        if (s != null) {
            for (Student student : s) {
                if (student != null) {
                    if (student.getName() == null) {
                        c++;
                    }
                }
            }
        }
        return c;
    }

    public int findNumberOfNullObjects(Student[] s) {
        int c = 0;
        if (s != null) {
            for (Student student : s) {
                if (student == null) {
                    c++;
                }
            }
        }
        return c;
    }
}