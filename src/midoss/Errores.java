/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midoss;

/**
 *
 * @author dell
 */
public class Errores {
    
    public static void mostrarError(int valor){
        String [] listaError={
            "00 -> El comando ingresdo no es válido",
            "01 -> El primer caracter no es una letra",
            "02 -> El nombre ingresado contiene simbolos",
            "03 -> El nombre ingresado tiene más de 8 digitos",
            "04 -> Este comando no necesita parametros",
            "05 -> Debe ingresar un nombre para la carpeta",
            "06 -> Este comando solo requiere un parametro",
            "07-> No se puede crear la carpeta por falta de memoria",
            "08 -> Se ha llegado al limite de 8 directorios", 
            "09 -> Debe ingresar el nombre de carpeta a eliminar",
            "10 -> Rd solo necesita un parametro",
            "11 -> Existe una carpeta con el mismo nombre",
            "12 -> Existe un archivo con ese nombre",
            "13 -> La carpeta seleccionada no existe",
            "14 -> Debe ingresar un nombre para el archivo",
           "15-> No se puede crear el archivo por falta de memoria",
           "16-> El contenido debe terminar en ^z",
           "17-> Debe ingresar el nombre de archivo para mostar su contenido",
           "18-> Selecciono el nombre de un directorio",
           "19 El archivo seleccionado no existe",
           "20 -> Debe ingresar el nombre de archivo a eliminar",
           "21 -> DEL solo necesita un parametro",
           "22 -> El archivo seleccionado no existe",
           "23 -> Existe una carpeta con ese nombre",
           "24-> Debe ingresar el nombre de la carpete o archivo",
           "25 -> El archivo o carpeta no existe",
           "26 -> Debe ingresar el nombre del directorio", 
           "27-> El nombre seleccionado corresponde a un archivo"
        
        };
        System.err.println("\t Error: "+ listaError[valor]);
    }
    
}
