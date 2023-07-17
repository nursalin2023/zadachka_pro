package spring.repository;
import spring.model.Course;

import java.util.List;

public interface CourseRepo {

    List<Course> findAll();

    Course findById(int id);

    void save(Course course);

    void delete(int id);

    void updateCourse(int id,Course course);

    void clear();
}
