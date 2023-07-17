package spring.repository;


import spring.model.Student;

import java.util.List;

public interface StudentRepo {
    List<Student> findAll();

    Student findById(int id);

    void save(Student student);

    void delete(int id);

    void updateStudent(int id, Student student);

    void clear();
}
