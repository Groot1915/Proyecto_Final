package Modelo;
// JUAN
public class licor implements Visitable{
    
    private double precio;
    
    public licor(double item){
        precio = item;
    }
    
    public double getPrecio(){
        return precio;
    }
    
    public double aceptar(Visitor visitor){
        return visitor.visitar(this);
    }
    
}
