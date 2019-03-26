
package com.pvt.Service;

import com.pvt.DataBase.DAO;
import com.pvt.model.User;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceUserDAO {
    
    @Autowired
    DAO userDAO;
    
       @Transactional            
        public void addUserToDataBase(User user) {
            userDAO.addUserToDataBase(user);
	}

        @Transactional
	public boolean checkUserCreated(String login) {
        	return userDAO.checkUserCreated(login);
	}
	
       
        @Transactional
        public User getUserByLogin (String login){
           return userDAO.getUserByLogin(login);
        }

        @Transactional
	public boolean clearAccount(User client) {
            return userDAO.clearAccount(client);
	}
        @Transactional
        public User getUserByID(int id){
            return userDAO.getUserByID(id);
        }
}
