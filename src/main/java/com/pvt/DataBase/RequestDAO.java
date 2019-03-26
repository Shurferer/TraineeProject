
package com.pvt.DataBase;

import com.pvt.model.Request;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RequestDAO implements com.pvt.DaoInterfaces.RequestDAO{
    
    @PersistenceContext
	private EntityManager em;

    public List <Request> getRequestsByType (int type) {
            if (type==1) type=2;
            else type=1;
            Query query = em.createQuery("from Request where type =:type");
            query.setParameter("type", type);
            List <Request> requests = query.getResultList();
            return requests;
	}
    
}
