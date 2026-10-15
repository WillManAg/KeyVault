/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author william.marin
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class VaultDAO {

    public void guardarRegistro(String rutaArchivo,
            RegistroPassword registro)
            throws IOException {

        try (BufferedWriter escritor
                = new BufferedWriter(
                        new FileWriter(rutaArchivo, true))) {

            escritor.write(
                    registro.getNivelFortaleza()
                    + ";"
                    + registro.getFechaRegistro()
                    + ";"
                    + registro.getClave()
            );

            escritor.newLine();

        }

    }

    public ArrayList<RegistroPassword> leerRegistros(String rutaArchivo)
            throws IOException {

        ArrayList<RegistroPassword> registros
                = new ArrayList<>();

        try (BufferedReader lector
                = new BufferedReader(
                        new FileReader(rutaArchivo))) {

            String linea;

            while ((linea = lector.readLine()) != null) {

                if (!linea.trim().isEmpty()) {

                    String[] partes
                            = linea.split(";", 3);

                    if (partes.length == 3) {

                        int nivelFortaleza
                                = Integer.parseInt(partes[0]);

                        String fechaRegistro
                                = partes[1];

                        String clave
                                = partes[2];

                        RegistroPassword registro
                                = new RegistroPassword(
                                        clave,
                                        nivelFortaleza,
                                        fechaRegistro
                                );

                        registros.add(registro);

                    }

                }

            }

        }

        return registros;

    }

}
