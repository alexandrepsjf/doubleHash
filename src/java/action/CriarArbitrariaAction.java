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
        String fileName = request.getParameter("url");
        String resultado="";
        Relacao relacao = new Relacao();
        Leitor leitor = new Leitor();
        leitor.lerArquivo(Buffer.readFile(fileName));
        String listaOrigem = request.getParameter("listaA");
        String listaDestino = request.getParameter("listaB");
        Group origem = leitor.getGroupByName(request.getParameter("a"));
        Group destino = leitor.getGroupByName(request.getParameter("b"));
        request.setAttribute("url", fileName);
        if ((Relacao.validaLista(origem, listaOrigem, destino, listaDestino))) {
             relacao.setOrigem(origem); 
             relacao.setDestino(destino); 
            relacao.arbitraria(listaOrigem, listaDestino);
            resultado=relacao.getRelacao();

        } else {
            resultado = "Lista de elementos inválida, refaça a operação";
        }

        request.setAttribute("resultado", resultado);
        request.setAttribute("url", fileName);
        try {
            request.getRequestDispatcher("resultadoRelacao.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(CriarArquivoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
