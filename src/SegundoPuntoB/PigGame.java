/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SegundoPuntoB;

import java.util.Scanner;

/**
 *  Clase que representa la lógica del juego Pig
 * @author Pedro Alexander Higuera
 */
public class PigGame 
{
    public static void main (String []args)
    {
        pigGame();
    }
    /**
     * pigGame
     * Competencia entre el usuario y la máquina. El primero en acertar 100 pts gana.
     * Se lanzan dos dados. Si no cae un uno en alguno de los dados, el jugador puede elegir
     * entre lanzar otra vez o sumar el valor de los dados a su acumulado total.
     * Si continua y sale un 1 en cualquiera de los dados, la suma del turno es 0.
     * Si salen un par de unos los puntos totales se vuelven 0.
     */
    public static void pigGame()
    {
        
        int totalPointsPlayer = 0;
        int totalPointsComputer = 0;
        int turnPointsPlayer=0;
        int turnPointsComputer=0;
        while (totalPointsPlayer<100 && totalPointsComputer<100)
        {
            if (totalPointsPlayer>=100 || totalPointsComputer>=100)
            {
                System.out.print("\tHa ganado!!");
                break;
            }
                    
            System.out.println("Turno del jugador!!");
            int playerFirstDice = valuesDice();
            int playerSecondDice = valuesDice();
            boolean turnPlayer = true;
            System.out.println("\tPrimer dado: "+playerFirstDice+" Segundo dado: "+playerSecondDice);
            for (;playerFirstDice!=1 && playerSecondDice!=1 && turnPlayer == true;)
            {                
                
                Scanner sn = new Scanner(System.in);
                turnPointsPlayer+= playerFirstDice+playerSecondDice;
                System.out.println("\t1-Continue or 2-Pass?");
                int decision = sn.nextInt();
                if (decision==2)
                {
                    System.out.println("\tAcabó su turno. Sus puntos en este turno"
                            + " son "+turnPointsPlayer);
                    turnPlayer = false;
                    totalPointsPlayer +=turnPointsPlayer;
                    System.out.println("\tAcabó su turno. Sus puntos en totales"
                            + " son "+totalPointsPlayer);
                    turnPointsPlayer = 0;
                    
                }
                    
                else
                {
                    playerFirstDice = valuesDice();
                    playerSecondDice = valuesDice();
                    System.out.println("\tPrimer dado: "+playerFirstDice+" Segundo dado: "+playerSecondDice);
                   
                }                
            }
            if (playerFirstDice==1 && playerSecondDice==1 )
            {
                System.out.println("\tSus puntos totales son: 0");
                totalPointsPlayer=0;
            }
            else if (playerFirstDice==1 || playerSecondDice==1 )
            {
                System.out.println("\tSus puntos en este turno son: 0");
                turnPointsPlayer=0;
                System.out.println("\tSus puntos totales son "+totalPointsPlayer);
            }
            if (totalPointsPlayer>=100 || totalPointsComputer>=100)
            {
                System.out.print("\tHa ganado!!");
                break;
            }
                    
            System.out.println("Turno de la máquina!!");
            int computerFirstDice = valuesDice();
            int computerSecondDice = valuesDice();
            System.out.println("\tPrimer dado: "+computerFirstDice+" Segundo dado: "+computerSecondDice);
            boolean turnComputer = true;
            for (;computerFirstDice!=1 && computerSecondDice!=1 && turnComputer == true;)
            {                
                
                turnPointsComputer+= computerFirstDice+computerSecondDice;
                System.out.println("\t1-Continue or 2-Pass?");
                int decision = chooseComputer();
                if (decision==2)
                {
                    System.out.println("\tAcabó su turno. Sus puntos en este turno"
                            + " son "+turnPointsComputer);
                    turnComputer = false;
                    totalPointsComputer +=turnPointsComputer;
                    System.out.println("\tAcabó su turno. Sus puntos en totales"
                            + " son "+totalPointsComputer);
                    turnPointsComputer = 0;
                }
                    
                else
                {
                    computerFirstDice = valuesDice();
                    computerSecondDice = valuesDice();
                    System.out.println("\tPrimer dado: "+computerFirstDice+" Segundo dado: "+computerSecondDice);
                    
                }                
            }
            
            if (computerFirstDice==1 && computerSecondDice==1 )
            {
                System.out.println("\tSus puntos totales son: 0");
                totalPointsComputer=0;
            }
            else if (computerFirstDice==1 || computerSecondDice==1 )
            {
                System.out.println("\tSus puntos en este turno son: 0");
                turnPointsComputer=0;
                System.out.println("\tSus puntos totales son "+totalPointsComputer);
            }
            
        }
        
    }
    /**
     * valuesDice
     * Retorna el valor de un dado
     * @return 
     */
    public static int valuesDice()
    {
        int valueDice=(int)Math.floor((Math.random()*6)+1);
        return valueDice;
    }
    /**
     * chooseComputer
     * retorna la elección del computador entre: Continuar o pasar turno
     * @return 
     */
    public static int chooseComputer()
    {
        int choose=(int)Math.floor((Math.random()*2)+1);
        return choose;
    }
}
