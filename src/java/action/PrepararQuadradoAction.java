/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Controller.Action;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author alexandre
 */
public class PrepararQuadradoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fileName = request.getParameter("url");      
        request.setAttribute("url", fileName);

        try {
            request.getRequestDispatcher("prepararQuadrado.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(CriarTabelaPeqAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
