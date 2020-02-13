/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midoss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Luis Enrique Trejos Zúñiga 
 * Proyecto Curso Compiladores
 */
public class MIDOSS {
    private static final Scanner leer = new Scanner(System.in);
    private static boolean repetir=true; 
    private static archivo_carpeta Midos= new archivo_carpeta(null, null,"Midos", true, false );
    private static archivo_carpeta directorioActual;
    public static String comandoPrincipal;
    public static ArrayList<String> parametros; 
    public static String rutaActual= "M\\:";
    public static int memoriaActual= 256;
    
    

    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
            directorioActual= Midos;
        
       /* try ( 
       
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("MIDOSTRE.txt"))) {
            Object aux = ois.readObject();
            if (aux == null) {
                directorioActual= Midos;
                
            } else {
                directorioActual= (archivo_carpeta) aux;
                Midos = (archivo_carpeta) aux;
                
            }
        } catch(FileNotFoundException ex) {
            ex.getMessage();
        }*/
        
             String sCadena;
            
            BufferedReader bf = new BufferedReader(new FileReader("MIDOSFRE.txt"));
            while ((sCadena = bf.readLine())!=null) {
              memoriaActual= Integer.parseInt(sCadena);
            }
        
        Midos.setMadre(Midos);
       
            inicio();
             menu();
    }
    public static void menu() throws IOException
    {
        String comando;
        
        do {
            String sCadena;
            
            BufferedReader bf = new BufferedReader(new FileReader("MIDOSFRE.txt"));
            while ((sCadena = bf.readLine())!=null) {
              memoriaActual= Integer.parseInt(sCadena);
            }
            System.out.println(rutaActual);
            comando= leer.nextLine().toUpperCase().trim();
            analizadorSemantico.analizarComando(comando);
           
            
            switch(comandoPrincipal){
                case "":
                    System.out.println("");
                    break;
                case "CLS":
                     if(parametros.isEmpty())
                         metodoCLS();
                    else
                        Errores.mostrarError(4);
                
                    break;
                case "TREE":
                     if(parametros.isEmpty())
                         metodoTREE(Midos);
                    else
                        Errores.mostrarError(4);
                
                    break;
                case "VER":
                    if(parametros.isEmpty())
                         inicio();
                    else
                        Errores.mostrarError(4);
                    break;
                case "DATE":
                    if(parametros.isEmpty())
                         metodoDATE();
                    else
                        Errores.mostrarError(4);
                    break;                  
                case "TIME":
                     if(parametros.isEmpty())
                         metodoTIME();
                    else
                        Errores.mostrarError(4);
                    //metodoTIME();
                    break;
                case "PROMPT":
                    if(parametros.isEmpty())
                     rutaActual ="M:/>";
                    else
                        Errores.mostrarError(4);
                    break;
                case "PROMPT$P$G":
                    if(parametros.isEmpty())
                     rutaActual ="M:/>";
                    else
                        Errores.mostrarError(4);
                    break;
                    
                case "PROMPT$G$P":
                    if(parametros.isEmpty())
                     rutaActual =">M:/";
                    else
                        Errores.mostrarError(4);
                    break;
                case "PROMPT$G":
                     if(parametros.isEmpty())
                     rutaActual =">";
                    else
                        Errores.mostrarError(4);
                    break;
                case "PROMPT$P":
                     if(parametros.isEmpty())
                     rutaActual ="M:/";
                    else
                        Errores.mostrarError(4);
                    break;
                case "EXIT":
                    metodoEXIT();
                    
                    break;
                case "MD":
                    if(parametros.isEmpty())
                     Errores.mostrarError(5);
                    else if(parametros.size() == 1)
                       metodoMD(directorioActual, parametros.get(0));
                    else
                        Errores.mostrarError(6);
                       
                    break;
                case "CD":
                    if(parametros.isEmpty())
                     Errores.mostrarError(26);
                    else if(parametros.size() == 1)
                       metodoCD(directorioActual, parametros.get(0));
                    else
                        Errores.mostrarError(6);
                       
                    break;
                case "CD..":
                   if(parametros.isEmpty())
                    metodoCDmadre(directorioActual);
                    else
                        Errores.mostrarError(4);
                    break;

                    
                case "REN":
                    if(parametros.isEmpty())
                     Errores.mostrarError(24);
                    else if(parametros.size() == 1)
                       metodoREN(directorioActual, parametros.get(0));
                    else
                        Errores.mostrarError(6);
                       
                    break;
                    
                case "COPYCON":
                    
                    if(parametros.isEmpty())
                     Errores.mostrarError(14);
                    else if(parametros.size() == 1)
                       metodoCOPY(directorioActual, parametros.get(0));
                    else
                        Errores.mostrarError(6);
                       
                    break;
                    
                 case "TYPE":
                    
                    if(parametros.isEmpty())
                     Errores.mostrarError(14);
                    else if(parametros.size() == 1)
                       metodoTYPE(directorioActual, parametros.get(0));
                    else
                        Errores.mostrarError(6);
                       
                    break;
                    
                
                case "RD":
                    if(parametros.isEmpty())
                     Errores.mostrarError(9);
                    else if(parametros.size() == 1)
                       metodoRD(directorioActual, parametros.get(0));
                    else
                        Errores.mostrarError(10);
                       
                    break;
                case "DEL":
                    if(parametros.isEmpty())
                     Errores.mostrarError(20);
                    else if(parametros.size() == 1)
                       metodoDEL(directorioActual, parametros.get(0));
                    else
                        Errores.mostrarError(21);
                       
                    break;
                case "DIR":
                    if(parametros.isEmpty())
                    metodoDIR(directorioActual);
                    else
                        Errores.mostrarError(4);
                    break;
                default:
                    Errores.mostrarError(0);
                    break;
            
            }
            
           /* try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("MIDOSTREE.txt"))) {
             
                oos.writeObject(directorioActual);
                oos.close();
            }*/
             String memo= Integer.toString(memoriaActual);

            try (FileWriter escribir = new FileWriter("MIDOSFRE.txt",true)) {
                FileOutputStream writer = new FileOutputStream("MIDOSFRE.txt");
                escribir.write(memo);
            }
           
        } while (repetir);
      
    
    
    }

    private static void metodoDIR(archivo_carpeta imprimir) {
        
        int cantidadArchivos =0; 
        int cantidadCarpetas =0; 
        List<String> nombres = new LinkedList<>();
        
        System.out.println("Directorios en: "+ rutaActual);
        
        
        for (int i = 0; i < imprimir.getCantidad(); i++) {
            
               nombres.add(imprimir.internos[i].getNombre());
               // System.out.println(imprimir.internos[i]);
             
                 if (imprimir.internos[i].archivo) {
                    cantidadArchivos++;

                }else{
                    cantidadCarpetas++;
                } 
            
           
        }
       
      
      Collections.sort(nombres);
        
            for (int i = 0; i < imprimir.getCantidad()&& i<nombres.size(); i++) {
            
               // nombres.add(imprimir.internos[i].getNombre());
                
            imprimir.internos[i].setNombre(nombres.get(i));
            System.out.println(imprimir.internos[i]);
        
                  
                 
            
           
        }
        ;
        
        System.out.println(cantidadArchivos +" " +"Archivos");
        System.out.println(cantidadCarpetas +" "+ "Directorios");
        System.out.println(memoriaActual + " "+"K Libres\n");
        
        
        
    }

    private static void metodoMD(archivo_carpeta directorioActual, String nombre) {
        
        boolean validar[] = new boolean [6];
        validar[0]= true;
        validar[1]= true;
        validar[2]= true;
        validar[3]= true;
        validar[4]= true;
         validar[5]= true;
        
        if (analizadorLexico.comprobarLargo(nombre)== false) {
            Errores.mostrarError(3);
            validar[0]=false;
        }
        if (analizadorLexico.comprobarPrimerLetra(nombre)== false) {
            Errores.mostrarError(1);
            validar[1]=false;
        } 
        if (analizadorLexico.comprobarSimbolos(nombre)== false) {
            Errores.mostrarError(2);
            validar[2]=false;
        }
        if (memoriaActual<8) {
            Errores.mostrarError(7);
            validar[3]=false;
        }
        if (directorioActual.getCantidad()>=8) {
            Errores.mostrarError(8);
            validar[4]=false;
        }
        
        archivo_carpeta dato = directorioActual.get(nombre);
        if (dato != null) {
            validar[5]= false;
            if (dato.isArchivo()) 
                Errores.mostrarError(12);
            else
                Errores.mostrarError(11);
            
        }
        if (validar[0] && validar[1] && validar[2] && validar[3] && validar[4]&& validar[5]  ) {
            archivo_carpeta carpeta = new archivo_carpeta(directorioActual,nombre, nombre, true, false);
            directorioActual.add(carpeta);
            memoriaActual= memoriaActual-8;
            
        }
       
        
        
    }
    
    
    
    private static void metodoRD(archivo_carpeta directorioActual, String nombre) {
        
        boolean validar[] = new boolean [5];
        validar[0]= true;
        validar[1]= true;
        validar[2]= true;
        validar[3]= true;
        validar[4]= true;
        
        if (analizadorLexico.comprobarLargo(nombre)== false) {
            Errores.mostrarError(3);
            validar[0]=false;
        }
        if (analizadorLexico.comprobarPrimerLetra(nombre)== false) {
            Errores.mostrarError(1);
            validar[1]=false;
        } 
        if (analizadorLexico.comprobarSimbolos(nombre)== false) {
            Errores.mostrarError(2);
            validar[2]=false;
        }
      
        
        archivo_carpeta dato = directorioActual.get(nombre);
        if (dato == null) {
            
                validar[3]=false;
                Errores.mostrarError(13);
            
        }
        if (dato != null) {
            if (dato.isCarpeta())
                ;
            else{
                validar[4]=false;
                Errores.mostrarError(12);
            }
            
        }
        
        if (validar[0] && validar[1] && validar[2] && validar[3] && validar[4]  ) {
           
            directorioActual.remove(nombre);
            memoriaActual= memoriaActual+8;
        }
       
        
        
    }

    private static void metodoCOPY(archivo_carpeta directorioActual, String nombre) {
        String contenido;

        boolean validar[] = new boolean [7];
        validar[0]= true;
        validar[1]= true;
        validar[2]= true;
        validar[3]= true;
        validar[4]= true;
         validar[5]= true;
         validar[6]=true;
        
        if (analizadorLexico.comprobarLargo(nombre)== false) {
            Errores.mostrarError(3);
            validar[0]=false;
        }
        if (analizadorLexico.comprobarPrimerLetra(nombre)== false) {
            Errores.mostrarError(1);
            validar[1]=false;
        } 
        if (analizadorLexico.comprobarSimbolos(nombre)== false) {
            Errores.mostrarError(2);
            validar[2]=false;
        }
        if (memoriaActual<4) {
            Errores.mostrarError(7);
            validar[3]=false;
        }
        if (directorioActual.getCantidad()>=8) {
            Errores.mostrarError(8);
            validar[4]=false;
        }
        
        archivo_carpeta dato = directorioActual.get(nombre);
        if (dato != null) {
            validar[5]= false;
            if (dato.isArchivo()) 
                Errores.mostrarError(11);
            else
                Errores.mostrarError(12);
            
        }
        
       
                 
        
        if (validar[0] && validar[1] && validar[2] && validar[3] && validar[4]&& validar[5]  ) {
             contenido= leer.nextLine();
            archivo_carpeta archivo = new archivo_carpeta(directorioActual,contenido, nombre, false, true);
            directorioActual.add(archivo);
            memoriaActual= memoriaActual-4;
        }
    }

    private static void metodoTYPE(archivo_carpeta directorioActual, String nombre) {
     

        boolean validar[] = new boolean [7];
        validar[0]= true;
        validar[1]= true;
        validar[2]= true;
        validar[3]= true;
        validar[4]= true;
         validar[5]= true;
         validar[6]=true;
        
        if (analizadorLexico.comprobarLargo(nombre)== false) {
            Errores.mostrarError(3);
            validar[0]=false;
        }
        if (analizadorLexico.comprobarPrimerLetra(nombre)== false) {
            Errores.mostrarError(1);
            validar[1]=false;
        } 
        if (analizadorLexico.comprobarSimbolos(nombre)== false) {
            Errores.mostrarError(2);
            validar[2]=false;
        }
        
        
        archivo_carpeta dato = directorioActual.get(nombre);
        if (dato != null) {
            if (dato.isArchivo()) 
                validar[3]=true;
            else{
                validar[3]=false;
                Errores.mostrarError(12);
            }
        }
                 
        
        if (validar[0] && validar[1] && validar[2] && validar[3]   ) {
           System.out.println(dato.getContenido());
        }
    }

    private static void metodoDEL(archivo_carpeta directorioActual, String nombre) {
       boolean validar[] = new boolean [5];
        validar[0]= true;
        validar[1]= true;
        validar[2]= true;
        validar[3]= true;
        validar[4]= true;
        
        if (analizadorLexico.comprobarLargo(nombre)== false) {
            Errores.mostrarError(3);
            validar[0]=false;
        }
        if (analizadorLexico.comprobarPrimerLetra(nombre)== false) {
            Errores.mostrarError(1);
            validar[1]=false;
        } 
        if (analizadorLexico.comprobarSimbolos(nombre)== false) {
            Errores.mostrarError(2);
            validar[2]=false;
        }
      
        
        archivo_carpeta dato = directorioActual.get(nombre);
        if (dato == null) {
            
                validar[3]=false;
                Errores.mostrarError(22);
            
        }
        if (dato != null) {
            if (dato.isArchivo())
                ;
            else{
                validar[4]=false;
                Errores.mostrarError(23);
            }
            
        }
        
        if (validar[0] && validar[1] && validar[3] && validar[2] && validar[4]  ) {
           
            directorioActual.remove(nombre);
            memoriaActual= memoriaActual+8;
        }
       
        
    }

    public static void metodoEXIT() throws IOException{
        System.out.println("¿Estas seguro que deseas salir de MIDOS?");
        System.out.print("ingresa SI / NO");
        String opcion = leer.nextLine(); 

        if (opcion.toUpperCase().trim().equals("S")|| opcion.toUpperCase().trim().equals("SI")) {
             String memo= Integer.toString(memoriaActual);

            FileWriter escribir=new FileWriter("MIDOSFRE.txt",true);
            FileOutputStream writer = new FileOutputStream("MIDOSFRE.txt");
            escribir.write(memo);
            escribir.close();

            System.out.println("¡Hasta pronto!");
            System.exit(0);
        }else{
        menu();
        }
   
    
}

    private static void metodoREN(archivo_carpeta directorioActual, String nombre) {
        String nuevoNombre;

        boolean validar[] = new boolean [5];
        validar[0]= true;
        validar[1]= true;
        validar[2]= true;
        validar[3]= true;
        validar[4]=true;
       
        
        if (analizadorLexico.comprobarLargo(nombre)== false) {
            Errores.mostrarError(3);
            validar[0]=false;
        }
        if (analizadorLexico.comprobarPrimerLetra(nombre)== false) {
            Errores.mostrarError(1);
            validar[1]=false;
        } 
        if (analizadorLexico.comprobarSimbolos(nombre)== false) {
            Errores.mostrarError(2);
            validar[2]=false;
        }
      
        
        archivo_carpeta dato = directorioActual.get(nombre);
        if (dato == null) {
            validar[3]= false;
            Errores.mostrarError(25);
        }
         
                 
        
        if (validar[0] && validar[1] && validar[2] && validar[3] ) {
            
            nuevoNombre= leer.nextLine();
         
         
      
         for (int i = 0; i < dato.getCantidad(); i++) {
            
         
             if (!dato.internos[i].getNombre().equals(nuevoNombre)) {
                 validar[4]= false;
             }
            
                
           
        }
         
         if (analizadorLexico.comprobarLargo(nuevoNombre)== false) {
            Errores.mostrarError(3);
            validar[0]=false;
        }
        if (analizadorLexico.comprobarPrimerLetra(nuevoNombre)== false) {
            Errores.mostrarError(1);
            validar[1]=false;
        } 
        if (analizadorLexico.comprobarSimbolos(nuevoNombre)== false) {
            Errores.mostrarError(2);
            validar[2]=false;
        }
            if (validar[4]&& validar[0]&& validar[1]&& validar[2]&& validar[3]) {
                directorioActual.get(nombre).setNombre(nuevoNombre);
            }
             
           
        }
    }

    private static void metodoCD(archivo_carpeta directorio, String nombre) throws IOException {
           boolean validar[] = new boolean [6];
        validar[0]= true;
        validar[1]= true;
        validar[2]= true;
        validar[3]= true;
        validar[4]= true;
         validar[5]= true;
        
       
        
        archivo_carpeta dato = directorio.get(nombre);
        if (dato == null) {
            validar[3]= false;
            Errores.mostrarError(13);
            menu();
        }    
        
        
      
        if (dato.isArchivo()) {
            Errores.mostrarError(27);
            validar[5]=false;
        }else{
             validar[5]=true;
        }
         if (analizadorLexico.comprobarLargo(nombre)== false) {
            Errores.mostrarError(3);
            validar[0]=false;
        }
        if (analizadorLexico.comprobarPrimerLetra(nombre)== false) {
            Errores.mostrarError(1);
            validar[1]=false;
        } 
        if (analizadorLexico.comprobarSimbolos(nombre)== false) {
            Errores.mostrarError(2);
            validar[2]=false;
        }
    
            
        
        if (validar[0] && validar[1] && validar[2] && validar[3] && validar[4] && validar[5]  ) {
            
            directorioActual= dato;
            directorioActual.setMadre(directorio);
        }
            
       
    }

    private static void metodoCDmadre(archivo_carpeta directorio) {
       directorioActual= directorioActual.getMadre();
    }
    
    public static void metodoCLS(){
     for (int i = 0; i < 100; i++) {
         System.out.println();
     }
     
 } 
     public static void inicio() {
        System.out.println("MINGOSOFT ® MIDOS\n" +
    "© Copyright MINGOSOFT CORPORATION 2018\n" +
    "Versión 1.0 Memoria libre:"+ " "+ memoriaActual);
    System.out.println("Autor: Luis Enrique Trejos Zúñiga - 3 457 312\n"); 
    }
     
      public static void metodoDATE(){
     Calendar c = new GregorianCalendar();
    String dia = Integer.toString(c.get(Calendar.DATE));
    String mes = Integer.toString(c.get(Calendar.MONTH)+1);
    String annio = Integer.toString(c.get(Calendar.YEAR));
    System.out.print(dia + "/" + mes + "/"+ annio + "\n" );

 }
      public static void metodoTIME(){
    int hora, minutos, segundos;
    Calendar calendario = new GregorianCalendar();
    hora =calendario.get(Calendar.HOUR_OF_DAY);
    minutos = calendario.get(Calendar.MINUTE);
    segundos = calendario.get(Calendar.SECOND);
    System.out.print(hora + ":"+ minutos + ":" + segundos + "\n");
    }
      public static void metodoTREE(archivo_carpeta imprimir) throws IOException{
      System.out.print(imprimir.getNombre()+"\n");
       for (int i = 0; i < imprimir.getCantidad(); i++) {
            
               if(imprimir.internos[i].getNombre()!=null){
                   System.out.println("\t"+imprimir.internos[i].getNombre());
               }else{
                System.out.println("Fin de archivo");
                menu();
               }
               
             
                 for (int a = 0; a < imprimir.internos[i].getCantidad(); a++) {
            
                if(imprimir.internos[i].internos[a].getNombre()!=null){
                   System.out.println("\t\t"+imprimir.internos[i].internos[a].getNombre()+"\n");

                }else{
                    System.out.println("Fin de archivo");
                    menu();
                }
               
             
                for (int j = 0; j < imprimir.internos[i].internos[a].getCantidad(); a++) {
                     if(imprimir.internos[i].internos[a].getNombre()!=null){
                   System.out.println("\t\t"+imprimir.internos[i].internos[a].internos[j].getNombre());

                }else{
                    System.out.println("Fin de archivo");
                    menu();
                }
                      
              
             
                
            
           
        }
            
           
        }
            
           
        }
      
      }
}
