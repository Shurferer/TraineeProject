
package com.pvt.DataBase;

import com.pvt.model.AccessData;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class AccessDAO implements com.pvt.DaoInterfaces.AccessDAO{
 
    @PersistenceContext
	private EntityManager em;

    public boolean checkAccess (AccessData acc){
                boolean result = false;
              try{
                Query query = em.createQuery("SELECT a FROM AccessData a where login=:login");
                query.setParameter("login", acc.getLogin());
                AccessData access = (AccessData) query.getSingleResult();
                if (!(access==null)&&(acc.getPassword().equals(access.getPassword()))) result = true; 
              }
              catch (Exception e) {
                  System.out.println("Cheking user created - User with this login is not created.");
              }
		return result;
	}
    
    public void updateAccessBase (AccessData access){
            em.persist(access);
        }
}
