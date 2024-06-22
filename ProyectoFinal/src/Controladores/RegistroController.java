/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controladores;


import Classes.Usuario;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;
import static proyectofinal.ProyectoFinal.Usuarios;
import static proyectofinal.ProyectoFinal.sFinal;

public class RegistroController implements Initializable {

    // Variables
    @FXML
    private Button botonRegistro;
    @FXML
    private ImageView botonRegresoR;
    @FXML
    private TextField registroContra;
    @FXML
    private TextField registroCorreo;
    @FXML
    private DatePicker registroFecha;
    @FXML
    private TextField registroUsuario;
    
    // Evento para volver al login
    @FXML
    void mouseClick(MouseEvent event) {
        loadStage("/Vistas/Login.fxml", event);
    }

    // Evento para registrarse
    @FXML
    void onAction(ActionEvent event) {
        Object evt = event.getSource();
        
        if(evt.equals(botonRegistro)){
            // Verificar que los campos no esten vacios
            if(!registroContra.getText().isEmpty() && !registroCorreo.getText().isEmpty() && !String.valueOf(registroFecha.getValue()).isEmpty() &&
            !registroUsuario.getText().isEmpty()){
                
                String correo = registroCorreo.getText();
                String contra = registroContra.getText();
                String usuario = registroUsuario.getText();
                LocalDate fecha = registroFecha.getValue();
                String foto = "";
                
                Usuario u = new Usuario(usuario,correo,contra,foto,fecha);
                Usuarios.add(u);
                limpiarCampos();
                JOptionPane.showMessageDialog(null, "¡Registro exitoso!");
                
            }else{
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            }
//            System.out.println(registroFecha.getValue().getYear());

        }
    }
    
    // Metodo para limpiar campos
    private void limpiarCampos(){
        registroContra.setText("");
        registroCorreo.setText("");
        registroUsuario.setText("");
        registroFecha.setValue(null);
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
