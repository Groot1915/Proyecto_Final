package Modelo;
// JUAN
public class tabaco implements Visitable{
 
    private double precio;
    
    public tabaco(double item){
        precio = item;
    }
    
    public double getPrecio(){
        return precio;
    }
    
    public double aceptar(Visitor visitor){
        return visitor.visitar(this);
    }
}
