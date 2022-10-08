/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author elvis
 */
public class profesor {
    
    private String nombre;
    private String docente;
    private String semestre;
    private String cantidad;

    public profesor() {
    }

    public profesor(String nombre, String docente, String semestre, String cantidad) {
        this.nombre = nombre;
        this.docente = docente;
        this.semestre = semestre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "profesor{" + "nombre=" + nombre + ", docente=" + docente + ", semestre=" + semestre + ", cantidad=" + cantidad + '}';
    }
    
    
    
}
