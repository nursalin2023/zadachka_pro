package spring.repository.repositoryImpl;

import jakarta.transaction.Transactional;
import spring.model.Groups;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.repository.GroupsRepo;

import java.util.List;

@Repository
@Transactional
public class GroupsImplRepo implements GroupsRepo {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Groups> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Groups c", Groups.class).getResultList();

    }

    @Override
    public Groups findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Groups.class, id);
    }

    @Override
    public void save(Groups groups) {
        Session session = sessionFactory.getCurrentSession();
        session.save(groups);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Groups where id=:groupsId").setParameter("groupsId", id).executeUpdate();

    }

    @Override
    public void updateGroups(int id, Groups groups) {
        Session session = sessionFactory.getCurrentSession();
        Groups groups1 = findById(id);
        groups1.setGroupName(groups1.getGroupName());
        groups1.setDataStart(groups1.getDataStart());
        groups1.setDataFinish(groups1.getDataFinish());
        session.merge(groups1);
    }

    @Override
    public void clear() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Groups ").executeUpdate();

    }
}
