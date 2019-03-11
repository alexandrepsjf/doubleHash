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
import model.Buffer;
import model.Group;
import model.Leitor;

/**
 *
 * @author alexandre
 */
public class CriarProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String fileName = request.getParameter("url");
        Leitor leitor = new Leitor();
        leitor.lerArquivo(Buffer.readFile(fileName));
        String resultado  = leitor.getGroupByName(a).cartesiano(leitor.getGroupByName(b));
        request.setAttribute("resultado", resultado);
        request.setAttribute("url", fileName);
                request.setAttribute("Reverter", true );

        try {
            request.getRequestDispatcher("resultado.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(CriarArquivoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
