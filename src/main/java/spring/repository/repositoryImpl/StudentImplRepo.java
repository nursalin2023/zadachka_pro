package spring.repository.repositoryImpl;
import jakarta.transaction.Transactional;
import spring.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.repository.StudentRepo;

import java.util.List;
@Repository
@Transactional
public class StudentImplRepo implements StudentRepo {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Student c", Student.class).getResultList();

    }

    @Override
    public Student findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);

    }

    @Override
    public void save(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Student where id=:studentId").setParameter("studentId", id).executeUpdate();

    }

    @Override
    public void updateStudent(int id, Student student) {
        Session session = sessionFactory.getCurrentSession();
        Student student1 = findById(id);
        student1.setFirst_name(student1.getFirst_name());
        student1.setLast_name(student1.getFirst_name());
        session.merge(student1);
    }

    @Override
    public void clear() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Student ").executeUpdate();

    }
}
