/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midoss;

import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class analizadorSemantico {

   public static void analizarComando(String comando) {
       MIDOSS.comandoPrincipal= "";
       MIDOSS.parametros = new ArrayList<String>();
        String tokens[] = comando.trim().split(" ");
        
        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].trim().equals("")) {
                if (i==0) {
                     MIDOSS.comandoPrincipal=tokens[i].trim();
                }else{
                     MIDOSS.parametros.add(tokens[i].trim());
                }
            }
        }
    }
    
}
