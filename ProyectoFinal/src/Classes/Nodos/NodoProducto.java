package Classes.Nodos;

import java.io.Serializable;
import javafx.scene.image.Image;

public class NodoProducto implements Serializable{
 
    public String nombre;
    public String autor;
    public String descripcion;
    public String rutaImagen;
    public String tipo;
    public int id;
    public int precio;
    public NodoProducto siguiente;
}
