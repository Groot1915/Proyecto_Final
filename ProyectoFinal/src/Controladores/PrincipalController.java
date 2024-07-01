package Controladores;

import Classes.Nodos.NodoProducto;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;
import static proyectofinal.ProyectoFinal.Productos;
import static proyectofinal.ProyectoFinal.sFinal;
import static proyectofinal.ProyectoFinal.uActivo;

public class PrincipalController implements Initializable {

    @FXML
    private ImageView infantil1;
    @FXML
    private ImageView infantil2;
    @FXML
    private ImageView infantil3;
    @FXML
    private ImageView infantil4;
    @FXML
    private Label infantilFDerecha;
    @FXML
    private Label infantilFIzquierda;
    @FXML
    private ImageView principalCarrito;
    @FXML
    private ImageView principalFavoritos;
    @FXML
    private ImageView principalHistorial;
    @FXML
    private Label principalNombre;
    @FXML
    private ImageView principalRegreso;
    @FXML
    private ImageView principalUsuario;
    
    public int valorInfantil = 0;
    
    // Método para manejar todos los botones de esta clase
    @FXML
    void mouseClicked(MouseEvent event) {

        Object evt = event.getSource();
        
        // Para volver atrás
        if(evt.equals(principalRegreso)){
            if(JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesión?", "Cerrar Sesión", 2) == 0){
                loadStage("/Vistas/Login.fxml",event);
            }
        } else if(evt.equals(infantilFDerecha)){
            this.limpiarImagenes();
            valorInfantil += 4;
            cargarLibrosInfantiles();
            infantilFIzquierda.setVisible(true);
        } else if(evt.equals(infantilFIzquierda)){
            this.limpiarImagenes();
            valorInfantil -= 4;
            cargarLibrosInfantiles();
            infantilFDerecha.setVisible(true);
            if(valorInfantil == 0){
                infantilFIzquierda.setVisible(false);
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
    
    private void cargarLibrosInfantiles(){
        ArrayList<NodoProducto> arGeneral = Productos.obtenerNodosCola();
        ArrayList<NodoProducto> arInfantiles = new ArrayList<>();
        ArrayList<ImageView> imagenes = new ArrayList<>();
        imagenes.add(infantil1); imagenes.add(infantil2); imagenes.add(infantil3); imagenes.add(infantil4);
        int e = valorInfantil;
        
        if(arGeneral.size() != 0){
            for(int i = 0; i < arGeneral.size(); i++){
                if(arGeneral.get(i).tipo.equals("Infantiles")){
                    arInfantiles.add(arGeneral.get(i));
                }
            }

            for(int i = 0; i < imagenes.size(); i++){
                if(e > -1 && e < arInfantiles.size()){
                    if(arInfantiles.get(e).id == arInfantiles.get(arInfantiles.size()-1).id){
                        Image img = new Image("." + arInfantiles.get(e).rutaImagen.substring(45));
                        imagenes.get(i).setImage(img);
                        infantilFDerecha.setVisible(false);
                        return;
                    } else{
                        Image img = new Image("." + arInfantiles.get(e).rutaImagen.substring(45));
                        imagenes.get(i).setImage(img);
                    }
                e++;
                }
            } 
        }
      
    }
    
    private void limpiarImagenes(){
        infantil1.setImage(null);
        infantil2.setImage(null);
        infantil3.setImage(null);
        infantil4.setImage(null);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Controlar nombre de usuario
        principalNombre.setText(uActivo.getNombre());
        // Controlar imagenes de libros infantiles
        cargarLibrosInfantiles();
        infantilFIzquierda.setVisible(false);
        
    }    
    
}
