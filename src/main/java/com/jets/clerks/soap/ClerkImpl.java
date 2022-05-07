package com.jets.clerks.soap;

import com.jets.clerks.dao.ClerkDao;
import com.jets.clerks.dto.ClerkDto;
import com.jets.clerks.dto.ClerkPostDto;
import com.jets.clerks.dto.Clerks;
import com.jets.login.dao.CheckerDao;

import jakarta.jws.WebService;

@WebService(endpointInterface = "com.jets.clerks.soap.Clerk")
public class ClerkImpl implements Clerk {

    @Override
    public Clerks getAllClerks(String adminUuid) {
        CheckerDao checkerDao = new CheckerDao();
        var emp = checkerDao.getLoggedInEmployee(adminUuid);
        if (emp.getRole().equalsIgnoreCase("admin")||emp.getRole().equalsIgnoreCase("clerk")) { 
        ClerkDao clerkDao = new ClerkDao();
        var clerks = clerkDao.getAllClerks();
        Clerks xmlClerks = new Clerks();
        xmlClerks.setClerks(clerks);
        if (clerks != null) {
            return xmlClerks;
        }
    }
        return null;
    }

    @Override
    public ClerkDto getClerkById(int id, String adminUuid) {
        CheckerDao checkerDao = new CheckerDao();
        var emp = checkerDao.getLoggedInEmployee(adminUuid);
        if (emp.getRole().equalsIgnoreCase("admin")) { 
        ClerkDao clerkDao = new ClerkDao();
        var clerk = clerkDao.getClerkById(id);
        if (clerk != null) {
            return clerk;
        }
    }
        return null;
    }

    @Override
    public String addClerk(ClerkPostDto clerk, String adminUuid) {
        CheckerDao checkerDao = new CheckerDao();
        var emp = checkerDao.getLoggedInEmployee(adminUuid);
        if (emp.getRole().equalsIgnoreCase("admin")) { 
        ClerkDao clerkDao = new ClerkDao();
        clerkDao.addClerk(clerk);
        return "Clerk Is Added Successfully";
        }
        return "Don't Have Access";
    }

    @Override
    public String deleteClerkById(int id, String adminUuid) {
        CheckerDao checkerDao = new CheckerDao();
        var emp = checkerDao.getLoggedInEmployee(adminUuid);
        if (emp.getRole().equalsIgnoreCase("admin")) {
            ClerkDao clerkDao = new ClerkDao();
            Boolean isDeleted = clerkDao.deleteClerkById(id);
            if (isDeleted) {
                return "Clerk Is Deleted Successfully";
            }
        }
        return "Clerk Is Not Exist !";
    }

    @Override
    public String updateClerk(int id, ClerkPostDto clerkPostDto, String adminUuid) {
        CheckerDao checkerDao = new CheckerDao();
        var emp = checkerDao.getLoggedInEmployee(adminUuid);
        if (emp.getRole().equalsIgnoreCase("admin")) {
            Boolean isClerk = checkerDao.findEmployeeById(id);
            if (isClerk) {
                ClerkDao clerkDao = new ClerkDao();
                clerkDao.updateClerk(id, clerkPostDto);
                return "Clerk Successfully Updated ";
            }
        }
        return "Clerk Does Not Exist ";
    }

}
