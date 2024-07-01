package proyectofinal;

import Classes.Archivos;
import Classes.Structures.Cola;
import Classes.Usuario;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProyectoFinal extends Application {
    
    public static ArrayList<Usuario> Usuarios = new ArrayList<>();
    public static Cola Productos = new Cola();
    public static Stage sFinal = new Stage();
    public static Usuario uActivo;
    Archivos ar = new Archivos();

    @Override
    public void start(Stage stage) throws Exception {
        ar.leerProductos();
        ar.leerUsuarios();

        Parent root = FXMLLoader.load(getClass().getResource("/Vistas/Login.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
