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
public class analizadorLexico {
    public static boolean comprobarPrimerLetra(String nombre){
        if (!Character.isLetter(nombre.charAt(0))) {
            return false;
        }
            return true;
    
    }
    public static boolean comprobarSimbolos(String nombre){
       
        for (int i = 1; i < nombre.length(); i++) {
            if (Character.isLetter(nombre.charAt(i)) || Character.isDigit(nombre.charAt(i))) {
                
            }else{
                return false;
            }
            
        }
        
        return true;
    
    }
    
    public static boolean comprobarLargo(String nombre){
        if (nombre.length()>8) 
            return false;
        else
            return true;
    
    }
    
}
