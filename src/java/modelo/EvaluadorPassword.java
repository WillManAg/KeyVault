/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author william.marin
 */
import java.util.ArrayList;
import java.util.List;

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

    public String consejo(String password) {

        boolean tieneMayus = false;
        boolean tieneMinus = false;
        boolean tieneNum = false;
        boolean tieneChar = false;
        List<String> faltan = new ArrayList<>();

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

        if (password.length() < 8) {
            faltan.add("tener al menos 8 caracteres");
        }
        if (!tieneMayus) {
            faltan.add("una letra mayúscula");
        }
        if (!tieneMinus) {
            faltan.add("una letra minúscula");
        }
        if (!tieneNum) {
            faltan.add("un número");
        }
        if (!tieneChar) {
            faltan.add("un carácter especial");
        }

        if (faltan.isEmpty()) {
            return "La contraseña es perfecta!";
        }

        return "Para mejorar la puntuación falta: " + String.join(", ", faltan) + ".";
    }

    public String tiempoEstimadoRotura(String password, int puntuacion) {

        int longitud = password.length();

        if (longitud <= 5) {

            return "Prácticamente instantáneo!!";

        }

        if (longitud <= 7) {

            if (puntuacion >= 80) {

                return "Semanas o meses";

            } else if (puntuacion >= 60) {

                return "Días o semanas";

            } else {

                return "Minutos u horas";

            }

        }

        if (longitud == 8) {

            if (puntuacion == 100) {

                return "Aproximádamente 164 años";

            } else if (puntuacion >= 80) {

                return "Entre 15 y 62 años";

            } else if (puntuacion >= 60) {

                return "Semanas o meses";

            } else {

                return "Prácticamente instantáneo!!";

            }

        }

        if (longitud <= 10) {

            if (puntuacion == 100) {

                return "Cientos de miles de años";

            } else if (puntuacion >= 80) {

                return "Miles de años";

            } else {

                return "Años o décadas";

            }

        }

        if (longitud <= 12) {

            if (puntuacion >= 80) {

                return "Millones de años";

            } else {

                return "Miles de años";

            }

        }

        return "Millones de años o más";

    }

}
