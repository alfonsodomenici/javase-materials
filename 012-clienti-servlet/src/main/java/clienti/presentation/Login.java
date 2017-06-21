/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienti.presentation;

import clienti.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tss
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

  @Inject
  UserService userService;
  
  @Inject
  SessionData sessionData;
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    String usr = req.getParameter("username");
    String pwd = req.getParameter("password");
    if(userService.login(usr, pwd)){
      sessionData.setLoggedUser(usr);
    }
    resp.sendRedirect("index.jsp");
  }

  
}
