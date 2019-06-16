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
public class InserirKeyGrdAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int key = Integer.parseInt(request.getParameter("key"));
        TabelaHash.getInstance().insert(key);
        TabelaHash tabela = TabelaHash.getInstance();
        request.getSession().setAttribute("tabelaHash", tabela);
        try {
            request.getRequestDispatcher("sucess.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(InserirKeyGrdAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
