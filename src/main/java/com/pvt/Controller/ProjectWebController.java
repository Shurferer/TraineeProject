package com.pvt.Controller;

import com.pvt.Service.InputData;
import com.pvt.Service.ServiceAccessDAO;
import com.pvt.Service.ServiceUserDAO;
import com.pvt.model.AccessData;
import com.pvt.model.Company;
import com.pvt.model.Request;
import com.pvt.model.User;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/")
public class ProjectWebController {

    @Autowired
    private InputData inputData;

    @Autowired
    private User client;

    @Autowired
    private AccessData access;

    @Autowired
    Request request;

    @Autowired
    ServiceUserDAO serviceUserDAO;

    @Autowired
    ServiceAccessDAO serviceAccessDAO;

    @Autowired
    Company company;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String startPage(ModelMap model) {
        access = new AccessData();
        model.addAttribute("access", access);
        return "entrance";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String saveRegistration(AccessData access,
            ModelMap model) {
        client = inputData.checkAccess(access);
        this.access = access;
        if (!(client == null)) {
            client.setAccessData(access);
            access.setUser(client);
            model.addAttribute("login", "Hi " + client.getName() + " please choose option:");
            return "login";
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String registration(ModelMap model) {
        client = new User();
        model.addAttribute("client", client);
        return "registration";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String registrationUser(ModelMap model, User client) {
        this.client = client;
        return "registration2";
    }

    @RequestMapping(value = "/reg/access", method = RequestMethod.GET)
    public String registration2(ModelMap model) {
        access = new AccessData();
        model.addAttribute("access", access);
        return "registration3";
    }

    @RequestMapping(value = "/reg/access", method = RequestMethod.POST)
    public String saveRegistration3(AccessData access,
            ModelMap model) {
        this.access = access;
        client.setAccessData(access);
        access.setUser(client);
        serviceAccessDAO.updateAccessBase(access);
        model.addAttribute("login", "Hi " + client.getName()
                + " please choose option:");
        return "login";
    }

    @RequestMapping(value = "/login/addRequest", method = RequestMethod.GET)
    public String addRequest(ModelMap model) {
        request = new Request();
        model.addAttribute("request", request);
        return "addRequest";
    }

    @RequestMapping(value = "/login/addRequest", method = RequestMethod.POST)
    public String saveRequest(Request request,
            ModelMap model) {
        try {
            if (request.getRole().equals("Employee")) {
                request.setType(2);
            } else {
                request.setType(1);
            }
        } catch (Exception e) {
            return "error";
        }
        boolean result = inputData.checkRequest(request.getJob(), request.getPayment(), request.getHoursinWeek(), request.getRole());
        if (result) {
            client = serviceUserDAO.getUserByLogin(client.getLogin());
            client.getRequests().add(request);
            request.setRequester(client);
            serviceUserDAO.addUserToDataBase(client);
            if (request.getRole().equals("Employee")) {
                return "addCompany";
            }

        } else {
            return "error";
        }
        return "resultOfAddingRequest";
    }

    @RequestMapping(value = "/login/addRequest/addCompany", method = RequestMethod.GET)
    public String addCompany(ModelMap model) {
        company = new Company();
        model.addAttribute("company", company);
        return "addCompanyParameters";
    }

    @RequestMapping(value = "/login/addRequest/addCompany", method = RequestMethod.POST)
    public String saveCompany(Company company,
            ModelMap model) {
        try {
            client = serviceUserDAO.getUserByLogin(client.getLogin());
            client.getCompanies().add(company);
            company.setRequester(client);
            serviceUserDAO.addUserToDataBase(client);
        } catch (Exception e) {
            return "error";
        }
        return "resultOfAddingRequest";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String homePage(ModelMap model
    ) {
        inputData.createAdmin();
        model.addAttribute("print", "Choose option:");
        return "home";
    }

    @RequestMapping(value = "/exit", method = RequestMethod.GET)
    public String exitPage(ModelMap model
    ) {
        return "exit";
    }

    @RequestMapping(value = "/login/deleteAccount", method = RequestMethod.GET)
    public String deleteAccount(ModelMap model) {
        if (inputData.deleteAccount(client)) {
            model.addAttribute("result", "Delete account succefully.");
        } else {
            model.addAttribute("result", "Delete account unsuccefully.");
        }
        return "delete";
    }

    @RequestMapping(value = "/login/findResultNow", method = RequestMethod.GET)
    public String findResultNow(ModelMap model) {
        request = new Request();
        model.addAttribute("request", request);
        return "addRequestForFindResult";
    }

    @RequestMapping(value = "/login/findResultNow", method = RequestMethod.POST)
    public String addRequestForFindResult(Request req,
            ModelMap model) {
        this.request = req;
        try {
            if (request.getRole().equals("Employee")) {
                request.setType(2);
            } else {
                request.setType(1);
            }
        } catch (Exception e) {
            return "error";
        }
        boolean result = inputData.checkRequest(request.getJob(), request.getPayment(), request.getHoursinWeek(), request.getRole());
        if (result) {
            Request resultRequest = inputData.findResult(request);
            User requester = inputData.findUser(resultRequest);
            model.addAttribute("job", "  job: " + resultRequest.getJob());
            model.addAttribute("payment", "  payment: " + resultRequest.getPayment());
            model.addAttribute("hoursinWeek", resultRequest.getHoursinWeek());
            model.addAttribute("client", "  client: " + requester.toString());
        } else {
            return "error";
        }
        return "findRequestResult";
    }

    @RequestMapping(value = "/login/distributeRequests", method = RequestMethod.GET)
    public String distributeRequests(ModelMap model) {
        if (client.getPassword().equals("admin") && client.getLogin().equals("admin")) {
            Map map = inputData.distributeRequests();
            if (map.isEmpty()) {
                return "error";
            } else {
                model.addAttribute("map", map);
                return "distributeRequest";
            }
        } else {
            return "notAdmin";
        }
    }
}
