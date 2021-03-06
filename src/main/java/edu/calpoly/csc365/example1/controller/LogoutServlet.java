package edu.calpoly.csc365.example1.controller;

import edu.calpoly.csc365.example1.dao.Dao;
import edu.calpoly.csc365.example1.dao.DaoManager;
import edu.calpoly.csc365.example1.dao.DaoManagerFactory;
import edu.calpoly.csc365.example1.dao.UserDao;
import edu.calpoly.csc365.example1.entity.Customer;
import edu.calpoly.csc365.example1.entity.User;
import edu.calpoly.csc365.example1.service.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
  private DaoManager dm = null;
  private AuthenticationService authenticationService = null;

  public LogoutServlet() throws Exception {
    dm = DaoManagerFactory.createDaoManager();
    authenticationService = new AuthenticationService(dm.getUserDao());
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Cookie loginCookie = AuthenticationService.getLoginCookie(request);
    if (loginCookie != null) {
      loginCookie.setMaxAge(0);
      response.addCookie(loginCookie);
    }
    response.sendRedirect("login");
  }
}
