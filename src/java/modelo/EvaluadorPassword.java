/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author william.marin
 */
public class EvaluadorPassword {

    // voy a calcular sobre 10 la puntuación de la contraseña, 2 puntos por 5 criterios: longitud, mayus, minus, num y char especial.
    public int calcularFortaleza(String password) {
        int puntuacion = 0;
        boolean tieneMayus = false;
        boolean tieneMinus = false;
        boolean tieneNum = false;
        boolean tieneChar = false;

        if (password.length() >= 8) {
            puntuacion += 20;
        }

        for (int i = 0; i < password.length(); i++) {

            char caracter = password.charAt(i);

            if (Character.isUpperCase(caracter)) {
                tieneMayus = true;
            } else if (Character.isLowerCase(caracter)) {
                tieneMinus = true;
            } else if (Character.isDigit(caracter)) {
                tieneNum = true;
            } else {
                tieneChar = true;
            }

        }

        if (tieneMayus) {

            puntuacion += 20;

        }

        if (tieneMinus) {

            puntuacion += 20;

        }

        if (tieneNum) {

            puntuacion += 20;

        }

        if (tieneChar) {

            puntuacion += 20;

        }

        return puntuacion;
    }

    public String nivelPassword(int puntuacion) {
        
        if (puntuacion <= 40) {

            return "Débil";

        } else if (puntuacion <= 80) {

            return "Media";

        } else {

            return "Fuerte";

        }
    }

}
