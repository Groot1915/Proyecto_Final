package Controladores;

import Classes.Nodos.NodoProducto;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;
import static proyectofinal.ProyectoFinal.Productos;
import static proyectofinal.ProyectoFinal.idLibroGeneral;
import static proyectofinal.ProyectoFinal.sFinal;

public class CompraLibroController implements Initializable {
    
    @FXML
    private Label libroCompraAutor;
    @FXML
    private Button libroCompraComprar;
    @FXML
    private TextArea libroCompraDes;
    @FXML
    private ImageView libroCompraFavoritos;
    @FXML
    private ImageView libroCompraImagen;
    @FXML
    private Label libroCompraPrecio;
    @FXML
    private ImageView libroCompraRegresar;
    @FXML
    private Label libroCompraTitulo;
    @FXML
    private TextField libroCompraCantidad;
    
    String rutaImagenCompra;
    String tituloLibro;
    String autorLibro;
    String descripcionLibro;
    String precioLibro;
    
    

    
    @FXML
    void mouseClicked(MouseEvent event) {
        Object evt = event.getSource();
        
        if(evt.equals(libroCompraRegresar)){
            loadStage("/Vistas/Principal.fxml",event);
        }
        
    }
    
    @FXML
    void onAction(ActionEvent event) {
        Object evt = event.getSource();
        
        if(evt.equals(libroCompraComprar)){
            
        }
    }
    
    @FXML
    void keyTyped(KeyEvent event) {
        Object evt = event.getSource();
        
        if(evt.equals(libroCompraCantidad)){
            if(libroCompraCantidad.getText().length() != 0){
                 if(!libroCompraCantidad.getText().substring(libroCompraCantidad.getText().length() -1).matches("[0-9]")){
                     JOptionPane.showMessageDialog(null, "Ingrese un caracter válido");
                     libroCompraCantidad.setText("");
                 }
             }
        }
    }
    
    // Metodo para cambiar de vista
    private void loadStage(String url, Event event){
        try {
            
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene oldScene = sourceAsNode.getScene();
            Window window = oldScene.getWindow();
            Stage stage = (Stage) window;
            stage.hide();
            
            Parent root = FXMLLoader.load(getClass().getResource(url));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.show();
            sFinal = newStage;

            newStage.setOnCloseRequest(new EventHandler<WindowEvent>(){
                @Override
                public void handle(WindowEvent event){
                    Platform.exit();
                }
            });
            
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cargarVariables(){
        for(int i = 0; i < Productos.tamCola(); i++){
            if(Productos.obtenerNodosCola().get(i).id == idLibroGeneral){
                NodoProducto p = Productos.obtenerNodosCola().get(i);
                this.rutaImagenCompra = p.rutaImagen;
                this.tituloLibro = p.nombre;
                this.autorLibro = p.autor;
                this.descripcionLibro = p.descripcion;
                this.precioLibro = String.valueOf(p.precio);
            }
        }
    }
    
    private void mostrarVariables(){
        cargarVariables();
        Image img = new Image("." + this.rutaImagenCompra.substring(45));
        this.libroCompraImagen.setImage(img);
        this.libroCompraTitulo.setText(tituloLibro);
        this.libroCompraAutor.setText(autorLibro);
        this.libroCompraDes.setText(descripcionLibro);
        this.libroCompraPrecio.setText("$"+precioLibro);
    }
    
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarVariables();
    }    
    
}
