/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author alexandre
 */
public class Group {

    String name;
    private ArrayList<Element> group;

    private Group() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Element> getGroup() {
        return group;
    }

    public void setGroup(ArrayList<Element> group) {
        this.group = group;
    }

    public Group(String nome) {
        this.name = nome;
        this.group = new ArrayList();
    }

    public String getGrupo() {
        String result = this.name + " = { ";
        for (int i = 0; this.group.size() > i; i++) {
            if (i > 0) {
                result += ",";
            }
            result = result + this.getGroup().get(i).getName();

        }

        return result + "}";
    }

    public boolean pertence(Element e) {
        for (int i = 0; this.group.size() > i; i++) {
            if (this.group.get(i).equals(e)) {
                return true;
            }
        }
        return false;
    }

    public boolean contido(Group conjunto) {

        for (int j = 0; this.group.size() > j; j++) {
            if (!conjunto.pertence(this.group.get(j))) {
                return false;
            }
        }
        return true;
    }

    public boolean ProContido(Group conjunto) {
        if (this.group.size() < conjunto.group.size()) {
            return this.contido(conjunto);
        }
        return false;
    }

    public Group intersection(Group conjunto) {
        String nome = this.name + "intersecao" + conjunto.name;
        Group inter = new Group(nome);

        for (int j = 0; conjunto.group.size() > j; j++) {
            if (this.pertence(conjunto.group.get(j))) {
                inter.group.add(conjunto.group.get(j));
            }
        }
        return inter;
    }

    public Group union(Group conjunto) {
        String nome = this.name + "uniao" + conjunto.name;
        Group inter = new Group(nome);

        for (int i = 0; conjunto.group.size() > i; i++) {
            inter.group.add(conjunto.group.get(i));
        }
        for (int j = 0; this.group.size() > j; j++) {
            if (!inter.pertence(this.group.get(j))) {
                inter.group.add(this.group.get(j));
            }
        }
        return inter;
    }

    public String cartesiano(Group conjunto) {
        String cartesiano = this.name + "cartesiano" + conjunto.name;
        cartesiano += "={";
        for (int i = 0; i < this.group.size(); i++) {

            for (int j = 0; j < conjunto.group.size(); j++) {
                if (j > 0 || i > 0) {
                    cartesiano += ",";
                }
                cartesiano += "<";
                cartesiano += this.group.get(i).getValue() + "," + conjunto.group.get(j).getValue();
                cartesiano += ">";
            }

        }

        cartesiano += "}";
        return cartesiano;
    }
    

    public static String reverterCartesiano(String resultado) {
        String nome = resultado.replaceAll(" ", "");
        String nome1 = nome.replaceAll("<", "");
        String nome2[] = nome1.split("cartesiano|\\=|\\{|\\}|\\>,");
        Group conjuntoA = new Group(nome2[0]);
        Group conjuntoB = new Group(nome2[1]);
        for (int i = 3; i < nome2.length; i++) {
            String array[] = nome2[i].split(",");
            String name = array[0];
            Element e = new Element(name);
            e.setValue(Integer.parseInt(name));
            if (!conjuntoA.pertence(e)) {
                conjuntoA.getGroup().add(e);
            }
        }
        for (int i = 3; i < nome2.length; i++) {
            String array[] = nome2[i].split(",");
            String name = array[1];
            name = name.replaceAll(">", "");
            Element e = new Element(name);
            e.setValue(Integer.parseInt(name));
            if (!conjuntoB.pertence(e)) {
                conjuntoB.getGroup().add(e);
            }
        }
        String str = "Os conjuntos originais eram" + conjuntoA.getGrupo() + " e " + conjuntoB.getGrupo();

        return str;
    }

    public static Group unirMulti(String lista, Leitor leitor) {
        lista = lista.replaceAll(" ", "");
        String str[] = lista.split(",");
        Group uniao = leitor.getGroupByName(str[0]);
        for (int i = 1; i < str.length; i++) {
            Group aux = leitor.getGroupByName(str[i]);
            uniao = uniao.union(aux);
        }
        return uniao;
    }

    public static Group interMulti(String lista, Leitor leitor) {
        lista = lista.replaceAll(" ", "");
        String str[] = lista.split(",");
        Group inter = leitor.getGroupByName(str[0]);
        for (int i = 1; i < str.length; i++) {
            Group aux = leitor.getGroupByName(str[i]);
            inter = inter.intersection(aux);
        }
        return inter;
    }

    public String partes() {
        int combi = 1;
        String resultado = "P(X)=";
        int tam = this.getGroup().size();
        String[] array = new String[tam];
        for (int i = 0; i < tam; i++) {
            resultado += "{";
            resultado += this.getGroup().get(i).getName() + "},";
            for (int j = 1; j < tam - i; j++) {
                resultado += "{";
                resultado += this.getGroup().get(i).getName();
                for (int k = 1; k < tam; k++) {
                    resultado += "," + this.getGroup().get(combi).getName();

                }
                resultado += "}";
            }

        }
        return resultado;

    }
}
