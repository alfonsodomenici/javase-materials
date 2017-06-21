/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienti.presentation;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tss
 */
@WebFilter(urlPatterns = "/*")
public class SecurityFilter implements Filter {

  @Inject
  SessionData sessionData;

  

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse resp = (HttpServletResponse) response;
    System.out.println(req.getServletPath());
    if ( req.getServletPath()
        .contains("ins_cliente.jsp") 
        && (sessionData ==null || sessionData.getLoggedUser() == null)) {
        resp.sendRedirect("index.jsp");
        return;
    }
    chain.doFilter(request, response);
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("Init security filter..");
  }

  @Override
  public void destroy() {
     System.out.println("Destroy security filter..");
  }

  

}
