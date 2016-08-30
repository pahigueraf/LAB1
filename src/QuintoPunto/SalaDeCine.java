/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuintoPunto;

import java.util.Scanner;

/**
 *
 * @author pahf33
 */
public class SalaDeCine 
{
    public static void main(String []args)
    {
        sala();
    }
    public static void sala()
    {
        int[][]sillas= new int[11][20];
        //for(int i=0;i<11;i++)
        //{
        //    for(int j=0;i<20;i++)
        //        sillas[i][j]=0;
        //}
        tarcine(sillas);
                
        
    }
    public static void tarcine(int sillas[][])
    {
        Scanner sn = new Scanner(System.in);
        boolean acabaCiclo = false;
        int [][]usuarios= new int[50][2];
        int i=0;
        while(acabaCiclo==false)
        {
            System.out.println("ingrese 1 para vender Tarcine, 2 para recargar Tarcine, 3 para salir");
            int accion = sn.nextInt();
            switch (accion) {
                case 1:
                    System.out.println("Ingrese su id");
                    usuarios[i][0]=sn.nextInt();
                    usuarios[i][1]=0;
                    i++;
                    break;
                case 2:
                    System.out.println("Ingrese su id");
                    int h = sn.nextInt();
                    for (int j=0;j<i;j++)
                    {
                        
                        if (usuarios[j][0]==h)
                        {
                            System.out.println("Cuanto va a recargar?");
                            usuarios[j][1]+=sn.nextInt();
                        }
                    }   break;
                default:
                    acabaCiclo=true;
                    break;
            }
        }
        int reservasP=0;
        int reservasG=0;
        int sinReservaP=0;
        int sinReservaG=0;
        boolean acabaCiclo1=false;
        while(acabaCiclo1==false)
        {
            System.out.println("Ingrese 1 para reservar, 2 para comprar boletas, 3 para cancelar reserva, 4 para salir");
            int eleccion = sn.nextInt();
            if (eleccion==1)
            {
                System.out.println("Cuantas boletas desea reservar?");
                int numReservas = sn.nextInt();
                System.out.println("1.preferencial o 2.general?");
                int pog = sn.nextInt();
                System.out.println("Ingrese su id");
                int id=sn.nextInt();
                if (pog ==1)
                {
                    for(int j=0;j<numReservas;j++)
                    {
                        if(sillas[8][j+reservasG]==0)
                        {
                            sillas [8][j+reservasG]=id;
                            reservasG+=numReservas;
                            for (int a=0;a<50;a++)
                            {
                                if(id==usuarios[a][0]&&usuarios[a][1]>=11000)
                                    usuarios[a][1]-=numReservas*11000;
                            }
                        }
                        else if (sillas[9][j+reservasG]==0)
                        {
                            sillas[9][j+reservasG]=id;
                            reservasG+=numReservas;
                            for (int a=0;a<50;a++)
                            {
                                if(id==usuarios[a][0]&&usuarios[a][1]>=11000)
                                    usuarios[a][1]-=numReservas*11000;
                            }
                        }
                        else if (sillas[10][j+reservasG]==0)
                        {
                            sillas[10][j+reservasG]=id;
                            reservasG+=numReservas;
                            for (int a=0;a<50;a++)
                            {
                                if(id==usuarios[a][0]&&usuarios[a][1]>=11000)
                                    usuarios[a][1]-=numReservas*11000;
                                else
                                    System.out.println("Saldo insuficiente");
                            }
                        }

                    }
                }
                else 
                {
                    int k=0;
                    for(int j=0;j<numReservas;j++)
                    {
                        if(sillas[k][j+reservasP]==0)
                        {
                            sillas[k][j+reservasP]=id;
                            reservasP+=numReservas;
                            for (int a=0;a<50;a++)
                            {
                                if(id==usuarios[a][0]&&usuarios[a][1]>=8000)
                                    usuarios[a][1]-=numReservas*8000;
                                else
                                    System.out.println("Saldo insuficiente");
                            }
                        }
                        else
                            k++;
                    }
                }
            } 
            else if (eleccion==2)
            {
                System.out.println("Cuantas boletas desea comprar?");
                int numCompras = sn.nextInt();
                System.out.println("1.preferencial o 2.general?");
                int pog = sn.nextInt();
                System.out.println("Ingrese su id");
                int id=sn.nextInt();
                if (pog==1)
                {
                    int j=0;
                    for (int a=0;a<50;a++)
                    {
                        if(id==usuarios[a][0]&&usuarios[a][1]>=numCompras*11000)
                            usuarios[a][1]-=numCompras*11000;
                        sinReservaP+=numCompras;
                        
                        if((sillas[8+j][a])==0)
                            sillas[j][a]=id;
                        else
                        {
                            j++;
                            System.out.println("saldo insuficiente");
                        }
                            
                    }
                }
                else
                {
                    int j=0;
                    for (int a=0;a<50;a++)
                    {
                        if(id==usuarios[a][0]&&usuarios[a][1]>=numCompras*8000)
                            usuarios[a][1]-=numCompras*8000;
                        sinReservaG+=numCompras;
                        if((sillas[j][a])==0)
                            sillas[j][a]=id;
                        else
                        {
                            j++;
                            System.out.println("saldo insuficiente");
                        }
                            
                    }
                }
                
            }
            else if(eleccion==3)
            {
                System.out.println("Ingrese su id");
                int id=sn.nextInt();
                for(int x=0;i<11;i++)
                {
                    for(int y=0;y<20;y++)
                    {
                        if(sillas[x][y]==id&&x<8)
                        {
                            sillas[x][y]=0;
                            for(int z=0;z<50;z++)
                            {
                                if (usuarios[z][0]==id)
                                    usuarios[z][1]+=8000;
                            }
                        }
                        else if(sillas[x][y]==id&&x>8)
                        {
                            sillas[x][y]=0;
                            for(int z=0;z<50;z++)
                            {
                                if (usuarios[z][0]==id)
                                    usuarios[z][1]+=11000;
                            }
                        }
                    }
                }
            }
            else
                acabaCiclo1=true;
                
        }
        
    }
    
}
