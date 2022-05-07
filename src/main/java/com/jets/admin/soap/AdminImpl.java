package com.jets.admin.soap;

import com.jets.admin.dao.AdminDao;
import com.jets.admin.dtos.AdminGetResponse;
import com.jets.admin.dtos.AdminPutRequest;
import com.jets.admin.dtos.Admins;
import com.jets.admin.service.AdminService;
import com.jets.login.dao.CheckerDao;

import jakarta.jws.WebService;

@WebService(endpointInterface = "com.jets.admin.soap.Admin")
public class AdminImpl implements Admin {

    @Override
    public AdminGetResponse getAdminProfile(int id, String adminUuid) {
        CheckerDao checkerDao = new CheckerDao();
        var emp = checkerDao.getLoggedInEmployee(adminUuid);
        if (emp.getRole().equalsIgnoreCase("admin")) {

            var employee = checkerDao.getEmployeeById(id);
            if (employee != null && employee.getRole().equalsIgnoreCase("admin")) {
                AdminService service = new AdminService(new AdminDao());
                return service.getAdminInfo(id);
            }
        }
        return null;
    }

    @Override
    public AdminGetResponse updateAdmin(int id, AdminPutRequest updateAdmin, String adminUuid) {
        CheckerDao checkerDao = new CheckerDao();
        var emp = checkerDao.getLoggedInEmployee(adminUuid);
        if (emp.getRole().equalsIgnoreCase("admin")) {
            var employee = checkerDao.getEmployeeById(id);
            if (employee != null && employee.getRole().equalsIgnoreCase("admin")) {
                AdminService service = new AdminService(new AdminDao());
                return service.updateAdminInfo(id, updateAdmin);
            }
        }
        return null;
    }

    @Override
    public Admins getAllAdmins(String adminUuid) {
        CheckerDao checkerDao = new CheckerDao();
        var emp = checkerDao.getLoggedInEmployee(adminUuid);
        if (emp.getRole().equalsIgnoreCase("admin")) {
            AdminService service = new AdminService(new AdminDao());
            var admins = service.getAllAdmins();
            Admins xmlAdmins = new Admins();
            xmlAdmins.setAdmins(admins);
            if (admins != null) {
                return xmlAdmins;
            }
        }
        return null;
    }
}
