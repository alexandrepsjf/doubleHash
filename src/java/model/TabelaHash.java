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
     int tamanho;
     int ocupacao;
     int primo1;
     int primo2;
    public No[] getArray() {

        return array;
    }

    public TabelaHash(int tam) {
        tamanho =tam;
        ocupacao =0;
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
    public int getTamanho()
    {
        return tamanho;
    }
    private int hash1(int valor){
        int hashValor = valor%primo1;        
        return hashValor;
    }
    private int hash2(int valor){
        int hashValor = valor%primo2;        
        return hashValor;
    }
    
    public void insert(int key, String value){
        if (ocupacao == tamanho)
        {
            System.out.println("Table full"); 
            return;
        }           
        int hash1 = hash1( key );
        int hash2 = hash2( key );        
        while (array[hash1] != null)
        {
            hash1 += hash2;
            hash1 %= tamanho;
        }
        array[hash1] = new No(key, value);        
        ocupacao++;
    }
    public No get(int key){
        int hash1 = hash1( key );
        int hash2 = hash2( key );
        int cont=0;
        while (array[hash1] != null || cont>tamanho)
        {
            if(array[hash1].getKey()==key){
                return array[hash1];
            }
            hash1 += hash2;
            hash1 %= tamanho;
            cont ++;
        }
        return null;
    }
    public No remove(int key){
        int hash1 = hash1( key );
        int hash2 = hash2( key );
        int cont=0;        
        while (array[hash1] != null || cont>tamanho)
        {
            if(array[hash1].getKey()==key){
                No temp = array[hash1];
                array[hash1]=null;
                ocupacao--;
                return temp;
            }           
            hash1 += hash2;
            hash1 %= tamanho;
            cont ++;
        }
        return null;
    }
       
}
