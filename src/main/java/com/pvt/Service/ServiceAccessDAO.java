
package com.pvt.Service;

import com.pvt.DataBase.AccessDAO;
import com.pvt.model.AccessData;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAccessDAO {
   
    @Autowired
    AccessDAO accessDAO;
    
    @Transactional
    public boolean checkAccess (AccessData acc){
        return accessDAO.checkAccess(acc);
    }
    
     @Transactional
    public void updateAccessBase (AccessData access){
        accessDAO.updateAccessBase(access);
    }
}
