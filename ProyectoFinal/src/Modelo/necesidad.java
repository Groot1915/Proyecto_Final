package Modelo;
// JUAN
public class necesidad{
        
    private double precio;
    
    public necesidad(double precio){
        this.precio = precio;
    }
    
    public double getPrecio(){
        return precio;
    }
    
    public double aceptar(Visitor visitor){
        return visitor.visitar(this);
    }

}
