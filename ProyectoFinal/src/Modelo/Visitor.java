package Modelo;
// JUAN
public interface Visitor {
    
    public double visitar(licor licorItem);
    public double visitar(tabaco tabacoItem);
    public double visitar(necesidad necesidadItem);
    
}
