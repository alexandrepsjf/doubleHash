/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static java.awt.SystemColor.text;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexandre
 */
public class Leitor {

    private ArrayList<Element> listaElementos;
    private ArrayList<Group> listaConjuntos;

    public Leitor() {
        listaElementos = new ArrayList<Element>();
        listaConjuntos = new ArrayList<Group>();
    }

    public ArrayList getListaElementos() {
        return listaElementos;
    }

    public void setListaElementos(ArrayList listaElementos) {
        this.listaElementos = listaElementos;
    }

    public ArrayList getListaConjuntos() {
        return listaConjuntos;
    }

    public void setListaConjuntos(ArrayList listaConjuntos) {
        this.listaConjuntos = listaConjuntos;
    }

    public  Group getGroupByName(String name) {
        Group conjunto = new Group(name);
        for (Group group : this.listaConjuntos) {
            if (group.getName().equals(name)) {
                conjunto = group;
            }
        }

        return conjunto;
    }
    public Element getElementByName(String name) {
        Element element = new Element(name);
        for (Element e : this.listaElementos) {
            if (e.getName().equals(name)) {
                element = e;
            }
        }
        return element;
    }

    public void lerArquivo(ArrayList text) {       
        for (Object linha : text) {
            String str = linha.toString().replaceAll(" ", "");
            String[] array = str.split("\\=|\\{|,|\\}");
            char chr = linha.toString().charAt(0);
            if (Character.isUpperCase(chr)) {
                Group conjunto = new Group(Character.toString(chr));
                for (int i = 1; array.length > i; i++) {
                    String chr1;
                    chr1 = array[i];
                    {
                        if (!chr1.equals("")) {
                            Element e = new Element(chr1);
                            e.setValue(Integer.parseInt(chr1));
                            conjunto.getGroup().add(e);

                        }

                    }
                }
                this.listaConjuntos.add(conjunto);
            } else {

                Element e = new Element(Character.toString(chr));
                e.setValue(Integer.parseInt(array[1]));
                this.listaElementos.add(e);
            }
        }

    }
}
