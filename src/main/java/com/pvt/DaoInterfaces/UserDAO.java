package com.pvt.DaoInterfaces;

import com.pvt.model.User;

public interface UserDAO {
	void addUserToDataBase (User user);
	boolean checkUserCreated (String login);
        User getUserByLogin (String login);
	boolean clearAccount(User client);
        public User getUserByID(int id);
}
