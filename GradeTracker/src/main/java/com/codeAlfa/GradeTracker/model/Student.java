package com.codeAlfa.GradeTracker.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {
    private String id;
    private String name;
    private List<Double> grades;

    public Student() {
        this.grades = new ArrayList<>();
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void setGrades(List<Double> grades) {
        this.grades = grades;
    }

    public void addGrade(Double grade) {
        this.grades.add(grade);
    }

    public Double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        return grades.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public Double getHighestGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        return Collections.max(grades);
    }

    public Double getLowestGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        return Collections.min(grades);
    }
}
