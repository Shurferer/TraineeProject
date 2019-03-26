
package com.pvt.DaoInterfaces;

import com.pvt.model.Request;
import java.util.List;


public interface RequestDAO {
            List <Request> getRequestsByType (int ID);

}
