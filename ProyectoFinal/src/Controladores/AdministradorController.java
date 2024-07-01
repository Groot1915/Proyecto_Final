/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controladores;

import Classes.Archivos;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;
import static proyectofinal.ProyectoFinal.Productos;
import static proyectofinal.ProyectoFinal.sFinal;

public class AdministradorController implements Initializable {

    @FXML
    private TextField adminIdLibro;
    @FXML
    private TextField adminNAutor;
    @FXML
    private TextArea adminNDes;
    @FXML
    private TextField adminNLibro;
    @FXML
    private TableView<?> adminTabla;
    @FXML
    private Button botonCrear;
    @FXML
    private Button botonEliminar;
    @FXML
    private Label botonSubirCara;
    @FXML
    private ImageView botonAtras;
    @FXML
    private ComboBox<String> comboRegistro;
    @FXML
    private TextField adminNPrecio;
    
    ObservableList<String> listaOpciones = 
            FXCollections.observableArrayList(
                "Infantiles",
                "Juveniles",
                "Clasicos"
            );
    private String imagen = "";
    Archivos ar = new Archivos();
    
    
    @FXML
    void mouseClicked(MouseEvent event) {
        
        Object evt = event.getSource();
        
        if(evt.equals(botonSubirCara)){
            FileChooser fc = new FileChooser();
            fc.setTitle("Agrega una imagen");
            fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPEG image", "*.jpg"),
                    new FileChooser.ExtensionFilter("PNG image", "*.png"), new FileChooser.ExtensionFilter("All Images", "*.jpg",".png"));
            File selectedFile = fc.showOpenDialog(sFinal);
            if(selectedFile != null){
                this.setImagen(selectedFile.getPath());
            }else{
                JOptionPane.showMessageDialog(null, "Ninguna imagen ha sido seleccionada");
            }
        } else if(evt.equals(botonAtras)){
            loadStage("/Vistas/Login.fxml",event);
        }
        

    }

    @FXML
    void mouseEnter(MouseEvent event) {
        Object evt = event.getSource();
        
        if(evt.equals(botonSubirCara)){
            Paint p = Paint.valueOf("#8A94E0");
            botonSubirCara.setTextFill(p);
        }
    }

    @FXML
    void mouseExit(MouseEvent event) {
        Object evt = event.getSource();
        
        if(evt.equals(botonSubirCara)){
            Paint p = Paint.valueOf("#6c7beb");
            botonSubirCara.setTextFill(p);
        }
    }

    // Metodo para solo permitir caracteres numericos
    @FXML
    void keyTyped(KeyEvent event) {
        
        Object evt = event.getSource();
 
        if(evt.equals(adminIdLibro)){
            if(adminIdLibro.getText().length() != 0){
                if(!adminIdLibro.getText().substring(adminIdLibro.getText().length() -1).matches("[0-9]")){
                    JOptionPane.showMessageDialog(null, "Ingrese un caracter válido");
                    adminIdLibro.setText("");
                }
            }
        } else if(evt.equals(adminNPrecio)){
            if(adminNPrecio.getText().length() != 0){
                if(!adminNPrecio.getText().substring(adminNPrecio.getText().length() -1).matches("[0-9]")){
                    JOptionPane.showMessageDialog(null, "Ingrese un caracter válido");
                    adminNPrecio.setText("");
                }
            }
        }
    }

    @FXML
    void onAction(ActionEvent event) throws IOException {
        Object evt = event.getSource();
        
        if(evt.equals(botonCrear)){
            if(!adminNLibro.getText().isEmpty() && !adminNAutor.getText().isEmpty() && !adminNDes.getText().isEmpty() && !this.getImagen().equals("") && !adminNPrecio.getText().isEmpty()){
                String nombreLibro = adminNLibro.getText();
                String nombreAutor = adminNAutor.getText();
                String descripcion = adminNDes.getText();
                String tipo = comboRegistro.getValue();
                int precio = Integer.parseInt(adminNPrecio.getText());
                Productos.insertarCola(nombreLibro, nombreAutor, descripcion, imagen, tipo, precio);
                ar.escribirProductos();
                limpiarCamposCrear();
                JOptionPane.showMessageDialog(null, "¡Libro creado exitosamente!");
            }else{
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            }
        } else if(evt.equals(botonEliminar)){
            if(!adminIdLibro.getText().isEmpty()){
    
                if(Productos.existeID(Integer.parseInt(adminIdLibro.getText()))){
                    Productos.eliminarCola(Integer.parseInt(adminIdLibro.getText()));
                    ar.escribirProductos();
                    JOptionPane.showMessageDialog(null, "¡Elemento eliminado correctamente!");
                }else{
                    JOptionPane.showMessageDialog(null, "Elemento no existe, ingrese un id valido");
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un id valido");
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
    
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    private void limpiarCamposCrear(){
        adminNLibro.setText("");
        adminNAutor.setText("");
        adminNDes.setText("");
        adminNPrecio.setText("");
        this.setImagen("");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboRegistro.setItems(listaOpciones);
        comboRegistro.setValue("Infantiles");
    }    


    
}
