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
import model.Relacao;

/**
 *
 * @author alexandre
 */
public class CriarArbitrariaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String fileName = request.getParameter("url");
        Leitor leitor = new Leitor();
        leitor.lerArquivo(Buffer.readFile(fileName));
        String resultado  = Relacao.MaiorQue(leitor.getGroupByName(a),leitor.getGroupByName(b));
        request.setAttribute("resultado", resultado);
        request.setAttribute("url", fileName);

        try {
            request.getRequestDispatcher("resultadoRelacao.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(CriarArquivoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
