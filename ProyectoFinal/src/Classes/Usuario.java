package Classes;

import Classes.Structures.*; // Importa las estructuras de datos (colas, pilas, usando listas enlazadas)
import java.util.Date;

public class Usuario {

private String nombre;
private String correo;
private String password;
private String fotoPerfil;
private Date fechaNacimiento;
private Cola carrito;
private Cola deseos;
private Pila historial;

    /////////////////////// Constructor///////////////////////
    public Usuario(String n, String c, String pw, String fp, Date fn){
        this.nombre = n;
        this.correo = c;
        this.password = pw;
        this.fotoPerfil = fp;
        this.fechaNacimiento = fn;
        this.carrito = new Cola();
        this.deseos = new Cola();
        this.historial = new Pila();
    }
    ///////////////////////////////////////////////////////////
    
    
    // Encapsulado
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cola getCarrito() {
        return carrito;
    }

    public Cola getDeseos() {
        return deseos;
    }

    public Pila getHistorial() {
        return historial;
    }
    
    

}
