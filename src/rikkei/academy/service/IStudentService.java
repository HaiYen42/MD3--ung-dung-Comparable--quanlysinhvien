package rikkei.academy.service;


import rikkei.academy.model.Student;

import java.util.List;

public interface IStudentService {
List<Student> findAll();
void save(Student student);
Student findById(int id);
void deleteById(int id);
void sortStudent(List StudentList);
}
