/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author negro
 */
public class Relacao {

    private int[][] matriz;
    private Group origem, destino, dominio, imagem;
    private String clasificacao, relacao, listaOrigem, listaDestino;

    public Relacao(Group origem, Group destino) {
        this.origem = origem;
        this.destino = destino;
        this.dominio = new Group();
        this.imagem = new Group();
        this.clasificacao = "";
        this.relacao = "";
        this.listaDestino = "";
        this.listaOrigem = "";
    }

    public Relacao() {
        this.dominio = new Group();
        this.imagem = new Group();
        this.clasificacao = "";
        this.relacao = "";
        this.listaDestino = "";
        this.listaOrigem = "";
    }

    public String getListaOrigem() {
        return listaOrigem;
    }

    public void setListaOrigem(String listaOrigem) {
        this.listaOrigem = listaOrigem;
    }

    public String getListaDestino() {
        return listaDestino;
    }

    public void setListaDestino(String listaDestino) {
        this.listaDestino = listaDestino;
    }

    public String getRelacao() {
        return relacao;
    }

    public void setRelacao(String relacao) {
        this.relacao = relacao;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public Group getOrigem() {
        return origem;
    }

    public void setOrigem(Group origem) {
        this.origem = origem;
    }

    public Group getDestino() {
        return destino;
    }

    public void setDestino(Group destino) {
        this.destino = destino;
    }

    public Group getDominio() {
        return dominio;
    }

    public void setDominio(Group dominio) {
        this.dominio = dominio;
    }

    public Group getImagem() {
        return imagem;
    }

    public void setImagem(Group imagem) {
        this.imagem = imagem;
    }

    public String getClasificacao() {
        return clasificacao;
    }

    public void setClasificacao(String clasificacao) {
        this.clasificacao = clasificacao;
    }

    public Relacao criaComposta(Relacao relacaoBC) {
        Relacao relacaoAC = new Relacao(this.origem, relacaoBC.destino);
        relacaoAC.relacao = relacaoAC.origem.name + "Composta" + relacaoAC.destino.name;
        relacaoAC.setMatriz(relacaoAC.geraMatrizComposta(this.matriz, relacaoBC.matriz));
        String nome1 = "Origem" + relacaoAC.origem.name + "Composta" + relacaoAC.destino.name;
        String nome2 = "Destino" + relacaoAC.origem.name + "Composta" + relacaoAC.destino.name;
        relacaoAC.dominio.setName(nome1);
        relacaoAC.imagem.setName(nome2);
        for (int i = 0; i < relacaoAC.origem.getGroup().size(); i++) {
            Element elementoOrigem = relacaoAC.origem.getGroup().get(i);
            for (int j = 0; j < relacaoAC.destino.getGroup().size(); j++) {
                Element elementoDestino = relacaoAC.destino.getGroup().get(j);
                if (relacaoAC.matriz[i][j] == 1) {
                    if (!relacaoAC.dominio.pertence(elementoOrigem)) {
                        relacaoAC.dominio.getGroup().add(elementoOrigem);
                    }
                    if (!relacaoAC.imagem.pertence(elementoDestino)) {
                        relacaoAC.imagem.getGroup().add(elementoDestino);
                    }
                }
            }
        }

        relacaoAC.montaRelacao();
        String relacao = relacaoAC.getRelacao() + relacaoAC.classifica(relacaoAC.matriz);
        relacaoAC.setRelacao(relacao);
        return relacaoAC;

    }

    public int[][] geraMatrizComposta(int[][] matrizA, int[][] matrizC) {
        int m = matrizA.length;
        int n = matrizC[0].length;
        int[][] resultado = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < matrizA[0].length; k++) {
                    resultado[i][j] += (matrizA[i][k] * matrizC[k][j]);
                }
            }
        }
        return resultado;
    }

    public void montaRelacao() {
        this.relacao += "={";
        int cont = 0;
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                if (matriz[linha][coluna] == 1) {
                    if (cont > 0) {
                        this.relacao += ",";
                    }
                    this.relacao += "<";
                    this.relacao += this.origem.getGroup().get(linha).getValue() + ","
                            + this.destino.getGroup().get(coluna).getValue();
                    this.relacao += ">";
                    cont++;
                }
            }

        }
        this.relacao += "}";
        this.relacao += "</br>" + dominio.getGrupo() + " (dominio de definição) </br>" + imagem.getGrupo() + " (imagem)";

    }

    public void MaiorQue() {
        int tam1 = this.origem.getGroup().size();
        int tam2 = this.destino.getGroup().size();
        this.matriz = new int[tam1][tam2];
        String nome1 = "Origem" + this.origem.name + "maiorQue" + this.destino.name;
        String nome2 = "Destino" + this.origem.name + "maiorQue" + this.destino.name;
        this.dominio.setName(nome1);
        this.imagem.setName(nome2);
        this.relacao = this.origem.name + "maiorQue" + this.destino.name;
        for (int i = 0; i < this.origem.getGroup().size(); i++) {
            Element elementoOrigem = this.origem.getGroup().get(i);
            for (int j = 0; j < this.destino.getGroup().size(); j++) {
                Element elementoDestino = this.destino.getGroup().get(j);
                int a = elementoOrigem.getValue();
                int b = elementoDestino.getValue();
                if (a > b) {
                    this.matriz[i][j] = 1;
                    if (!this.dominio.pertence(elementoOrigem)) {
                        this.dominio.getGroup().add(elementoOrigem);
                    }
                    if (!this.imagem.pertence(elementoDestino)) {
                        this.imagem.getGroup().add(elementoDestino);
                    }
                }
            }
        }
        this.montaRelacao();
        this.relacao += classifica(matriz);
    }

    public String classifica(int[][] matriz) {

        String classifica = "";
        if (Relacao.isTotal(matriz)) {
            classifica += " </br>Essa relação é TOTAL";
        } else {
            classifica += " </br>essa relação NÃO é TOTAL";
        }
        if (Relacao.isSobrejetora(matriz)) {
            classifica += " </br>Essa relação é SOBREJETORA";
        } else {
            classifica += " </br>Essa relação NÃO é SOBREJETORA";
        }
        if (Relacao.isFuncional(matriz)) {
            classifica += " </br>Essa relação é FUNCIONAL";
        } else {
            classifica += " </br>essa relação NÃO é FUNCIONAL";
        }
        if (Relacao.isInjetora(matriz)) {
            classifica += " </br>Essa relação é INJETORA";
        } else {
            classifica += " </br>essa relação NÃO é INJETORA";
        }
        classifica += "</br> portanto essa relação ";
        if (Relacao.isMonomorfa(matriz)) {
            classifica += "</br>Tem MONOMORFISMO e";
        } else {
            classifica += "</br>NÃO tem MONOMORFISMO e";
        }
        if (Relacao.isEpimorfa(matriz)) {
            classifica += "</br>Tem EPIMORFISMO e, por conseguinte,";
        } else {
            classifica += "</br>NÃO tem EPIMORFISMO e, por conseguinte,";
        }
        if (Relacao.isIsomorfa(matriz)) {
            classifica += "</br>Tem ISOMORFISMO";
        } else {
            classifica += "</br>NÃO tem ISOMORFISMO";
        }
        return classifica;
    }

    public void MenorQue() {
        int tam1 = this.origem.getGroup().size();
        int tam2 = this.destino.getGroup().size();
        this.matriz = new int[tam1][tam2];
        String nome1 = "Origem" + this.origem.name + "menorQue" + this.destino.name;
        String nome2 = "Destino" + this.origem.name + "menorQue" + this.destino.name;
        this.dominio.setName(nome1);
        this.imagem.setName(nome2);
        this.relacao = this.origem.name + "menorQue" + this.destino.name;
        for (int i = 0; i < this.origem.getGroup().size(); i++) {
            Element elementoOrigem = this.origem.getGroup().get(i);
            for (int j = 0; j < this.destino.getGroup().size(); j++) {
                Element elementoDestino = this.destino.getGroup().get(j);
                int a = elementoOrigem.getValue();
                int b = elementoDestino.getValue();
                if (a < b) {
                    this.matriz[i][j] = 1;

                    if (!this.dominio.pertence(elementoOrigem)) {
                        this.dominio.getGroup().add(elementoOrigem);
                    }
                    if (!this.imagem.pertence(elementoDestino)) {
                        this.imagem.getGroup().add(elementoDestino);
                    }

                }
            }
        }
        this.montaRelacao();
        this.relacao += classifica(this.matriz);
    }

    public void IgualA() {
        int tam1 = this.origem.getGroup().size();
        int tam2 = this.destino.getGroup().size();
        this.matriz = new int[tam1][tam2];
        String nome1 = "Origem" + this.origem.name + "igualA" + this.destino.name;
        String nome2 = "Destino" + this.origem.name + "igualA" + this.destino.name;
        this.dominio.setName(nome1);
        this.imagem.setName(nome2);
        this.relacao = this.origem.name + "igualA" + this.destino.name;
        for (int i = 0; i < origem.getGroup().size(); i++) {
            Element elementoOrigem = origem.getGroup().get(i);
            for (int j = 0; j < destino.getGroup().size(); j++) {
                Element elementoDestino = destino.getGroup().get(j);
                int a = elementoOrigem.getValue();
                int b = elementoDestino.getValue();
                if (a == b) {
                    matriz[i][j] = 1;
                    if (!dominio.pertence(elementoOrigem)) {
                        dominio.getGroup().add(elementoOrigem);
                    }
                    if (!imagem.pertence(elementoDestino)) {
                        imagem.getGroup().add(elementoDestino);
                    }

                }
            }
        }
        this.montaRelacao();
        this.relacao += classifica(this.matriz);
    }

    public void quadrado() {
        int tam1 = this.origem.getGroup().size();
        int tam2 = this.destino.getGroup().size();
        this.matriz = new int[tam1][tam2];
        String nome1 = "Origem" + this.origem.name + "quadradoDe" + this.destino.name;
        String nome2 = "Destino" + this.origem.name + "quadradoDe" + this.destino.name;
        this.dominio.setName(nome1);
        this.imagem.setName(nome2);
        this.relacao = this.origem.name + "quadradoDe" + this.destino.name;
        for (int i = 0; i < origem.getGroup().size(); i++) {
            Element elementoOrigem = origem.getGroup().get(i);
            for (int j = 0; j < destino.getGroup().size(); j++) {
                Element elementoDestino = destino.getGroup().get(j);
                int a = elementoOrigem.getValue();
                int b = elementoDestino.getValue();
                if (a == (b * b)) {
                    matriz[i][j] = 1;
                    if (!dominio.pertence(elementoOrigem)) {
                        dominio.getGroup().add(elementoOrigem);
                    }
                    if (!imagem.pertence(elementoDestino)) {
                        imagem.getGroup().add(elementoDestino);
                    }

                }
            }
        }
        this.montaRelacao();
        this.relacao += classifica(this.matriz);
    }

    public void raizQuadrada() {
        int tam1 = this.origem.getGroup().size();
        int tam2 = this.destino.getGroup().size();
        this.matriz = new int[tam1][tam2];
        String nome1 = "Origem" + this.origem.name + "raizQuadradaDe" + this.destino.name;
        String nome2 = "Destino" + this.origem.name + "raizQuadradaDe" + this.destino.name;
        this.dominio.setName(nome1);
        this.imagem.setName(nome2);
        this.relacao = this.origem.name + "raizQuadradaDe" + this.destino.name;
        for (int i = 0; i < origem.getGroup().size(); i++) {
            Element elementoOrigem = origem.getGroup().get(i);
            for (int j = 0; j < destino.getGroup().size(); j++) {
                Element elementoDestino = destino.getGroup().get(j);
                int a = elementoOrigem.getValue();
                int b = elementoDestino.getValue();
                if (a == Math.sqrt(b)) {
                    matriz[i][j] = 1;
                    if (!dominio.pertence(elementoOrigem)) {
                        dominio.getGroup().add(elementoOrigem);
                    }
                    if (!imagem.pertence(elementoDestino)) {
                        imagem.getGroup().add(elementoDestino);
                    }
                }
            }
        }
        this.montaRelacao();
        this.relacao += classifica(this.matriz);
    }

    public static boolean isFuncional(int[][] matriz) {
        boolean result = true;
        for (int linha = 0; linha < matriz.length; linha++) {
            int cont = 0;
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                if (matriz[linha][coluna] == 1) {
                    cont++;
                }
            }
            if (cont > 1) {
                return false;
            } else {
                result = true;
            }
        }
        return result;
    }

    public static boolean isSobrejetora(int[][] matriz) {
        boolean result = true;
        for (int coluna = 0; coluna < matriz[0].length; coluna++) {
            int cont = 0;
            for (int linha = 0; linha < matriz.length; linha++) {
                if (matriz[linha][coluna] == 1) {
                    cont++;
                }
            }
            if (cont == 0) {
                return false;
            }
        }
        return result;
    }

    public static boolean isInjetora(int[][] matriz) {
        boolean result = true;
        for (int coluna = 0; coluna < matriz[0].length; coluna++) {
            int cont = 0;
            for (int linha = 0; linha < matriz.length; linha++) {
                if (matriz[linha][coluna] == 1) {
                    cont++;
                }
            }
            if (cont > 1) {
                return false;
            }
        }
        return result;
    }

    public static boolean isTotal(int[][] matriz) {
        boolean result = true;
        for (int linha = 0; linha < matriz.length; linha++) {
            int cont = 0;
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                if (matriz[linha][coluna] == 1) {
                    cont++;
                }
            }
            if (cont == 0) {
                return false;
            }
        }
        return result;
    }

    public static boolean isMonomorfa(int[][] matriz) {
        boolean result = false;
        if (isTotal(matriz) && isInjetora(matriz)) {
            result = true;
        }
        return result;
    }

    public static boolean isEpimorfa(int[][] matriz) {
        boolean result = false;
        if (isFuncional(matriz) && isSobrejetora(matriz)) {
            result = true;
        }
        return result;
    }

    public static boolean isIsomorfa(int[][] matriz) {
        boolean result = false;
        if (isEpimorfa(matriz) && isMonomorfa(matriz)) {
            result = true;
        }
        return result;
    }

    public static boolean validaLista(Group origem, String listaOrigem, Group destino, String listaDestino) {

        listaOrigem = listaOrigem.replaceAll(" ", "");
        String listaOri[] = listaOrigem.split(",");
        listaDestino = listaDestino.replaceAll(" ", "");
        String listaDes[] = listaDestino.split(",");
        if (listaDes.length == listaOri.length) {
            for (int i = 0; i < listaOri.length; i++) {
                Element aux = new Element(listaOri[i]);
                aux.setValue(Integer.parseInt(listaOri[i]));
                if (!origem.pertence(aux)) {
                    return false;
                }

            }
        } else {
            return false;
        }
        return true;
    }

    public void arbitraria(String listaOrigem, String listaDestino) {
        int tam1 = this.origem.getGroup().size();
        int tam2 = this.destino.getGroup().size();
        this.matriz = new int[tam1][tam2];
        listaOrigem = listaOrigem.replaceAll(" ", "");
        String listaOri[] = listaOrigem.split(",");
        listaDestino = listaDestino.replaceAll(" ", "");
        String listaDes[] = listaDestino.split(",");
        String nome1 = "Origem" + this.origem.name + "arbitraria" + this.destino.name;
        String nome2 = "Destino" + this.origem.name + "arbitraria" + this.destino.name;
        this.dominio.setName(nome1);
        this.imagem.setName(nome2);
        for (int i = 0; i < listaOri.length; i++) {
            Element aux = new Element(listaOri[i]);
            aux.setValue(Integer.parseInt(listaOri[i]));
            this.dominio.getGroup().add(aux);
        }
        for (int i = 0; i < listaDes.length; i++) {
            Element aux = new Element(listaDes[i]);
            aux.setValue(Integer.parseInt(listaDes[i]));
            this.imagem.getGroup().add(aux);
        }
        this.relacao = this.origem.name + "arbitraria" + this.destino.name;
        for (int g = 0; g < this.dominio.getGroup().size(); g++) {
            Element arbitrarioA = this.dominio.getGroup().get(g);
            Element arbitrarioB = this.imagem.getGroup().get(g);
            for (int i = 0; i < this.origem.getGroup().size(); i++) {
                Element elementoLinha = this.origem.getGroup().get(i);
                for (int j = 0; j < this.destino.getGroup().size(); j++) {
                    Element elementoColuna = this.destino.getGroup().get(j);
                    if ((elementoLinha.equals(arbitrarioA)) && (elementoColuna.equals(arbitrarioB))) {
                        this.matriz[i][j] = 1;
                    }
                }

            }

        }
        this.montaRelacao();
        this.relacao += classifica(this.matriz);

    }

    public void selecionaRelacao(int rel) {
        switch (rel) {
            case 1:
                this.MaiorQue();
                break;
            case 2:
                this.MenorQue();
                break;

            case 3:
                this.IgualA();
                break;

            case 4:
                this.quadrado();
                break;

            case 5:
                this.raizQuadrada();
                break;

            case 6:
                this.arbitraria(this.listaOrigem, this.listaDestino);
                break;

            default:
                break;
        }
    }
}
