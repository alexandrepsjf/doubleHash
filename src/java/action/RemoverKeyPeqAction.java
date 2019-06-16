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
public class RemoverKeyPeqAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int key = Integer.parseInt(request.getParameter("key"));
        No result = TabelaHash.getInstance().remove(key);
        String resultado = "";
        if (result != null) {
            resultado = "A chave foi localizada na posi��o " + result.getPosicao() + " e com hist�rico de colis�es : " + result.getValor();
        } else {
            resultado = "Chave n�o localizada";
        }
        request.getSession().setAttribute("resultado", resultado);
        request.getSession().setAttribute("action", "PrepararKeyPeq");
        request.getSession().setAttribute("tabelaHash", TabelaHash.getInstance());
        request.getSession().setAttribute("array", TabelaHash.getInstance().getArray());

        try {
            request.getRequestDispatcher("resultado.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(RemoverKeyPeqAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
