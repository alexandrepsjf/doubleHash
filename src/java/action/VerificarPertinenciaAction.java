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
import model.Element;
import model.Group;
import model.Leitor;

/**
 *
 * @author alexandre
 */
public class VerificarPertinenciaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String elemento = request.getParameter("elemento");
        String conjunto = request.getParameter("conjunto");
        String resultado = "";
        Element element = new Element();
        String fileName = request.getParameter("url");
        Leitor leitor = new Leitor();
        leitor.lerArquivo(Buffer.readFile(fileName));
        element = leitor.getElementByName(elemento);
        Boolean result = leitor.getGroupByName(conjunto).pertence(element);
        if (result) {
            resultado = "Elemento " + element.getName() + " Pertence ao Conjunto " + conjunto;
        } else {
            resultado = "Elemento " + element.getName() + " NÃO Pertence ao Conjunto " + conjunto;
        }
        request.setAttribute("resultado", resultado);
        request.setAttribute("url", fileName);
        request.setAttribute("Reverter", false );
        request.setAttribute("NA", true);
                request.setAttribute("Reverter", false);


        try {
            request.getRequestDispatcher("resultado.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(CriarArquivoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
