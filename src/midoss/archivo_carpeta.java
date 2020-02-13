/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midoss;

import java.io.Serializable;



/**
 *
 * @author dell
 */
public class archivo_carpeta implements Serializable {
    public String contenido;
    public String nombre;
    public archivo_carpeta internos[]= new archivo_carpeta[8];
    public int cantidad=0; 
    public archivo_carpeta madre;
    public boolean carpeta; 
    public boolean archivo;

    public archivo_carpeta(archivo_carpeta madre, String contenido, String nombre, boolean carpeta, boolean archivo ) {
        this.contenido = contenido;
        this.nombre = nombre;
        this.madre = madre;
        this.carpeta = carpeta;
        this.archivo = archivo;
        
    }


    

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public archivo_carpeta[] getInternos() {
        return internos;
    }

    public void setInternos(archivo_carpeta[] internos) {
        this.internos = internos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public archivo_carpeta getMadre() {
        return madre;
    }

    public void setMadre(archivo_carpeta madre) {
        this.madre = madre;
    }

    public boolean isCarpeta() {
        return carpeta;
    }

    public void setCarpeta(boolean carpeta) {
         if (carpeta){
          this.carpeta = carpeta;
          archivo=false;
        }else{
            this.carpeta = carpeta;
            archivo=true;
        
        }
    }

    public boolean isArchivo() {
        return archivo;
    }

    public void setArchivo(boolean archivo) {
        if (archivo){
          this.archivo = archivo;
          carpeta=false;
        }else{
            this.archivo = archivo;
            carpeta=true;
        
        }
        
    }

    @Override
    public String toString() {
       
        if(isArchivo()){
             return nombre + "<Archivo>";
        }else{
            return nombre + "<Carpeta>";
        }
       
    }

    public void add(archivo_carpeta carpeta) {
        internos[cantidad++]= carpeta;
    }
    public void add2(archivo_carpeta archivo) {
        internos[cantidad++]= archivo;
    }

   public archivo_carpeta get(String nombre) {
        for (int i = 0; i <cantidad; i++) {
            if (nombre.equalsIgnoreCase(internos[i].getNombre())){ 
                return internos[i];
                
            }
        }
        return null;
    }

   public void remove(String nombre) {
       for (int i = 0; i <cantidad; i++) {
            if (nombre.equalsIgnoreCase(internos[i].getNombre())){
                internos[i]= null;
                cantidad --;
            }  
           
        }
       
    }
   
   

  
    
    
}
