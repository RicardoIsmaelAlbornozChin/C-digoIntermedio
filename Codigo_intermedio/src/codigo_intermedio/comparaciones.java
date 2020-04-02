package codigo_intermedio;

import java.util.ArrayList;
import java.util.Stack;

public class comparaciones {

    String _postfija; //variable que tiene el postfijo de la entrada, sin espacios.
    ArrayList Temporales = new ArrayList(); //guardara los temporales finales
    Stack pila = new Stack(); //guardara los numeros y operadores

    public comparaciones(String postfija) {
        _postfija = postfija;
    }

    /**
     * Clase que retorno los temporates y que almacene en esa misma clase los
     * temporales en el arraylist i = contador num1 de la pila num2 de la pila
     * operador retorno T0, T1 ALMACENAR = T0 = 4 / 4
     * @return 
     */
    //pilas : https://censorcosmico.blogspot.com/2012/06/pilas-comandos-basicos-push-pop-peek.html
    public ArrayList<String> operaciones() {
        int index = 0;
        for (int i = 0; i < _postfija.length(); i++) {//Recorre a postfija

            char operador = _postfija.charAt(i);
            if (operador == '*' || operador == '/' || operador == '+'
                    || operador == '-' || operador == '(' || operador == ')') { //es todo lo que sea operador
                //llamar la clase de los temporales  223/*
                String numero2 = this.pila.pop().toString(); //T1 EL ULTIMO EN ENTRAR ES EL PRIMERO EN SALIR
                String numero1 = this.pila.pop().toString(); //4
                this.temporales(index, numero1, numero2, operador);
                index++;
            } else { //Es todo que no sea operador
                //apila los numeros
                pila.push(operador); //
            }
        }
       Temporales.add("X = " + pila.pop());
       return Temporales;
    }

    public void temporales(int index, String numero1, String numero2, char ope) {
        if (ope == '*') {
            Temporales.add("T" + index + " = " + numero1 + "*" + numero2); //T1 = T0*7
            pila.push("T" + index); //T1
        }
        if (ope == '/') {
            Temporales.add("T" + index + " = " + numero1 + "/" + numero2); //T0 = 2*2
            pila.push("T" + index); //T0 //T1 //T2
        }
        if (ope == '+') {
            Temporales.add("T" + index + " = " + numero1 + "+" + numero2); //T2 = 4 + T1
            pila.push("T" + index); //T0 //T1 //T2
        }
        if (ope == '-') {
            Temporales.add("T" + index + " = " + numero1 + "-" + numero2); //T0 = 2*2
            pila.push("T" + index); //T0 //T1 //T2
        }
    }

}
