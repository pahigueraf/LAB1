/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrimerPunto;

/**
 * Funciones
 * Clase en la que se puede identificar
 * en qué momento o en qué
 * orden se llaman a las funciones desde
 * el main.
 * 
 * @author Pedro Higuera
 * @version 1.0
 * @since 26/08/2016
 */
public class Funciones 
{
    /**
     * Función que imprime un mensaje
     */
    public static void func1()
    {
        System.out.println("Segunda Función");
    }
    /**
     * Función que imprime un mensaje
     */
    public static void func2()
    {
        System.out.println("Tercera Función");
    }
    /**
     * Función ejecutable.
     * @param args Sin parámetros
     */
    public static void main(String[] args)
    {
        //Imprime un mensaje
        System.out.println("Primera Funcion en Main");
        //Llama a la función func1
        func1();
        //Llama a la función func2
        func2();
        //Imprime un mensaje
        System.out.println("Se termina Main");
    }     
}

