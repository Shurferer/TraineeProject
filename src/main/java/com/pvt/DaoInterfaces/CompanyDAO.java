
package com.pvt.DaoInterfaces;

import com.pvt.model.Company;


public interface CompanyDAO {
    boolean checkCompanyInDataBase(int id);
    Company getCompanyByID(int id);
}
