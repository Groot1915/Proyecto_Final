/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controladores;



import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;
import static proyectofinal.ProyectoFinal.Usuarios;
import static proyectofinal.ProyectoFinal.sFinal;

/**
 * FXML Controller class
 *
 * @author juan
 */
public class LoginController implements Initializable {

    // Variables de la Vista Login
    @FXML
    private Button loginBoton;
    @FXML
    private TextField loginUsuario;
    @FXML
    private PasswordField loginContra;
    @FXML
    private Label loginRegistrarse;
    

    // Evento de tocar boton de iniciar sesión
    @FXML
    private void onAction(ActionEvent event){
        
        Object evt = event.getSource();
        
        if(evt.equals(loginBoton)){
            if(!loginUsuario.getText().equals("") && !loginContra.getText().equals("")){ 
                // Validacion para administrador
                if(loginUsuario.getText().equals("Admin") && loginContra.getText().equals("Admin123")){
                    loadStage("/Vistas/Administrador.fxml", event);
                    return;
                }
                for(int i = 0; i < Usuarios.size(); i++){
                    if(loginUsuario.getText().equals(Usuarios.get(i).getNombre()) && loginContra.getText().equals(Usuarios.get(i).getPassword())){
                        loadStage("/Vistas/Principal.fxml", event);
                        return;
                    }
                }
             } else if(loginUsuario.getText().equals("") && loginContra.getText().equals("")){
                 JOptionPane.showMessageDialog(null, "Campos vacios, por favor diligencie credenciales");
                 return;
            }
            JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrectos");
            System.out.println(loginContra.getText().equals("Admin123"));
        }
    }
    
    
    // Metodo para cambiar el color de la palabra registrate
    @FXML
    private void mouseEnter(MouseEvent event){
        Object evt = event.getSource();
        
        if(evt.equals(loginRegistrarse)){
            Paint p = Paint.valueOf("#8A94E0");
            loginRegistrarse.setTextFill(p);
        }
    }
    
    // Metodo para cambiar el color de la palabra registrate
    @FXML
    private void mouseExit(MouseEvent event){
        Object evt = event.getSource();
        
        if(evt.equals(loginRegistrarse)){
            Paint p = Paint.valueOf("#6c7beb");
            loginRegistrarse.setTextFill(p);
        }
    }
    
    @FXML
    private void mouseClicked(MouseEvent event){
        Object evt = event.getSource();
        
        if(evt.equals(loginRegistrarse)){
            loadStage("/Vistas/Registro.fxml", event);
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
    
}
