/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrimerPuntoB;

import java.util.Scanner;

/**
 * Clase en la que un usuario trata de adivinar un número
 * entre 0 y 100 que ha sido escogido aleatoriamente
 * por la máquina, con la ayuda de algunas indicaciones.
 * @author Pedro Alexander Higuera
 */
public class Guess 
{
    
    /**
     * Función ejecutable. Llama a la función GuessingGame
         * Evalua un nuevo juego por parte del usuario.
     * @param args 
     */
    public static void main(String [] args)
    {
        String playAgain = "y";
        while("y".equals(playAgain))
        {
            GuessingGame();
            System.out.println("Would you like to play"
                    + "another game (y/n)");
            Scanner sn= new Scanner(System.in);
            playAgain= sn.nextLine();
        }
    }
    /**
     *  Función GuessingGame
        Obtiene un número aleatorio.
        Establece el máximo de intentos por adivinar el número en 7.
        Compara cada intento con el número aleatorio.
        Si el número del usuario está por debajo del aleatorio, la máquina avisa
        Así mismo cuando está por encima.
     */
    public static void GuessingGame()
    {
        int answer=(int)Math.floor((Math.random()*100)+1);
        int guess=0;
        int numGuesses=0;
        for (;numGuesses<7&&guess!=answer;numGuesses++)
        {
            System.out.println("Guess a number");
            Scanner sn=new Scanner(System.in);
            guess= sn.nextInt();
            if(guess > answer)
                System.out.println("Higher");
            else if (guess<answer)
                System.out.println("Lower");
            else
                System.out.println("You Win!!");
            
        }
        if (numGuesses>7)
            System.out.println("You loser");
    }
}
