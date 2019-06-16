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
public class CriarTabelaGrdAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int tamKey2 = Integer.parseInt(request.getParameter("tamKey2"));
        int tamHash2 = Integer.parseInt(request.getParameter("tamHash2"));
        int segHash2 = Integer.parseInt(request.getParameter("segHash2"));
        TabelaHash.getInstance().criaArray(tamHash2);
        TabelaHash.getInstance().setPrimo1(tamHash2);
        TabelaHash.getInstance().setPrimo2(segHash2);
        request.getSession().setAttribute("tabelaHash", TabelaHash.getInstance());
        request.getSession().setAttribute("array", TabelaHash.getInstance().getArray());
        request.getSession().setAttribute("tamKey2", tamKey2);
        try {
            request.getRequestDispatcher("sucess.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(CriarTabelaGrdAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
