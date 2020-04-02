
package codigo_intermedio;

import java.util.Stack;

/**
 *
 * @author usuario
 */
public class pila {
  
    public pila(String postfix){
        
        char cad[];
        cad = postfix.toCharArray();
        Stack pila = new Stack();
        
        for (int i=0;i<cad.length;i++){
        pila.push(cad[i]);    
        }
        
        comparaciones comp = new comparaciones(pila.peek().toString());
        
        
       
    }
    
    
    
    
    
}
