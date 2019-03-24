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

    public static String MaiorQue(Group origem, Group destino) {
        int tam1 = origem.getGroup().size();
        int tam2 = destino.getGroup().size();
        int[][] matriz = new int[tam1][tam2];
        String nome1 = "Origem" + origem.name + "maiorQue" + destino.name;
        String nome2 = "Destino" + origem.name + "maiorQue" + destino.name;
        Group dominio = new Group(nome1);
        Group imagem = new Group(nome2);
        String maiorQue = origem.name + "maiorQue" + destino.name;
        int maior = 0;
        maiorQue += "={";
        for (int i = 0; i < origem.getGroup().size(); i++) {
            Element elementoOrigem = origem.getGroup().get(i);
            for (int j = 0; j < destino.getGroup().size(); j++) {
                Element elementoDestino = destino.getGroup().get(j);
                int a = elementoOrigem.getValue();
                int b = elementoDestino.getValue();
                if (a > b) {
                    matriz[i][j] = 1;
                    if (maior > 0) {
                        maiorQue += ",";
                    }
                    if (!dominio.pertence(elementoOrigem)) {
                        dominio.getGroup().add(elementoOrigem);
                    }
                    if (!imagem.pertence(elementoDestino)) {
                        imagem.getGroup().add(elementoDestino);
                    }
                    maiorQue += "<";
                    maiorQue += a + "," + b;
                    maiorQue += ">";
                    maior++;
                }
            }
        }
        maiorQue += "}";
        maiorQue += "</br>" + dominio.getGrupo() + " (dominio de definição) </br>" + imagem.getGrupo() + " (imagem)";
        maiorQue += classifica(matriz);
        return maiorQue;
    }

    private static String classifica(int[][] matriz) {

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

    public static String MenorQue(Group origem, Group destino) {
        int tam1 = origem.getGroup().size();
        int tam2 = destino.getGroup().size();
        int[][] matriz = new int[tam1][tam2];
        String nome1 = "Origem" + origem.name + "menorQue" + destino.name;
        String nome2 = "Destino" + origem.name + "menorQue" + destino.name;
        Group dominio = new Group(nome1);
        Group imagem = new Group(nome2);
        String menorQue = origem.name + "menorQue" + destino.name;
        int menor = 0;
        menorQue += "={";
        for (int i = 0; i < origem.getGroup().size(); i++) {
            Element elementoOrigem = origem.getGroup().get(i);
            for (int j = 0; j < destino.getGroup().size(); j++) {
                Element elementoDestino = destino.getGroup().get(j);
                int a = elementoOrigem.getValue();
                int b = elementoDestino.getValue();
                if (a < b) {
                    matriz[i][j] = 1;
                    if (menor > 0) {
                        menorQue += ",";
                    }
                    if (!dominio.pertence(elementoOrigem)) {
                        dominio.getGroup().add(elementoOrigem);
                    }
                    if (!imagem.pertence(elementoDestino)) {
                        imagem.getGroup().add(elementoDestino);
                    }
                    menorQue += "<";
                    menorQue += a + "," + b;
                    menorQue += ">";
                    menor++;
                }
            }
        }
        menorQue += "}";
        menorQue += "</br>" + dominio.getGrupo() + " (dominio de definição) </br>" + imagem.getGrupo() + " (imagem)";
        menorQue += classifica(matriz);
        return menorQue;
    }

    public static String IgualA(Group origem, Group destino) {
        int tam1 = origem.getGroup().size();
        int tam2 = destino.getGroup().size();
        int[][] matriz = new int[tam1][tam2];
        String nome1 = "Origem" + origem.name + "igualA" + destino.name;
        String nome2 = "Destino" + origem.name + "igualA" + destino.name;
        Group dominio = new Group(nome1);
        Group imagem = new Group(nome2);
        String igualA = origem.name + "igualA" + destino.name;
        int igual = 0;
        igualA += "={";
        for (int i = 0; i < origem.getGroup().size(); i++) {
            Element elementoOrigem = origem.getGroup().get(i);
            for (int j = 0; j < destino.getGroup().size(); j++) {
                Element elementoDestino = destino.getGroup().get(j);
                int a = elementoOrigem.getValue();
                int b = elementoDestino.getValue();
                if (a == b) {
                    matriz[i][j] = 1;
                    if (igual > 0) {
                        igualA += ",";
                    }
                    if (!dominio.pertence(elementoOrigem)) {
                        dominio.getGroup().add(elementoOrigem);
                    }
                    if (!imagem.pertence(elementoDestino)) {
                        imagem.getGroup().add(elementoDestino);
                    }
                    igualA += "<";
                    igualA += a + "," + b;
                    igualA += ">";
                    igual++;
                }
            }
        }
        igualA += "}";
        igualA += "</br>" + dominio.getGrupo() + " (dominio de definição) </br>" + imagem.getGrupo() + " (imagem)";
        igualA += classifica(matriz);
        return igualA;
    }

    public static String quadrado(Group origem, Group destino) {
        int tam1 = origem.getGroup().size();
        int tam2 = destino.getGroup().size();
        int[][] matriz = new int[tam1][tam2];
        String nome1 = "Origem" + origem.name + "quadradoDe" + destino.name;
        String nome2 = "Destino" + origem.name + "quadradoDe" + destino.name;
        Group dominio = new Group(nome1);
        Group imagem = new Group(nome2);
        String quadradoDe = origem.name + "quadradoDe" + destino.name;
        int quadrado = 0;
        quadradoDe += "={";
        for (int i = 0; i < origem.getGroup().size(); i++) {
            Element elementoOrigem = origem.getGroup().get(i);
            for (int j = 0; j < destino.getGroup().size(); j++) {
                Element elementoDestino = destino.getGroup().get(j);
                int a = elementoOrigem.getValue();
                int b = elementoDestino.getValue();
                if (a == (b * b)) {
                    matriz[i][j] = 1;
                    if (quadrado > 0) {
                        quadradoDe += ",";
                    }
                    if (!dominio.pertence(elementoOrigem)) {
                        dominio.getGroup().add(elementoOrigem);
                    }
                    if (!imagem.pertence(elementoDestino)) {
                        imagem.getGroup().add(elementoDestino);
                    }
                    quadradoDe += "<";
                    quadradoDe += a + "," + b;
                    quadradoDe += ">";
                    quadrado++;
                }
            }
        }
        quadradoDe += "}";
        quadradoDe += "</br>" + dominio.getGrupo() + " (dominio de definição) </br>" + imagem.getGrupo() + " (imagem)";
        quadradoDe += classifica(matriz);
        return quadradoDe;
    }

    public static String raizQuadrada(Group origem, Group destino) {
        int tam1 = origem.getGroup().size();
        int tam2 = destino.getGroup().size();
        int[][] matriz = new int[tam1][tam2];
        String nome1 = "Origem" + origem.name + "raizQuadradaDe" + destino.name;
        String nome2 = "Destino" + origem.name + "raizQuadradaDe" + destino.name;
        Group dominio = new Group(nome1);
        Group imagem = new Group(nome2);
        String raizQuadradaDe = origem.name + "raizQuadradaDe" + destino.name;
        int raizQuadrada = 0;
        raizQuadradaDe += "={";
        for (int i = 0; i < origem.getGroup().size(); i++) {
            Element elementoOrigem = origem.getGroup().get(i);
            for (int j = 0; j < destino.getGroup().size(); j++) {
                Element elementoDestino = destino.getGroup().get(j);
                int a = elementoOrigem.getValue();
                int b = elementoDestino.getValue();
                if (a == Math.sqrt(b)) {
                    matriz[i][j] = 1;
                    if (raizQuadrada > 0) {
                        raizQuadradaDe += ",";
                    }
                    if (!dominio.pertence(elementoOrigem)) {
                        dominio.getGroup().add(elementoOrigem);
                    }
                    if (!imagem.pertence(elementoDestino)) {
                        imagem.getGroup().add(elementoDestino);
                    }
                    raizQuadradaDe += "<";
                    raizQuadradaDe += a + "," + b;
                    raizQuadradaDe += ">";
                    raizQuadrada++;
                }
            }
        }
        raizQuadradaDe += "}";
        raizQuadradaDe += "</br>" + dominio.getGrupo() + " (dominio de definição) </br>" + imagem.getGrupo() + " (imagem)";
        raizQuadradaDe += classifica(matriz);
        return raizQuadradaDe;
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

    public static String arbitraria(Group origem, String listaOrigem, Group destino, String listaDestino) {
        int tam1 = origem.getGroup().size();
        int tam2 = destino.getGroup().size();
        int[][] matriz = new int[tam1][tam2];
        listaOrigem = listaOrigem.replaceAll(" ", "");
        String listaOri[] = listaOrigem.split(",");
        listaDestino = listaDestino.replaceAll(" ", "");
        String listaDes[] = listaDestino.split(",");
        String nome1 = "Origem" + origem.name + "arbitraria" + destino.name;
        String nome2 = "Destino" + origem.name + "arbitraria" + destino.name;
        Group dominio = new Group(nome1);
        Group imagem = new Group(nome2);
        for (int i = 0; i < listaOri.length; i++) {
            Element aux = new Element(listaOri[i]);
            aux.setValue(Integer.parseInt(listaOri[i]));
            dominio.getGroup().add(aux);
        }
        for (int i = 0; i < listaDes.length; i++) {
            Element aux = new Element(listaDes[i]);
            aux.setValue(Integer.parseInt(listaDes[i]));
            imagem.getGroup().add(aux);
        }
        String arbitrariaDe = origem.name + "arbitraria" + destino.name;
        int arbitraria = 0;
        arbitrariaDe += "={";
        for (int g = 0; g < dominio.getGroup().size(); g++) {
            Element arbitrarioA = dominio.getGroup().get(g);
            Element arbitrarioB = imagem.getGroup().get(g);
            int a = arbitrarioA.getValue();
            int b = arbitrarioB.getValue();
            if (arbitraria > 0) {
                arbitrariaDe += ",";
            }
            arbitrariaDe += "<";
            arbitrariaDe += a + "," + b;
            arbitrariaDe += ">";
            arbitraria++;
            for (int i = 0; i < origem.getGroup().size(); i++) {
                Element elementoLinha = origem.getGroup().get(i);
                for (int j = 0; j < destino.getGroup().size(); j++) {
                    Element elementoColuna = destino.getGroup().get(j);
                    if ((elementoLinha.equals(arbitrarioA)) && (elementoColuna.equals(arbitrarioB))) {
                        matriz[i][j] = 1;
                    }
                }

            }

        }
        arbitrariaDe += "}";
        arbitrariaDe += "</br>" + dominio.getGrupo() + " (dominio de definição) </br>" + imagem.getGrupo() + " (imagem)";
        arbitrariaDe += classifica(matriz);
        return arbitrariaDe;

    }
}
