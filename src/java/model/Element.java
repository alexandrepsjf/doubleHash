/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author alexandre
 */
public class Element {

    private String name;
    private int value;
private static List listElement;

    public static List getListElement() {
        return listElement;
    }

    public static void setListElement(List listElement) {
        Element.listElement = listElement;
    }

    Element(String character) {
        this.name=character;
    }

    public Element() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean equals(Element e) {
        if (this.value == e.getValue()) {
            return true;
        } else {
            return false;
        }
    }
}
