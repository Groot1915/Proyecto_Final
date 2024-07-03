package Modelo;
// JUAN

import java.text.DecimalFormat;

public class visitorImpuestos implements Visitor{
    
    DecimalFormat df = new DecimalFormat("#.##");
    
    public visitorImpuestos(){
        
    }
    
    public double visitar(licor licorItem){
        return Double.parseDouble(df.format((licorItem.getPrecio() * .18 ) + licorItem.getPrecio()));
    }
    
    public double visitar(tabaco tabacoItem){
        return Double.parseDouble(df.format((tabacoItem.getPrecio() * .32 ) + tabacoItem.getPrecio()));
    }
    
    public double visitar(necesidad necesidadItem){
        return Double.parseDouble(df.format((necesidadItem.getPrecio() * .15) + necesidadItem.getPrecio()));
    }
    
    
    
}
