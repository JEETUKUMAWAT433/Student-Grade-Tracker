package com.codeAlfa.GradeTracker.service;
import com.codeAlfa.GradeTracker.model.Student;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    private final Map<String, Student> students = new HashMap<>();

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public Student getStudent(String id) {
        return students.get(id);
    }

    public Student addStudent(Student student) {
        students.put(student.getId(), student);
        return student;
    }

    public Student updateStudent(String id, Student student) {
        if (students.containsKey(id)) {
            student.setId(id);
            students.put(id, student);
            return student;
        }
        return null;
    }

    public boolean deleteStudent(String id) {
        if (students.containsKey(id)) {
            students.remove(id);
            return true;
        }
        return false;
    }

    public boolean addGrade(String id, Double grade) {
        if (students.containsKey(id)) {
            students.get(id).addGrade(grade);
            return true;
        }
        return false;
    }
}
