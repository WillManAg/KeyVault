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

public class VaultDAO {

    public void guardarRegistro(String rutaArchivo,
            RegistroPassword registro)
            throws IOException {

        FileWriter archivo
                = new FileWriter(rutaArchivo, true);

        BufferedWriter escritor
                = new BufferedWriter(archivo);

        escritor.write(
                registro.getNivelFortaleza()
                + ";"
                + registro.getFechaRegistro()
                + ";"
                + registro.getClave()
        );

        escritor.newLine();

        escritor.close();
        archivo.close();

    }

}
