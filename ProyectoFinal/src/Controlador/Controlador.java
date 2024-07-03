package Controlador;
// JUAN

import Modelo.licor;
import Modelo.necesidad;
import Modelo.tabaco;
import Modelo.visitorImpuestos;
import Vista.VIsta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener{
    
    private VIsta vista;
    private visitorImpuestos vi;
    
    public Controlador(){
        vista = new VIsta();
        vi = new visitorImpuestos();
        
        vista.Licor.addActionListener(this);
        vista.Tabaco.addActionListener(this);
        vista.Necesidad.addActionListener(this);
    }
    
    public void run(){
       vista.setLocationRelativeTo(null);
       vista.setResizable(false);
       vista.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == vista.Licor){
            licor l = new licor(Double.parseDouble(vista.Precio.getText()));
            vista.Total.setText(String.valueOf(l.aceptar(vi)));
        }
        
        if(e.getSource() == vista.Tabaco){
            tabaco t = new tabaco(Double.parseDouble(vista.Precio.getText()));
            vista.Total.setText(String.valueOf(t.aceptar(vi)));
        }
        
        if(e.getSource() == vista.Necesidad){
            necesidad n = new necesidad(Double.parseDouble(vista.Precio.getText()));
            vista.Total.setText(String.valueOf(n.aceptar(vi)));
        }
        
        
    }
    
}
