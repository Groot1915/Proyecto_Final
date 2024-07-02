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
import javafx.scene.Cursor;
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
import static proyectofinal.ProyectoFinal.idLibroGeneral;
import static proyectofinal.ProyectoFinal.sFinal;
import static proyectofinal.ProyectoFinal.uActivo;

public class PrincipalController implements Initializable {

    // INFANTIL
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
    
    public int valorInfantil = 0;
    
    // JUVENIL
    @FXML
    private ImageView juvenil1;
    @FXML
    private ImageView juvenil2;
    @FXML
    private ImageView juvenil3;
    @FXML
    private ImageView juvenil4;
    @FXML
    private Label juvenilesFDer;
    @FXML
    private Label juvenilesFIzq;
    
    public int valorJuvenil = 0;
    
    // CLASICOS
    @FXML
    private ImageView clasicos1;
    @FXML
    private ImageView clasicos2;
    @FXML
    private ImageView clasicos3;
    @FXML
    private ImageView clasicos4;
    @FXML
    private Label clasicosFDer;
    @FXML
    private Label clasicosFIzq;
    
    public int valorClasicos = 0;
    
    // GENERALES
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
            this.limpiarImagenesI();
            valorInfantil += 4;
            cargarLibrosInfantiles();
            infantilFIzquierda.setVisible(true);
        } else if(evt.equals(infantilFIzquierda)){
            this.limpiarImagenesI();
            valorInfantil -= 4;
            cargarLibrosInfantiles();
            infantilFDerecha.setVisible(true);
            if(valorInfantil == 0){
                infantilFIzquierda.setVisible(false);
            }
        } else if(evt.equals(juvenilesFDer)){
            this.limpiarImagenesJ();
            valorJuvenil += 4;
            cargarLibrosJuveniles();
            juvenilesFIzq.setVisible(true);
        } else if(evt.equals(juvenilesFIzq)){
            this.limpiarImagenesJ();
            valorJuvenil -= 4;
            cargarLibrosJuveniles();
            juvenilesFDer.setVisible(true);
            if(valorJuvenil == 0){
                juvenilesFIzq.setVisible(false);
            }
        } else if(evt.equals(clasicosFDer)){
            this.limpiarImagenesC();
            valorClasicos += 4;
            cargarLibrosClasicos();
            clasicosFIzq.setVisible(true);
        } else if(evt.equals(clasicosFIzq)){
            this.limpiarImagenesC();
            valorClasicos -= 4;
            cargarLibrosClasicos();
            clasicosFDer.setVisible(true);
            if(valorClasicos == 0){
                clasicosFIzq.setVisible(false);
            }
        // CONTROL DE CLICK EN IMAGENES
        } else if(evt.equals(infantil1)){
            abrirCompraLibro(infantil1, "Infantiles", event);
            
        } else if(evt.equals(infantil2)){
            abrirCompraLibro(infantil2, "Infantiles", event); 
            
        } else if(evt.equals(infantil3)){
            abrirCompraLibro(infantil3, "Infantiles", event); 
            
        } else if(evt.equals(infantil4)){
            abrirCompraLibro(infantil4, "Infantiles", event);  
            
        } else if(evt.equals(juvenil1)){
            abrirCompraLibro(juvenil1, "Juveniles", event);   
            
        } else if(evt.equals(juvenil2)){
            abrirCompraLibro(juvenil2, "Juveniles", event);  
            
        } else if(evt.equals(juvenil3)){
            abrirCompraLibro(juvenil3, "Juveniles", event);  
            
        } else if(evt.equals(juvenil4)){
            abrirCompraLibro(juvenil4, "Juveniles", event);  
            
        } else if(evt.equals(clasicos1)){
            abrirCompraLibro(clasicos1, "Clasicos", event); 
            
        } else if(evt.equals(clasicos2)){
            abrirCompraLibro(clasicos2, "Clasicos", event);  
            
        } else if(evt.equals(clasicos3)){
            abrirCompraLibro(clasicos3, "Clasicos", event);   
            
        } else if(evt.equals(clasicos4)){
            abrirCompraLibro(clasicos4, "Clasicos", event);   
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
                        imagenes.get(i).setCursor(Cursor.HAND);
                        return;
                    } else{
                        Image img = new Image("." + arInfantiles.get(e).rutaImagen.substring(45));
                        imagenes.get(i).setImage(img);
                        imagenes.get(i).setCursor(Cursor.HAND);
                    }
                e++;
                }
            } 
        }
    }

    private void cargarLibrosJuveniles(){
        ArrayList<NodoProducto> arGeneral = Productos.obtenerNodosCola();
        ArrayList<NodoProducto> arJuveniles = new ArrayList<>();
        ArrayList<ImageView> imagenes = new ArrayList<>();
        imagenes.add(juvenil1); imagenes.add(juvenil2); imagenes.add(juvenil3); imagenes.add(juvenil4);
        int e = valorJuvenil;
        
        if(arGeneral.size() != 0){
            for(int i = 0; i < arGeneral.size(); i++){
                if(arGeneral.get(i).tipo.equals("Juveniles")){
                    arJuveniles.add(arGeneral.get(i));
                }
            }

            for(int i = 0; i < imagenes.size(); i++){
                if(e > -1 && e < arJuveniles.size()){
                    if(arJuveniles.get(e).id == arJuveniles.get(arJuveniles.size()-1).id){
                        Image img = new Image("." + arJuveniles.get(e).rutaImagen.substring(45));
                        imagenes.get(i).setImage(img);
                        juvenilesFDer.setVisible(false);
                        imagenes.get(i).setCursor(Cursor.HAND);
                        return;
                    } else{
                        Image img = new Image("." + arJuveniles.get(e).rutaImagen.substring(45));
                        imagenes.get(i).setImage(img);
                        imagenes.get(i).setCursor(Cursor.HAND);
                    }
                e++;
                }
            } 
        }
    }
    
    private void cargarLibrosClasicos(){
        ArrayList<NodoProducto> arGeneral = Productos.obtenerNodosCola();
        ArrayList<NodoProducto> arClasicos = new ArrayList<>();
        ArrayList<ImageView> imagenes = new ArrayList<>();
        imagenes.add(clasicos1); imagenes.add(clasicos2); imagenes.add(clasicos3); imagenes.add(clasicos4);
        int e = valorClasicos;
        
        if(arGeneral.size() != 0){
            for(int i = 0; i < arGeneral.size(); i++){
                if(arGeneral.get(i).tipo.equals("Clasicos")){
                    arClasicos.add(arGeneral.get(i));
                }
            }

            for(int i = 0; i < imagenes.size(); i++){
                if(e > -1 && e < arClasicos.size()){
                    if(arClasicos.get(e).id == arClasicos.get(arClasicos.size()-1).id){
                        Image img = new Image("." + arClasicos.get(e).rutaImagen.substring(45));
                        imagenes.get(i).setImage(img);
                        clasicosFDer.setVisible(false);
                        imagenes.get(i).setCursor(Cursor.HAND);
                        return;
                    } else{
                        Image img = new Image("." + arClasicos.get(e).rutaImagen.substring(45));
                        imagenes.get(i).setImage(img);
                        imagenes.get(i).setCursor(Cursor.HAND);
                    }
                e++;
                }
            } 
        }
    }
    
    private void limpiarImagenesI(){
        infantil1.setImage(null);
        infantil2.setImage(null);
        infantil3.setImage(null);
        infantil4.setImage(null);
        infantil1.setCursor(Cursor.DEFAULT);
        infantil2.setCursor(Cursor.DEFAULT);
        infantil3.setCursor(Cursor.DEFAULT);
        infantil4.setCursor(Cursor.DEFAULT);

    }
    
    private void limpiarImagenesJ(){
        juvenil1.setImage(null);
        juvenil2.setImage(null);
        juvenil3.setImage(null);
        juvenil4.setImage(null);
        juvenil1.setCursor(Cursor.DEFAULT);
        juvenil2.setCursor(Cursor.DEFAULT);
        juvenil3.setCursor(Cursor.DEFAULT);
        juvenil4.setCursor(Cursor.DEFAULT);
    }
    
    private void limpiarImagenesC(){
        clasicos1.setImage(null);
        clasicos2.setImage(null);
        clasicos3.setImage(null);
        clasicos4.setImage(null);
        clasicos1.setCursor(Cursor.DEFAULT);
        clasicos2.setCursor(Cursor.DEFAULT);
        clasicos3.setCursor(Cursor.DEFAULT);
        clasicos4.setCursor(Cursor.DEFAULT);
    }
    
    private void abrirCompraLibro(ImageView labelImagen, String tipo, Event event){
        try {
            String urlImagenPantalla = labelImagen.getImage().getUrl().split("[/]")[labelImagen.getImage().getUrl().split("[/]").length-1];
                for(int i = 0; i < Productos.obtenerNodosCola().size(); i++){
                    String urlImgArrGeneral = Productos.obtenerNodosCola().get(i).rutaImagen.split("[/]")[Productos.obtenerNodosCola().get(i).rutaImagen.split("[/]").length-1];
                    String tipoProducto = Productos.obtenerNodosCola().get(i).tipo;
                    if(urlImagenPantalla.equals(urlImgArrGeneral) && tipo.equals(tipoProducto)){
                        idLibroGeneral = Productos.obtenerNodosCola().get(i).id;
                        loadStage("/Vistas/CompraLibro.fxml", event);
                        return;
                    }
                }   
        } catch (Exception e) {
            System.err.println("Elemento No Existe");
        } 
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Controlar nombre de usuario
        principalNombre.setText(uActivo.getNombre());
        
        // Controlar imagenes de libros infantiles
        cargarLibrosInfantiles();
        infantilFIzquierda.setVisible(false);
        
        // Controlar imagenes de libros juveniles
        cargarLibrosJuveniles();
        juvenilesFIzq.setVisible(false);
        
        // Controlar imagenes de libros clasicos
        cargarLibrosClasicos();
        clasicosFIzq.setVisible(false);
        
    }    
    
}
