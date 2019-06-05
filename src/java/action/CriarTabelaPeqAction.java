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
public class CriarTabelaPeqAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int tamKey2 = Integer.parseInt(request.getParameter("tamKey2"));
        int tamHash2 = Integer.parseInt(request.getParameter("tamHash2"));
        TabelaHash tabela = new TabelaHash(tamHash2);
        request.setAttribute("tabela", tabela.getArray());
        request.setAttribute("tamKey2", tamKey2);
        try {
            request.getRequestDispatcher("sucess.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(CriarTabelaPeqAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
