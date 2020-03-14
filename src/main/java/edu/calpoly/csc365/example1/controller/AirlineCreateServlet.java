package edu.calpoly.csc365.example1.controller;

import edu.calpoly.csc365.example1.dao.Dao;
import edu.calpoly.csc365.example1.dao.DaoManager;
import edu.calpoly.csc365.example1.dao.DaoManagerFactory;
import edu.calpoly.csc365.example1.entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AirlineCreateServlet {
    private DaoManager dm = null;
    private Dao<Customer> customerDao = null;

    public AirlineCreateServlet() throws Exception {
        dm = DaoManagerFactory.createDaoManager();
        airlineDao = dm.getAirlineDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("customer_create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = null;
        String ssn = request.getParameter("social");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        Customer customer = new Customer(id, ssn, name, address, phone);
        id = this.customerDao.insert(customer);
        response.sendRedirect("edit_customer?id=" + id.toString());
    }
}
