package rikkei.academy.service;

import rikkei.academy.model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentServiceIMPL implements IStudentService{
    public static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"Ha", 5));
        studentList.add(new Student(2, "Yen", 10));
        studentList.add(new Student(3,"Thu", 6));
        studentList.add(new Student(4, "Van", 7));
    }
    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public void save(Student student) {
        Student student1 = findById(student.getId());
        if (student1 == null) {
            studentList.add(student);
        }else {
            int index = studentList.indexOf(student1);
            studentList.set(index, student);
        }
    }

    @Override
    public Student findById(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId()==id) {
                return studentList.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.remove(studentList.get(i));
            }
        }
    }

    @Override
    public void sortStudent(List StudentList) {
        Collections.sort(studentList);
    }

//    public void sortStudent(List studentList){
//         Collections.sort(studentList);
//    }
}
