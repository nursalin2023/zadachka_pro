package spring.repository;
import spring.model.Teacher;

import java.util.List;

public interface TeacherRepo {
    List<Teacher> findAll();

    Teacher findById(int id);

    void save(Teacher teacher);

    void delete(int id);

    void updateTeacher(int id, Teacher teacher);

    void clear();
}
