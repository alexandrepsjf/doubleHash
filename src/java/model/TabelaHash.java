/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author negro
 */
public class TabelaHash {

     No[] array;

    public No[] getArray() {

        return array;
    }

    public TabelaHash(int tam) {
        this.array = new No[tam];
        this.criaArray();
    }

    public void setArray(No[] array) {
        this.array = array;
    }

    private void criaArray() {
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = new No();
            this.array[i].setPosicao(i+1);
            this.array[i].setValor("vazio");
        }
    }

}
