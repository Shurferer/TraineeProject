
package com.pvt.Service;

import com.pvt.DataBase.CompanyDAO;
import com.pvt.model.Company;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCompanyDAO {
     
    @Autowired
    CompanyDAO companyDAO;
    
    @Transactional
     public boolean checkCompanyInDataBase(int ID){
         return companyDAO.checkCompanyInDataBase(ID);
     }
     
     @Transactional
     public Company getCompanyById(int ID){
         return companyDAO.getCompanyByID(ID);
     }
}
