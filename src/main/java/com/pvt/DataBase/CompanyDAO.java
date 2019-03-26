package com.pvt.DataBase;

import com.pvt.model.Company;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDAO implements com.pvt.DaoInterfaces.CompanyDAO {

    @PersistenceContext
    private EntityManager em;

    public boolean checkCompanyInDataBase(int ID) {
        boolean result = false;
        Query query = em.createQuery("from Company where ID =:ID");
        query.setParameter("ID", ID);
        List<Company> companies = query.getResultList();
        if (!(companies.isEmpty())) {
            result = true;
        }
        return result;

    }

    @Override
    public Company getCompanyByID(int ID) {
        Query query = em.createQuery("from Company where ID =:ID");
        query.setParameter("ID", ID);
        return (Company) query.getSingleResult();
    }
}
