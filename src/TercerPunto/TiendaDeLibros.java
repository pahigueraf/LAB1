/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TercerPunto;

import java.util.Scanner;
/**
 *  Clase que maneja un catalogo de libros de una tienda.
 * @author Pedro Alexander Higuera
 */
public class TiendaDeLibros 
{
    public static void main(String []args)
    {
        catalogo();
    }
    /**
     * catalogo
     * llena la base de datos de la tienda
     * establece un menú para adicionar, ver catálogo, comprar o salir del programa
     * 
     */
    public static void catalogo()
    {
        Scanner sn= new Scanner(System.in);
        int tamArray=20;
        int [] isbn = new int[tamArray];
        String [] titulo = new String[tamArray];
        int [] precio = new int[tamArray];
        boolean acabaCiclo = false;
        int i=0;
        while(acabaCiclo==false)
        {
            System.out.println("Ingrese código ISBN");
            isbn[i] = sn.nextInt();
            System.out.println("Ingrese título libro");
            titulo[i] = sn.next();
            System.out.println("Ingrese precio");
            precio[i] = sn.nextInt();
            i++;
            System.out.println("Quiere ingresar más libros?y/n");
            String decision = sn.next();
            if ("n".equals(decision))
                acabaCiclo=true;
        }
        boolean acabaCiclo2=false;
        while(acabaCiclo2==false)
        {
            System.out.println("Ingrese \t1.Adicionar libros\t2.Ver Catálogo"
                + "\t3.Comprar\t4.Salir");
            int accion = sn.nextInt();
            switch (accion) {
                case 1:
                {                    
                    boolean acabaCiclo3 = false;
                    while(acabaCiclo3==false)
                    {
                        System.out.println("Ingrese código ISBN");
                        isbn[i] = sn.nextInt();
                        System.out.println("Ingrese título libro");
                        titulo[i] = sn.next();
                        System.out.println("Ingrese precio");
                        precio[i] = sn.nextInt();
                        i++;
                        System.out.println("Quiere adicionar más libros?y/n");
                        String decision = sn.next();
                        if ("n".equals(decision))
                            acabaCiclo3=true;
                    }
                }
                    break;
                case 2:
                    verCatalogo(isbn,titulo,precio,i);
                    break;
                case 3:
                    comprar(isbn,titulo,precio,i);
                    break;
                default:
                    acabaCiclo2=true;
                    break;
            }
        }                        
    }
    /**
     * verCatalogo
     * muestra al usuario el catalogo de la tienda
     * @param isbn
     * @param titulo
     * @param precio
     * @param i 
     */
    public static void verCatalogo(int[]isbn, String[]titulo,int[]precio,int i)
    {
        System.out.println("ISBN\t\ttitulo\t\t\tprecio");
        for (int j=0;j<i;j++)        
            System.out.println(isbn[j]+"\t\t"+titulo[j]+"\t\t\t"+precio[j]);                                        
    }
    /**
     * comprar
     * Permite observar el carrito de compras del usuario
     * @param isbn
     * @param titulo
     * @param precio
     * @param i 
     */
    public static void comprar(int[]isbn, String[]titulo,int[]precio,int i)
    {
        Scanner sn = new Scanner(System.in);
        int k=0;
        int isbnCar[]=new int[i];
        String tituloCar[]=new String[i];
        int precioCar[]=new int[i];
        int cantidad[]=new int[i];
        boolean acabaCiclo=false;
        while(acabaCiclo==false)
        {
            System.out.println("Ingrese ISBN del libro");
            int nuevaCompra=sn.nextInt();
            
            for (int j=0;j<i;j++)
            {           
                if(isbn[j]==nuevaCompra)
                {
                    System.out.println("Cuantos desea comprar?");
                    int ctd= sn.nextInt();
                    isbnCar[k]=isbn[j];
                    tituloCar[k]=titulo[j];
                    precioCar[k]=precio[j];
                    cantidad[k]=ctd;
                    k++;
                }
            }
            mostrarCarrito(isbnCar,tituloCar,precioCar, cantidad, k);
            boolean acabaCiclo4=false;
            while(acabaCiclo4==false)
            {
                System.out.println("Quiere quitar algún libro del carrito?y/n");
                String decision = sn.next();
                if ("n".equals(decision))             
                    acabaCiclo4=true;
                else
                {
                    System.out.println("Ingrese ISBN del libro");
                    int quitaCompra=sn.nextInt();
            
                    for (int j=0;j<i;j++)
                    {           
                        if(isbnCar[j]==quitaCompra)                        
                            isbnCar[j]=0;                        
                    }
                    mostrarCarrito(isbnCar,tituloCar,precioCar, cantidad, k);
                }
            }
            
            System.out.println("Quiere comprar más libros?y/n");
            String decision2 = sn.next();
            if ("n".equals(decision2))
                acabaCiclo=true;
        }
        
    }
    /**
     * mostrarCarrito
     * Muestra el estado actual del carrito de compras
     * @param isbn
     * @param titulo
     * @param precio
     * @param cantidad
     * @param i 
     */
    public static void mostrarCarrito(int[]isbn, String[]titulo,int[]precio,int[]cantidad,int i)
    {
        System.out.println("ISBN\t\ttitulo\t\tcantidad\t\t\tsubtotal");
        int total=0;
        for (int j=0;j<i;j++)
        {
            if(isbn[j]!=0)
            {
                int subtotal=cantidad[j]*precio[j];
                System.out.println(isbn[j]+"\t\t"+titulo[j]+"\t\t\t"+cantidad[j]+"\t\t"+subtotal); 
                total+=subtotal;
                System.out.println("Total compra: "+total);
            }
            
            
        }        
            
    }
}
