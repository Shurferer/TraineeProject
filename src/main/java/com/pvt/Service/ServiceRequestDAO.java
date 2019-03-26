
package com.pvt.Service;

import com.pvt.DataBase.RequestDAO;
import com.pvt.model.Request;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiceRequestDAO {
   
    @Autowired
    RequestDAO requestDAO;
      
    @Transactional
    public List <Request> getRequestsByType (int type) {
        return requestDAO.getRequestsByType(type);
    }
}
