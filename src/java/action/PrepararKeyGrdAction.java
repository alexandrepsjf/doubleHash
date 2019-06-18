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
import model.TabelaHash;

/**
 *
 * @author negro
 */
public class PrepararKeyGrdAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TabelaHash tabelaHash=(TabelaHash)request.getAttribute("tabelaHash");         
        request.setAttribute("tabelaHash", tabelaHash);
        try {
            request.getRequestDispatcher("sucess2.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(PrepararKeyGrdAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
