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
public class TabelaHash {

    No[] array;
    int tamanho;
    int ocupacao;
    int primo1;
    int primo2;
    private static TabelaHash tabelaHash;

    public static synchronized TabelaHash getInstance() {
        if (tabelaHash == null) {
            tabelaHash = new TabelaHash();
            
        }

        return tabelaHash;
    }

    private TabelaHash() {
        
    }

    public No[] getArray() {

        return array;
    }

    public int getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(int ocupacao) {
        this.ocupacao = ocupacao;
    }

    public int getPrimo1() {
        return primo1;
    }

    public void setPrimo1(int primo1) {
        this.primo1 = primo1;
    }

    public int getPrimo2() {
        return primo2;
    }

    public void setPrimo2(int primo2) {
        this.primo2 = primo2;
    }

   
    public void setArray(No[] array) {
        this.array = array;
    }

    public void criaArray(int tam) {
        this.setArray(new No[tam]);
        this.tamanho=tam;
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = new No();
            this.array[i].setPosicao(i+1);
        }
    }

    public int getTamanho() {
        return tamanho;
    }

    private int hash1(int valor) {
        int hashValor = valor % primo1;
        return hashValor;
    }

    private int hash2(int valor) {
        int hashValor = primo2-(valor % primo2);
        return hashValor;
    }

    public void insert(int key, String value) {
        String historico="sem colisão";
        if (ocupacao == tamanho) {
            System.out.println("Table full");
            return;
        }
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        String anterior="";
        while (array[hash1].getKey() != 0) {
             anterior+=hash1;
            hash1 += hash2;
            hash1 %= tamanho;
            historico=anterior+" --> "+array[hash1].getPosicao();
            anterior="";
        }
        array[hash1].setKey(key);
        array[hash1].setValor(historico);
      
        ocupacao++;
    }

    public No get(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        int cont = 0;
        while (array[hash1] != null || cont > tamanho) {
            if (array[hash1].getKey() == key) {
                return array[hash1];
            }
            hash1 += hash2;
            hash1 %= tamanho;
            cont++;
        }
        return null;
    }

    public No remove(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        int cont = 0;
        while (array[hash1] != null || cont > tamanho) {
            if (array[hash1].getKey() == key) {
                No temp = array[hash1];
                array[hash1] = null;
                ocupacao--;
                return temp;
            }
            hash1 += hash2;
            hash1 %= tamanho;
            cont++;
        }
        return null;
    }

}
