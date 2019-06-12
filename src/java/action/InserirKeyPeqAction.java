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
import model.No;
import model.TabelaHash;

/**
 *
 * @author negro
 */
public class InserirKeyPeqAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int key = Integer.parseInt(request.getParameter("key"));
        TabelaHash.getInstance().insert(key, "teste");
               TabelaHash tabela= TabelaHash.getInstance();

        request.getSession().setAttribute("tabelaHash", TabelaHash.getInstance());
        try {
            request.getRequestDispatcher("sucess.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(InserirKeyPeqAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
