package com.pvt.DataBase;

import com.pvt.model.AccessData;
import com.pvt.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class DAO implements com.pvt.DaoInterfaces.UserDAO {

    @PersistenceContext
    private EntityManager em;

    public void addUserToDataBase(User user) {
        em.merge(user);
    }

    public boolean checkUserCreated(String login) {
        boolean result = false;
        try {
            Query query = em.createQuery("from AccessData where login=:login ");
            query.setParameter("login", login);
            AccessData access = (AccessData) query.getSingleResult();
            result = true;
        } catch (Exception e) {
            System.out.println("Cheking user created - User with this login is not created.");
        }
        return result;
    }

    public User getUserByLogin(String login) {
        Query query = em.createQuery("from AccessData where login=:login ");
        query.setParameter("login", login);
        AccessData access = (AccessData) query.getSingleResult();
        int userID = access.getAccessID();
        Query query2 = em.createQuery("from User where ID=:userID ");
        query2.setParameter("userID", userID);
        User client = (User) query2.getSingleResult();
        return client;
    }

    public boolean clearAccount(User client) {
        boolean result = false;
        try {
            User client2 = em.find(User.class, client.getID());
            em.remove(client2);
            result = true;
        } catch (Exception e) {
            System.out.println("com.pvt.DataBase.DAO.clearAccount()");
        }
        return result;
    }

    public User getUserByID(int id) {
        Query query2 = em.createQuery("from User where ID=:userID ");
        query2.setParameter("userID", id);
        User client = (User) query2.getSingleResult();
        return client;
    }
}
