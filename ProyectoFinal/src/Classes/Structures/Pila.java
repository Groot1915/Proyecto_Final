package Classes.Structures;

import Classes.Nodos.NodoProducto;

public class Pila {
    
    private NodoProducto ultimoValorIngresado;
    int tam = 0;
    private int id = 0;
    
    public Pila(){
        ultimoValorIngresado = null;
        tam = 0;
    }
    
    // Metodo para saber si la pila está vacía
    public boolean pilaVacia(){
        return ultimoValorIngresado == null;
    }
    
    // Metodo para insertar un nodo en la pila
    public void insertarPila(String nombre, String autor, String descripcion, String rutaImagen){
        NodoProducto n = new NodoProducto();
        n.nombre = nombre;
        n.autor = autor;
        n.descripcion = descripcion;
        n.rutaImagen = rutaImagen;
        n.id = getId();
        n.siguiente = null;
        id++;
        n.siguiente = ultimoValorIngresado;
        ultimoValorIngresado = n;
        tam++;
    }

    public int getId() {
        return id;
    }
    
    public int tamPila(){
        return tam;
    }
    
    // Sacar todos los valores de la pila
    public NodoProducto[] obtenerNodosPila(){
        NodoProducto n = ultimoValorIngresado;
        NodoProducto[] arrProductos = new NodoProducto[this.tamPila()];
        
        for(int i = 0; i < this.tamPila(); i++){
            if(i == 0){
                arrProductos[i] = ultimoValorIngresado;
            } else{
                arrProductos[i] = ultimoValorIngresado.siguiente;
            }
        }
        return arrProductos;
    }
    
}
