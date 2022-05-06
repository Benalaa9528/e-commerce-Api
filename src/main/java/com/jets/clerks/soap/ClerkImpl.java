package com.jets.clerks.soap;

import java.util.List;

import com.jets.clerks.dao.ClerkDao;
import com.jets.clerks.dto.ClerkDto;
import com.jets.clerks.dto.ClerkPostDto;
import com.jets.login.CheckerDao;

public class ClerkImpl implements Clerk {

    @Override
    public List<ClerkDto> getAllClerks() {
        ClerkDao clerkDao = new ClerkDao();
        var clerks = clerkDao.getAllClerks();
        if (clerks != null) {
            return clerks;
        }
        return null;
    }

    @Override
    public ClerkDto getClerkById(int id) {
        ClerkDao clerkDao = new ClerkDao();
        var clerk = clerkDao.getClerkById(id);
        if (clerk != null) {
            return clerk;
        }
        return null;
    }

    @Override
    public String addClerk(ClerkPostDto clerk) {
        ClerkDao clerkDao = new ClerkDao();
        clerkDao.addClerk(clerk);
        return "Clerk Is Added Successfully";
    }

    @Override
    public String deleteClerkById(int id) {
        ClerkDao clerkDao = new ClerkDao();
        Boolean isDeleted = clerkDao.deleteClerkById(id);
        if (isDeleted) {
            return "Clerk Is Deleted Successfully";
        }
        return "Clerk Is Not Exist !";
    }

    @Override
    public String updateClerk(int id, ClerkPostDto clerkPostDto) {
        CheckerDao checkerDao = new CheckerDao();
        Boolean isClerk = checkerDao.findEmployeeById(id);
        if (isClerk) {
            ClerkDao clerkDao = new ClerkDao();
            clerkDao.updateClerk(id, clerkPostDto);
            return "Clerk Successfully Updated ";
        }
        return "Clerk Does Not Exist ";
    }

}
