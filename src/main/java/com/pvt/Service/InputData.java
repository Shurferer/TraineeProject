package com.pvt.Service;

import com.pvt.model.User;
import com.pvt.model.AccessData;
import com.pvt.model.Company;
import com.pvt.model.Request;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InputData {

    @Autowired
    private User client;

    @Autowired
    private ServiceAccessDAO accessDao;

    @Autowired
    private ServiceCompanyDAO companyDao;

    @Autowired
    private ServiceUserDAO userDao;

    @Autowired
    private ClientWorks clientWorks;

    public void createAdmin() {
        AccessData access2 = new AccessData("admin", "admin");
        if (!(accessDao.checkAccess(access2))) {
            User client = new User("admin");
            client.setAccessData(access2);
            access2.setUser(client);
            accessDao.updateAccessBase(access2);
        }
    }

    public User checkAccess(AccessData access) {
        boolean inputDone;
        inputDone = accessDao.checkAccess(access);
        if (inputDone) {
            client = userDao.getUserByLogin(access.getLogin());
        } else {
            client = null;
        }
        return client;
    }

    public boolean checkRequest(String job, int payment, int hours, String role) {
        boolean result = true;
        if ((job == null) || (role == null) || (payment < 1) || (payment > 1000) || (hours < 8) || (hours > 40)) {
            result = false;
        }
        return result;
    }

    public Company getCompanyById(int ID) {
        return companyDao.getCompanyById(ID);
    }

    public boolean checkCompanyInDatabase(User client) {
        return companyDao.checkCompanyInDataBase(client.getID());
    }

    public boolean deleteAccount(User client) {
        return userDao.clearAccount(client);
    }

    public Request findResult(Request req) {
        return clientWorks.findOfferInDataBaseUsingClientRequest(req);
    }

    public User findUser(Request req) {
        return userDao.getUserByID(req.getRequester().getID());
    }

    public Map distributeRequests() {
        return clientWorks.distributeRequests();
    }
}
