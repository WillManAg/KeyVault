/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author william.marin
 */
public class RegistroPassword {
    
    private String clave;
    private int nivelFortaleza;
    private String fechaRegistro;
    
    public RegistroPassword (String clave, int nivelFortaleza, String fechaRegistro) {
        
        this.clave = clave;
        this.nivelFortaleza = nivelFortaleza;
        this.fechaRegistro = fechaRegistro;
        
    }
    
    public String getClave() {
        return clave;
    }
    
    public String setClave(String clave) {
        return this.clave = clave;
    }
    
    public String getFechaRegistro() {
        return fechaRegistro;
    }
    
    public String setFechaRegistro(String fechaRegistro) {
        return this.fechaRegistro = fechaRegistro;
    }
    
    
    public int getNivelFortaleza() {
        return nivelFortaleza;
    }
    
    public int setNivelFortaleza(int nivelFortaleza) {
        return this.nivelFortaleza = nivelFortaleza;
    }
    
    
}
