/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienti.presentation;

import clienti.entity.Cliente;
import clienti.service.ClienteService;
import java.io.IOException;
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
@WebServlet(urlPatterns = "/prova")
public class ProvaServlet extends HttpServlet {

    @Inject
    ClienteService clienteService;
    
    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("init() ...... ");
    }

    @Override
    public void destroy() {
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("destroy()...... ");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        StringBuilder sb = new 
        StringBuilder("<html><head><title>Elenco Clienti </title></head>");
        sb.append("<body><table>");
        for(Cliente cli : clienteService.findAll()){
            sb.append("<tr>");
            sb.append("<td>" + cli.getId() + "</td>");
            sb.append("<td>" + cli.getRagioneSociale() + "</td>");
            sb.append("<td>" + cli.getIndirizzo() + "</td>");
            sb.append("</tr>");
        }
        sb.append("</table></body></html>");
        resp.getWriter().println(sb.toString());
    }

}
