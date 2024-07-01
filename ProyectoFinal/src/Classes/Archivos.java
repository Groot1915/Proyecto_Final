package Classes;

import Classes.Structures.Cola;
import java.io.*;
import java.util.ArrayList;
import static proyectofinal.ProyectoFinal.Usuarios;
import static proyectofinal.ProyectoFinal.Productos;

public class Archivos {

    public void escribirUsuarios() throws FileNotFoundException, IOException{
        File file = new File("/home/juan/NetBeansProjects/ProyectoFinal/src/Archivos/Usuarios.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(Usuarios);
        oos.close();
        System.out.println("Archivo Usuario escrito correctamente");
    }
    
    public void leerUsuarios() throws FileNotFoundException, IOException, ClassNotFoundException{
        File file = new File("/home/juan/NetBeansProjects/ProyectoFinal/src/Archivos/Usuarios.txt");
        ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(file));
        Usuarios = (ArrayList<Usuario>)ois.readObject();
        ois.close();
        System.out.println("Archivo Usuario leido correctamente");
    }
    
    public void escribirProductos() throws FileNotFoundException, IOException{
        File file = new File("/home/juan/NetBeansProjects/ProyectoFinal/src/Archivos/Productos.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(Productos);
        oos.close();
        System.out.println("Archivo Productos escrito correctamente");
    }
    
    public void leerProductos() throws FileNotFoundException, IOException, ClassNotFoundException{
        File file = new File("/home/juan/NetBeansProjects/ProyectoFinal/src/Archivos/Productos.txt");
        ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(file));
        Productos = (Cola)ois.readObject();
        ois.close();
        System.out.println("Archivo Productos leido correctamente");
    }
      
}
