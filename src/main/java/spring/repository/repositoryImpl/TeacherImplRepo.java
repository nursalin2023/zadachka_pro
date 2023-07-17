package spring.repository.repositoryImpl;
import jakarta.transaction.Transactional;
import spring.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.repository.TeacherRepo;

import java.util.List;

@Repository
@Transactional
public class TeacherImplRepo implements TeacherRepo {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Teacher> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Teacher c", Teacher.class).getResultList();

    }

    @Override
    public Teacher findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Teacher.class, id);

    }

    @Override
    public void save(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.save(teacher);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Teacher where id=:teacherId").setParameter("teacherId", id).executeUpdate();

    }

    @Override
    public void updateTeacher(int id, Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher1 = findById(id);
        teacher1.setFirst_name(teacher1.getFirst_name());
        teacher1.setLast_name(teacher1.getLast_name());
        session.merge(teacher1);
    }

    @Override
    public void clear() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Teacher ").executeUpdate();

    }
}
