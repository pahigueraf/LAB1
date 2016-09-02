/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SegundoPuntoC;

import java.util.Scanner;

/**
 *  Clase que filtra la información (edad, género, estado civil y salario) de los usuarios de una revista
 * @author Pedro Alexander Higuera
 */
public class DailyLifeMagazine 
{
    public static void main(String[]args)
    {
        Datos();
    }
    /**
     * Datos
     * Llena la base de datos de la revista y establece un menú de opciones de filtros.
     */
    public static void Datos()
    {
        Scanner sn= new Scanner(System.in);
        System.out.println("De cuantas personas quiere ingresar la información?");
        int numDatos = sn.nextInt();
        int[] age = new int[numDatos];
        int[] gender= new int[numDatos];
        int[] maritalStatus=new int[numDatos];
        int[] annualIncome = new int [numDatos];
        for (int i=0; i<numDatos;i++)
        {
            
            System.out.println("Ingrese edad");
            age[i]=sn.nextInt();
            System.out.println("Ingrese género 1.Femenino 2.Masculino");
            gender[i]=sn.nextInt();
            System.out.println("Ingrese estado civil 1.Soltero 2.Casado");
            maritalStatus[i]=sn.nextInt();
            System.out.println("Ingrese salario anual");
            annualIncome[i]=sn.nextInt();
        }
        System.out.println("Escoja un filtro: 1.Edad 2.Género 3.Edad y Género 4. Salario");
        int filter = sn.nextInt();
        switch (filter) {
            case 1:
                filtroEdad(age);
                break;
            case 2:
                filtroGenero(gender);
                break;
            case 3:
                filtroEdadGenero(age,gender);
                break;
            default:
                filtroIngresoAnual(annualIncome);
                break;
        }
    }
    /**
     * filtroEdad
     * Realiza el filtro por edad de la base de datos de la revista.
     * @param a 
     */
    public static void filtroEdad(int[] a)
    {
        int readersUnderAge20=0;
        int readersAge20_29=0;
        int readersAge30_39=0;
        int readersAge40_49=0;
        int readersAge50more=0;
        for (int i=0;i<a.length;i++)
        {                      
            if (a[i]<20)
                readersUnderAge20++;
            else if (a[i]<30)
                readersAge20_29++;
            else if (a[i]<40)
                readersAge30_39++;
            else if (a[i]<50)
                readersAge40_49++;
            else
                readersAge50more++;
                
        }
        System.out.println("Lectores menores de 20 años: "+readersUnderAge20);
        System.out.println("Lectores entre 20 y 29 años: "+readersAge20_29);
        System.out.println("Lectores entre 30 y 39 años: "+readersAge30_39);
        System.out.println("Lectores entre 40 y 49 años: "+readersAge40_49);
        System.out.println("Lectores mayores de 50 años: "+readersAge50more);
        
    }
    /**
     * filtroGenero
     * Establece el filtro por género de la base de datos de la revista.
     * @param a 
     */
    public static void filtroGenero(int[]a)
    {
        int females=0;
        int males=0; 
        for (int i=0;i<a.length;i++)
        {                                  
            if (a[i]==1)
                females++;
            else
                males++;
        }
        System.out.println("Lectores de género femenino: "+females);
        System.out.println("Lectores de género masculino: "+males);
    }
    /**
     * filtroEdadGenero
     * Obtiene el filtro de edad y género de la base de datos de la revista.
     * @param age
     * @param gender 
     */
    public static void filtroEdadGenero(int[]age, int[]gender)
    {
        int femalesUnderAge20=0;
        int femalesAge20_29=0;
        int femalesAge30_39=0;
        int femalesAge40_49=0;
        int femalesAge50more=0;
        int malesUnderAge20=0;
        int malesAge20_29=0;
        int malesAge30_39=0;
        int malesAge40_49=0;
        int malesAge50more=0;
        for (int i=0;i<age.length;i++)
        {                      
            if (age[i]<20&&gender[i]==1)
                femalesUnderAge20++;
            else if (age[i]<30&&gender[i]==1)
                femalesAge20_29++;
            else if (age[i]<40&&gender[i]==1)
                femalesAge30_39++;
            else if (age[i]<50&&gender[i]==1)
                femalesAge40_49++;
            else if (age[i]>=50&&gender[i]==1)
                femalesAge50more++;
            else if (age[i]<20&&gender[i]==2)
                malesUnderAge20++;
            else if (age[i]<30&&gender[i]==2)
                malesAge20_29++;
            else if (age[i]<40&&gender[i]==2)
                malesAge30_39++;
            else if (age[i]<50&&gender[i]==2)
                malesAge40_49++;
            else
                malesAge50more++;
                
        }
        System.out.println("Mujeres menores de 20 años: "+femalesUnderAge20);
        System.out.println("Mujeres entre 20 y 29 años: "+femalesAge20_29);
        System.out.println("Mujeres entre 30 y 39 años: "+femalesAge30_39);
        System.out.println("Mujeres entre 40 y 49 años: "+femalesAge40_49);
        System.out.println("Mujeres mayores de 50 años: "+femalesAge50more);
        System.out.println("Hombres menores de 20 años: "+malesUnderAge20);
        System.out.println("Hombres entre 20 y 29 años: "+malesAge20_29);
        System.out.println("Hombres entre 30 y 39 años: "+malesAge30_39);
        System.out.println("Hombres entre 40 y 49 años: "+malesAge40_49);
        System.out.println("Hombres mayores de 50 años: "+malesAge50more);
    }
    /**
     * filtroIngresoAnual
     * Establece el filtro del salario anual de los usuarios de la revista
     * @param a 
     */
    public static void filtroIngresoAnual(int []a)
    {
        int incomeUnder30k=0;
        int income30k_49k=0;
        int income50k_69k=0;
        int income70korMore=0;
        for (int i=0;i<a.length;i++)
        {                      
            if (a[i]<30000)
                incomeUnder30k++;
            else if (a[i]<50000)
                income30k_49k++;
            else if (a[i]<70000)
                income50k_69k++;
            else 
                income70korMore++;
                
        }
        System.out.println("Lectores con salario anual por debajo de $30k: "+incomeUnder30k);
        System.out.println("Lectores con salario anual entre $30k y $49999: "+income30k_49k);
        System.out.println("Lectores con salario anual entre $50k y $69999: "+income50k_69k);
        System.out.println("Lectores con salario anual mayor a $70k:"+income70korMore);
    }
}
