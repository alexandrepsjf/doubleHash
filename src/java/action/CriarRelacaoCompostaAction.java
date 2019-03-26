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
import model.Leitor;
import model.Relacao;

/**
 *
 * @author alexandre
 */
public class CriarRelacaoCompostaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        int rel1 = Integer.parseInt(request.getParameter("rel1"));
        int rel2 = Integer.parseInt(request.getParameter("rel2"));
        String fileName = request.getParameter("url");
        Leitor leitor = new Leitor();
        leitor.lerArquivo(Buffer.readFile(fileName));
        Relacao relacaoA = new Relacao(leitor.getGroupByName(a), leitor.getGroupByName(b));
        Relacao relacaoB = new Relacao(leitor.getGroupByName(b), leitor.getGroupByName(c));
        relacaoA.setListaOrigem(request.getParameter("listaOrigemAB"));
        relacaoB.setListaOrigem(request.getParameter("listaOrigemBC"));
        relacaoA.setListaDestino(request.getParameter("listaDestinoAB"));
        relacaoB.setListaDestino(request.getParameter("listaDestinoBC"));
        relacaoA.selecionaRelacao(rel1);
        relacaoB.selecionaRelacao(rel2);
        Relacao relacaoC = relacaoA.criaComposta(relacaoB);
        request.setAttribute("resultado", relacaoC.getRelacao());
        request.setAttribute("url", fileName);

        try {
            request.getRequestDispatcher("resultadoRelacaoComposta.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(CriarArquivoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
