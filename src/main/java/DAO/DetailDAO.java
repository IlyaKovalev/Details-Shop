package DAO;

import Entity.Detail;
import org.hibernate.query.Query;

import java.util.List;

public interface DetailDAO {
    public void save(Detail detail);
    public List<Detail> select(String query);
    public List<Detail> getAll();
    public void update(Detail detail);
    public Detail getDetail(int id);
}
