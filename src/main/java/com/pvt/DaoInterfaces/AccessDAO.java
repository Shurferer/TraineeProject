
package com.pvt.DaoInterfaces;

import com.pvt.model.AccessData;


public interface AccessDAO {
    boolean checkAccess (AccessData acc);
    public void updateAccessBase (AccessData access);
}
