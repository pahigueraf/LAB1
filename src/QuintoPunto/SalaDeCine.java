/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuintoPunto;

import java.util.Scanner;

/**
 * Clase que maneja ciertas características de una sala de cine.
 * Enntre ellas están: reservar asientos, comprar boletas directamente,
 * asignar sillas específicas a cada usuario, entre otras.
 * @author Pedro Alexander Higuera
 */
public class SalaDeCine 
{
    public static void main(String []args)
    {
        int [][]usuarios= new int[50][2];
        int [][]sillas = new int [11][20];
        int reservasP=0;
        int reservasG=0;
        int sinReservaP=0;
        int sinReservaG=0;
        double cntReservasP=0;
        double cntReservasG=0;
        double cntSinReservaP=0;
        double cntSinReservaG=0;
        int cancelacionesP=0;
        int cancelacionesG=0;
        int counter=0;
  
        tarjeta(usuarios, sillas, reservasP, reservasG, sinReservaP, sinReservaG, 
                counter, cntReservasP, cntReservasG, cntSinReservaP, cntSinReservaG, cancelacionesP,
                cancelacionesG);
    } 
    /**
     * Método que permite a los usuarios comprar la tarjeta Tarcine y recargarla.
     * Hay que mencionar que si no se tiene registro de una compra de tarjeta
     * por el usuario, no va a poder recargar.
     * Igualmente, da acceso al siguiente menú.
     * @param usuarios
     * @param sillas
     * @param reservasP
     * @param reservasG
     * @param sinReservaP
     * @param sinReservaG
     * @param counter
     * @param cntReservasP
     * @param cntReservasG
     * @param cntSinReservaP
     * @param cntSinReservaG 
     * @param cancelacionesP 
     * @param cancelacionesG 
     */
    public static void tarjeta(int[][]usuarios, int [][]sillas, int reservasP, int reservasG, 
            int sinReservaP, int sinReservaG, int counter, double cntReservasP, double cntReservasG,
            double cntSinReservaP, double cntSinReservaG, int cancelacionesP, int cancelacionesG)
    {
        Scanner sn = new Scanner(System.in);
        boolean acabaCiclo = false;
        
        
        while(acabaCiclo==false)
        {
            System.out.println("ingrese 1 para vender Tarcine, 2 para recargar Tarcine, 3 para ver saldo de las tarjetas registradas, 4 para pasar al siguiente menu");
            int accion = sn.nextInt();
            switch (accion) {
                case 1:
                    System.out.println("Ingrese su id");
                    for(int i=counter;i<50;i++)
                    {
                        if(usuarios[i][0]==0)
                        {
                            usuarios[i][0]=sn.nextInt();
                            usuarios[i][1]=0;
                            counter++;
                            break;
                        }
                       
                    }
                    System.out.println("Hecho!");
                    break;
                case 2:
                    System.out.println("Ingrese su id");
                    int h = sn.nextInt();
                    for (int j=0;j<50;j++)
                    {
                        
                        if (usuarios[j][0]==h)
                        {
                            System.out.println("Recarga de $50000 hecha");
                            usuarios[j][1]+=50000;
                            break;
                        }
                    }
                    break;
                case 3:
                    for(int x=0;x<50;x++)
                    {
                        for (int y=0;y<2;y++)
                        {
                            if(usuarios[x][0]!=0)
                                System.out.print(usuarios[x][y]+"\t\t");
                        }
                            
                        System.out.println(" ");
                    }
                    break;
                default:
                    acabaCiclo=true;
                    break;
            }
        }
        tarcine(usuarios, sillas, reservasP, reservasG, sinReservaP, sinReservaG, 
                counter, cntReservasP, cntReservasG, sinReservaP, sinReservaG, cancelacionesP,
                cancelacionesG);
    }
    /**
     * Método que permite reservar y cancelar boletas, comprar y observar la disponibilidad de la sala.
     * Las sillas se asignan en orden. Si el usuario hace reserva y tiene intención de cancelarla,
     * pero quiere comprar boletas de todas maneras, entonces tendrá que cancelar la reserva primero y 
     * después de eso, si podrá comprar las boletas.
     * @param usuarios
     * @param sillas
     * @param reservasP
     * @param reservasG
     * @param sinReservaP
     * @param sinReservaG
     * @param counter
     * @param cntReservasP
     * @param cntReservasG
     * @param cntSinReservaP
     * @param cntSinReservaG 
     * @param cancelacionesP 
     * @param cancelacionesG 
     */
    public static void tarcine(int usuarios[][], int sillas[][], int reservasP, int reservasG, 
            int sinReservaP, int sinReservaG, int counter, double cntReservasP, double cntReservasG, 
            double cntSinReservaP, double cntSinReservaG, int cancelacionesP , int cancelacionesG)
    {
        Scanner sn = new Scanner(System.in);
        boolean acabaCiclo1=false;
        while(acabaCiclo1==false)
        {
            System.out.println("Ingrese 1 para reservar, 2 para comprar boletas, 3 para cancelar reserva, 4 para volver al menú anterior, "
                    + "5 para ver la disponibilidad de la sala, 6 para ver los ingresos totales, 7 para salir");
            int eleccion = sn.nextInt();
            switch (eleccion) {
                case 1:
                    {
                        System.out.println("Cuantas boletas desea reservar?");
                        int numReservas = sn.nextInt();
                        System.out.println("1.preferencial o 2.general?");
                        int pog = sn.nextInt();
                        System.out.println("Forma de pago: 1.Tarcine 2.Efectivo");
                        if (sn.nextInt()==1)
                        {    
                            System.out.println("Ingrese su id");
                            int id=sn.nextInt();
                            if (pog ==1)
                            {
                                for(int j=reservasP+sinReservaP;j<numReservas+reservasP+sinReservaP;j++)
                                {

                                    if(sillas[8][j]==0)
                                    {
                                        sillas [8][j]=id;

                                        for (int a=0;a<50;a++)
                                        {
                                            if(id==usuarios[a][0]&&usuarios[a][1]>=0.9*11000)
                                            {
                                                usuarios[a][1]-=0.9*11000;
                                                cntReservasP+=0.9;
                                            }
                                                
                                        }
                                    }
                                    else if (sillas[9][j]==0)
                                    {
                                        sillas[9][j]=id;

                                        for (int a=0;a<50;a++)
                                        {
                                            if(id==usuarios[a][0]&&usuarios[a][1]>=0.9*11000)
                                            {
                                                usuarios[a][1]-=0.9*11000;
                                                cntReservasP+=0.9;
                                            }
                                                
                                        }
                                    }
                                    else if (sillas[10][j]==0)
                                    {
                                        sillas[10][j]=id;

                                        for (int a=0;a<50;a++)
                                        {
                                            if(id==usuarios[a][0]&&usuarios[a][1]>=0.9*11000)
                                            {
                                                usuarios[a][1]-=0.9*11000;
                                                cntReservasP+=0.9;
                                            }

                                        }
                                    }
                                    if(j==19)
                                        break;

                                }
                                reservasP+=numReservas;
                                
                            }
                            else
                            {
                                int k=0;
                                for(int j=reservasG+sinReservaG;j<numReservas+reservasG+sinReservaG;j++)
                                {
                                    if(sillas[k][j]==0)
                                    {
                                        sillas[k][j]=id;

                                        for (int a=0;a<50;a++)
                                        {
                                            if(id==usuarios[a][0])
                                            {
                                                if(usuarios[a][1]>=0.9*8000)
                                                {
                                                    usuarios[a][1]-=0.9*8000;
                                                    cntReservasG+=0.9;
                                                }
                                                break;

                                            }   

                                        }
                                    }
                                    else
                                        k++;
                                    if(j==19)
                                        break;
                                }
                                reservasG+=numReservas;
                                
                            }       
                        }
                        else
                        {
                            System.out.println("Ingrese su id");
                            int id=sn.nextInt();
                            if(pog==1)
                            {
                                for(int j=reservasP+sinReservaP;j<numReservas+reservasP+sinReservaP;j++)
                                {

                                    if(sillas[8][j]==0)
                                    {
                                        sillas [8][j]=id;
                                        cntReservasP++;
                                    }
                                    else if (sillas[9][j]==0)
                                    {
                                        sillas[9][j]=id;
                                        cntReservasP++;
                                    }
                                    else if (sillas[10][j]==0)
                                    {
                                        sillas[10][j]=id;
                                        cntReservasP++;
                                    }
                                    if(j==19)
                                        break;

                                }
                                reservasP+=numReservas;
                                
                            }
                            else
                            {
                                int k=0;
                                for(int j=reservasG+sinReservaG;j<numReservas+reservasG+sinReservaG;j++)
                                {
                                    if(sillas[k][j]==0)
                                    {
                                        sillas[k][j]=id;
                                        cntReservasG++;
                                    }
                                        
                                    else
                                        k++;
                                    if(j==19)
                                        break;
                                }
                                reservasG+=numReservas;
                                
                            }
                            
                        }break;
                    }
                case 2:
                    {
                        System.out.println("Cuantas boletas desea comprar?");
                        int numCompras = sn.nextInt();
                        System.out.println("1.preferencial o 2.general?");
                        int pog = sn.nextInt();
                        System.out.println("Forma de pago: 1.Tarcine 2.Efectivo");
                        if (sn.nextInt()==1)
                        {
                            System.out.println("Ingrese su id");
                            int id=sn.nextInt();
                            if (pog==1)
                            {                                                                                             
                                for(int j=sinReservaP+reservasP;j<numCompras+sinReservaP+reservasP;j++)
                                {
                                    if(sillas[8][j]==0)
                                    {
                                        sillas [8][j]=id;

                                        for (int a=0;a<50;a++)
                                        {
                                            if(id==usuarios[a][0]&&usuarios[a][1]>=0.9*11000)
                                            {
                                                usuarios[a][1]-=0.9*11000;
                                                cntSinReservaP+=0.9;                                                        
                                            }                                                
                                        }
                                    }
                                    else if (sillas[9][j]==0)
                                    {
                                        sillas[9][j]=id;

                                        for (int a=0;a<50;a++)
                                        {
                                            if(id==usuarios[a][0]&&usuarios[a][1]>=0.9*11000)
                                            {
                                                usuarios[a][1]-=0.9*11000;
                                                cntSinReservaP+=0.9; 
                                            }  
                                        }
                                    }
                                    else if (sillas[10][j]==0)
                                    {
                                        sillas[10][j]=id;

                                        for (int a=0;a<50;a++)
                                        {
                                            if(id==usuarios[a][0]&&usuarios[a][1]>=0.9*11000)
                                            {
                                                usuarios[a][1]-=0.9*11000;
                                                cntSinReservaP+=0.9; 
                                            }                                               
                                        }
                                    }
                                    if(j==19)
                                        break;

                                }                                                                    
                                sinReservaP+=numCompras;
                               
                            }
                            else
                            {
                                int k=0;
                                for(int j=sinReservaG+reservasG;j<numCompras+sinReservaG+reservasG;j++)
                                {
                                    if(sillas[k][j]==0)
                                    {
                                        sillas[k][j]=id;

                                        for (int a=0;a<50;a++)
                                        {
                                            if(id==usuarios[a][0])
                                            {
                                                if(usuarios[a][1]>=0.9*8000)
                                                {
                                                    usuarios[a][1]-=0.9*8000;
                                                    cntSinReservaG++;
                                                }
                                                break;

                                            }                                                                                            

                                        }
                                    }
                                    else
                                        k++;
                                    if(j==19)
                                        break;
                                }
                                sinReservaG+=numCompras;
                               
                                
                            }
                        }
                        else
                        {
                            System.out.println("Ingrese su id");
                            int id=sn.nextInt();
                            if (pog==1)
                            {
                                for(int j=sinReservaP+reservasP;j<numCompras+sinReservaP+reservasP;j++)
                                {
                                    if(sillas[8][j]==0)
                                    {
                                        sillas [8][j]=id;
                                        cntSinReservaP++;
                                    }
                                        
                                    else if (sillas[9][j]==0)
                                    {
                                        sillas[9][j]=id;
                                        cntSinReservaP++;
                                    }
                                        
                                    else if (sillas[10][j]==0)
                                    {
                                        sillas[10][j]=id;
                                        cntSinReservaP++;
                                    }
                                        
                                    if(j==19)
                                        break;

                                }  
                                sinReservaP+=numCompras;
                               
                            }
                            else
                            {
                                int k=0;
                                for(int j=sinReservaG+reservasG;j<numCompras+sinReservaG+reservasG;j++)
                                {
                                    if(sillas[k][j]==0)
                                    {
                                        sillas[k][j]=id;
                                        cntSinReservaG++;
                                    }
                                        
                                    else
                                        k++;
                                    if(j==19)
                                        break;
                                }
                                sinReservaG+=numCompras;
                                
                            }
                        }break;
                            
                    }
                case 3:
                    {
                        System.out.println("Ingrese su id");
                        int id=sn.nextInt();
                        for(int x=0;x<11;x++)
                        {
                            for(int y=0;y<20;y++)
                            {
                                if(sillas[x][y]==id&&x<8)
                                {
                                    sillas[x][y]=0;
                                    for(int z=0;z<50;z++)
                                    {
                                        if (usuarios[z][0]==id)
                                        {
                                            usuarios[z][1]+=8000;
                                            cancelacionesG++;
                                        }
                                            
                                    }
                                }
                                else if(sillas[x][y]==id&&x>=8)
                                {
                                    sillas[x][y]=0;
                                    for(int z=0;z<50;z++)
                                    {
                                        if (usuarios[z][0]==id)
                                        {
                                            usuarios[z][1]+=11000;
                                            cancelacionesP++;
                                        }
                                            
                                    }
                                }
                            }
                        }       break;
                    }
                case 4:                    
                        tarjeta(usuarios, sillas, reservasP, reservasG, sinReservaP, sinReservaG, 
                                counter, cntReservasP, cntReservasG, cntSinReservaP,cntSinReservaG, 
                                cancelacionesP, cancelacionesG);
                        break;
                case 5:
                    imprimeSala(sillas);
                    break;
                case 6:
                    calculaIngresos(cntReservasP,cntReservasG,cntSinReservaP,cntSinReservaG, cancelacionesP,
                            cancelacionesG);
                    break;
                default:
                    acabaCiclo1=true;
                    break;
            }
                
        }
        
    }
    /**
     * Método que calcula los ingresos que recibió la sala de cine.
     * 
     * @param a
     * @param b
     * @param c
     * @param d
     * @param e
     * @param f 
     */
    public static void calculaIngresos(double a, double b, double c, double d, int e, int f)
    {
        double ingresosPorReservasP = a*11000;
        double ingresosPorReservasG = b*8000;
        double ingresosPorBoletasP=c*11000;
        double ingresosPorBoletasG=d*8000;
        int cancelacionesP = e*11000;
        int cancelacionesG = f*11000;
        double total = ingresosPorReservasP+ingresosPorReservasG+ingresosPorBoletasP+ingresosPorBoletasG-cancelacionesP-cancelacionesG;
        System.out.println("Total ingresos: "+total);
        
    }
    /**
     * Método que imprime la sala, en donde se especifican los ids de los usuarios quienes hayan apartado
     * o comprado boletas. Los espacios vacíos se representan con un cero.
     * @param sillas 
     */
    public static void imprimeSala(int sillas[][])
    {
        for(int i=0; i<11;i++)
        {
            for (int j=0; j<20;j++)
            {
                System.out.print(sillas[i][j]+"\t\t\t\t");
            }
            System.out.println(" ");
        }
    }
    
}
