/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SegundoPuntoA;

import java.util.Scanner;

/**
 *  Clase en la que el usuario trata de adivinar 3 números entre 0 y 9.
 * Dependiendo de los aciertos que tenga, ganará una recompensa.
 * @author Pedro Alexander Higuera
 */
public class LotteryGame 
{
    /**
     * Función ejecutable.
     * Llama a la función lotteryGame
     * @param args 
     */
    public static void main(String []args)
    {
        System.out.println("Welcome to Lottery Game!!");
        lotteryGame();
    }
    /**
     * LotteryGame
     * El usuario ingresa 3 números. Se reciben los 3 números aleatorios.
     * Se comparan cada uno de ellos. 
     */
    public static void lotteryGame()
    {        
        Scanner sn = new Scanner(System.in);
        System.out.println("Ingrese el primer número ");
        int firstNumber = sn.nextInt();
        System.out.println("Ingrese el segundo número ");
        int secondNumber = sn.nextInt();
        System.out.println("Ingrese el tercer número ");
        int thirdNumber = sn.nextInt();
        int firstNumberLottery = randomNumbers();
        int secondNumberLottery = randomNumbers();
        int thirdNumberLottery = randomNumbers();
        int counter = 0;
        if (firstNumber == firstNumberLottery || firstNumber== secondNumberLottery || firstNumber==thirdNumberLottery)
            counter++;
        if (secondNumber == firstNumberLottery || secondNumber== secondNumberLottery || secondNumber==thirdNumberLottery)
            counter++;
        if (thirdNumber == firstNumberLottery || thirdNumber== secondNumberLottery || thirdNumber==thirdNumberLottery)                                                
            counter++;
        if (counter==3)
        {
            if (firstNumber == firstNumberLottery && secondNumber== secondNumberLottery && thirdNumber==thirdNumberLottery)
                counter++;
            
        }
        calculateAward(counter);
        System.out.println("User's guess: "+firstNumber+" "+secondNumber+" "+thirdNumber);
        System.out.println("lottery numbers: "+firstNumberLottery+" "+secondNumberLottery+" "+thirdNumberLottery);
    } 
    /**
     * randomNumbers
     * Retorna un número aleatorio entre 0 y 9
     * @return 
     */
    public static int randomNumbers()
    {
        int randomNumbers=(int)Math.floor((Math.random()*10));
        return randomNumbers;
    }
    /**
     * calculateAward
     * Calcula la recompensa por los aciertos que tenga el usuario
     * @param counter 
     */
    public static void calculateAward(int counter)
    {
        if (counter==0)
            System.out.println("Award: 0");
        if (counter==1)
            System.out.println("Award: 10");
        if (counter==2)
            System.out.println("Award: 100");
        if (counter==3)
            System.out.println("Award: 1000");
        if (counter==4)
            System.out.println("Award: 1000000");
    }
}
