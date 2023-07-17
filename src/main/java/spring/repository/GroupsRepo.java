package spring.repository;
import spring.model.Groups;

import java.util.List;

public interface GroupsRepo {
    List<Groups> findAll();

    Groups findById(int id);

    void save(Groups groups);

    void delete(int id);

    void updateGroups(int id, Groups groups);

    void clear();
}
