package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User getResult(String model, int series) {
        String sql = "SELECT u FROM User u WHERE u.car.model=:model and u.car.series=:series";
        User user = sessionFactory.getCurrentSession()
                .createQuery(sql, User.class)
                .setParameter("model", model)
                .setParameter("series", series)
                .getSingleResult();
        return user;
    }

}
