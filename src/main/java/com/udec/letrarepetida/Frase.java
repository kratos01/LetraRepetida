/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.letrarepetida;

import java.util.Scanner;

/**
 * @author David Arias  
 */
public class Frase {
 /**
  * costructor de la clase inicializado vacio
  */
    public Frase() {
    
    }
        /**
         * declaracion de los atributos privados
         */
        private String cadena;
        private char [] palabra;
        private boolean estado = false;
        private boolean estado2 = false;
    /**
     * metodo que guarda la frase que digita el usuario
     * e imprime el resultado
     */
    public void guardaFrase(){
        
        System.out.println("digite la frase a analizar: ");
        Scanner teclado = new Scanner(System.in);
        cadena = teclado.nextLine();
                 
        String temp = cadena.replace(" ","");
        palabra = temp.toCharArray();
        /**
         * si el metodo recorrido retorna un vacio imprime que todas las letras se repiten
         * si no imprime la primera letra que no se repita.
         */
        if(recorrido(palabra,estado,estado2) == ' ')
            System.out.println("Todas se repiten");
        else
            System.out.println("Letra no repetida: "+recorrido(palabra,estado,estado2));
        
    }
    /**
     * 
     * @param letra parametro que recibe la frase
     * @param estado estado de control
     * @param estado2 estado de control para el bucle
     * @return retorna la letra 
     * metodo que recibe la frase la recorre y devuelve la letra que se repite o las que no se repiten.
     */
    public char recorrido(char[] letra, boolean estado, boolean estado2){
        char norepetida = ' ';
        for(int i =0; i<letra.length && estado2 == false;i++){
            System.out.println("Leyendo: "+letra[i]);
            estado = false;
            for(int j =0; j<letra.length && estado == false ;j++){
                if(i == j){
                    if(j != letra.length)
                        j++;
                }
                if( letra[i] == letra[j]){
                    estado = true;
                    System.out.println("Repetida: "+letra[j]);
                    norepetida =  ' ';
                }else{
                    norepetida = letra[i];
                }
            }
            if(norepetida != ' ')
                estado2 = true;
        }
        return norepetida;
    }
}
