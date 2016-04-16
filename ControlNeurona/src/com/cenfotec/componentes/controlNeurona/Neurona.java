
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cenfotec.componentes.controlNeurona;
import java.util.Random;

/**
 *
 * @author Diego
 */
public class Neurona {

    double θ = -0.4;
    double y = 0;
    double w1;//valores proximos a 0
    double w2;
    
    public Neurona(){
        
    }
    
    public String AprenderOR(){
         //Tabla de la verdad (X1,X2,Y1)
        String resul = "Hola";
        int[][] tv = {{1, 1, 1}, {1, -1, 1}, {-1, 1, 1}, {-1, -1, -1}};
        w1 = new Random().nextDouble() / 2.5;//valores proximos a 0
        w2 = new Random().nextDouble() / 2.5;
        final double E = 0.6;//Factor de aprendizaje        
        int i = 0;
        int cont = 1;
        while (i < tv.length && cont < 100) {
            y = Math.tanh((tv[i][0] * w1) + (tv[i][1] * w2) + (-1 * θ));
            y = (y >= θ) ? 1 : -1;
            if (y == tv[i][2]) {
                i++;
            } else {
               //Ajuste de pesos
                w1 = w1 + 2 * E * tv[i][2] * tv[i][0];
                w2 = w2 + 2 * E * tv[i][2] * tv[i][1];
                θ = θ + 2 * E * tv[i][2] * (-1);
                cont++;
                i = 0;
            }
        }
        if (cont <= 9999) {
            resul = "Fase de aprendizaje OR ha terminado con exito. Listo para probar!";
        } else {
            resul = "Fase de aprendizaje OR ha fallado ";
        }
        return resul;
    }

    public int TestOR(double x1, double x2){
        y = Math.tanh((x1 * w1) + (x2 * w2) + (-1 * θ));
        y = (y >= θ) ? 1 : -1;
        return (int)y;
    }
    
    public String AprenderAnd(){
          //Tabla de la verdad puerta AND (X1,X2,Y1)
        int[][] tv = {{1, 1, 1}, {1, -1, -1}, {-1, 1, -1}, {-1, -1, -1}};
        String resul;
        w1 = new Random().nextDouble();
        w2 = new Random().nextDouble();
        θ = -0.4;
        y = 0;
        final double E = 0.6;//Factor de aprendizaje  

        int i = 0;
        int cont = 1;
        while (i < tv.length && cont < 10000) {
            y = Math.tanh((tv[i][0] * w1) + (tv[i][1] * w2) + (-1 * θ));
            y = (y >= θ) ? 1 : -1;            
            if (y == tv[i][2]) {
                i++;
            } else {
                //Ajuste de pesos
                w1 = w1 + 2 * E * tv[i][2] * tv[i][0];
                w2 = w2 + 2 * E * tv[i][2] * tv[i][1];
                θ = θ + 2 * E * tv[i][2] * (-1);
                cont++;
                i = 0;
            }
        }

        if (cont <= 9999) {
            resul = "Fase de aprendizaje AND ha terminado con exito. Listo para probar!";

        } else {
           resul = "Fase de aprendizaje AND ha fallado";
        }
        return resul;
    }
    
    public int TestAnd(double x1, double x2){
        y = Math.tanh((x1 * w1) + (x2 * w2) + (-1 * θ));
        y = (y >= θ) ? 1 : -1;
        return (int)y;
    }
 }