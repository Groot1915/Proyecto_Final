package Classes.Structures;

import Classes.Nodos.NodoProducto;
import java.io.Serializable;
import java.util.ArrayList;

public class Cola implements Serializable{
    
    private static final long serialVersionUID  =  -1481805510286716457L;
    private NodoProducto inicioCola, finalCola;
    private int id = 0;
    
    public Cola(){
        inicioCola = null;
        finalCola = null;
    }
    
    // Metodo para devolver nodo de error para la validacion
    public NodoProducto nodoError(){
        NodoProducto nError = new NodoProducto();
        nError.nombre = "";
        nError.descripcion = "";
        nError.autor = "";
        nError.rutaImagen = null;
        nError.id = -1;
        
        return nError;
    }
    
    // Metodo para saber si la cola esta vacia
    public boolean colaVacia(){
        if(inicioCola == null){
            return true;
        } else{
            return false;
        }
    }
    
    // Metodo para insertar a la cola
    public void insertarCola(String nombre, String autor, String descripcion, String rutaImagen, String tipo){
        NodoProducto n = new NodoProducto();
        n.nombre = nombre;
        n.autor = autor;
        n.descripcion = descripcion;
        n.rutaImagen = rutaImagen;
        n.tipo = tipo;
        n.id = getId();
        n.siguiente = null;
        id++;
        
        if(colaVacia()){
            inicioCola = n;
            finalCola = n;
        } else{
            finalCola.siguiente = n;
            finalCola = n;
        }
    }
    
    // Metodo para obtener el id
    public int getId() {
        return id;
    }
    
    // Metodo para extraer un dato de la cola
    public NodoProducto extraerColaId(int id){
        if(!colaVacia()){
            NodoProducto n = inicioCola;
            
            while(n != null){
                if(n.id == id){
                    return n;
                } else{
                    n = n.siguiente;
                }
            }
        }
        return nodoError();
    }
    
    // Metodo para obtener tamaño de la cola
    public int tamCola(){
        NodoProducto n = inicioCola;
        int tam = 0;
        while(n != null){
            tam++;
            n = n.siguiente;
        }
        return tam;
    }
    
    // Metodo para eliminar elemento de la cola
    public void eliminarCola(int id){
        if(!colaVacia()){
            if(inicioCola == finalCola && id == inicioCola.id){
                inicioCola = finalCola = null;
            } else if(id == inicioCola.id){
                inicioCola = inicioCola.siguiente;
            } else{
                NodoProducto anterior, temporal;
                anterior = inicioCola;
                temporal = inicioCola.siguiente;
                while(temporal != null && temporal.id != id){
                    anterior = anterior.siguiente;
                    temporal = temporal.siguiente;
                }
                if(temporal != null){
                    anterior.siguiente = temporal.siguiente;
                    if(temporal == finalCola){
                        finalCola = anterior;
                    }
                }
            }
        }
    }
    
    // Metodo para confirmar que un elemento con un determinado id existes
    public boolean existeID(int id){
        if(!colaVacia()){
            NodoProducto n = inicioCola;
            
            while(n != null){
                if(n.id == id){
                    return true;
                } else{
                    n = n.siguiente;
                }
            }
        }
        return false;
    }
    
    // Metodo para obtener los nodos en array
    public ArrayList<NodoProducto> obtenerNodosCola(){
        NodoProducto n = inicioCola;
        ArrayList<NodoProducto> arrProductos = new ArrayList<>();
        
        while(n != null){
            arrProductos.add(n);
            n = n.siguiente;
        }
        
        return arrProductos;
    }
    
    
}
