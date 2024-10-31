/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

/**
 *
 * @author xavi
 */
public class Archivos {
    private String nombreDelArchivo;
    
    public Archivos(){
        
    }
    
    public void leer(JTextPane text){
        //usa un bufferReader para leer el texto e insertarlo en panelText
        File archivo = abrirChose();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            
            String line;
            StringBuilder content = new StringBuilder();
            
            while ((line = reader.readLine()) != null) {
                
                content.append(line).append("\n");
            }
            
            text.setText(content.toString());
            
        } catch (IOException e) {
            
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: ", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }   
    public File abrirChose(){
        //abrir el chose y guardar el archivo para leerlo en otro metodo
        JFileChooser fileChooser = new JFileChooser();
         
        int seleccion = fileChooser.showOpenDialog(null);
    
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            
            File archivo = fileChooser.getSelectedFile();
            nombreDelArchivo= archivo.getName();
            return archivo;
        } else {    
            JOptionPane.showMessageDialog(null, "No se seleccionó ningún archivo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    
        return null;
    }
    
    public void guardarTextoEnArchivo(String texto, String nombreArchivo) {
        String carpetaDestino = "Archivos de texto"; // Nombre de la carpeta
        File directorio = new File(carpetaDestino);
        
        // Crear la carpeta si no existe
        if (!directorio.exists()) {
            directorio.mkdir();
        }

        // Ruta completa del archivo dentro de la carpeta
        File archivo = new File(directorio, nombreArchivo);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write(texto);
            JOptionPane.showMessageDialog(null, "Archivo guardado exitosamente en: " + archivo.getAbsolutePath(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
public void guardarComo(JTextPane text) {
    // Crear un JFileChooser para seleccionar el archivo de destino
    JFileChooser fileChooser = new JFileChooser();

    // Establecer la carpeta de inicio donde están los archivos guardados
    File carpetaDeGuardado = new File("Archivos de texto"); // Cambia esto al directorio deseado
    if (!carpetaDeGuardado.exists()) {
        carpetaDeGuardado.mkdir(); // Crea la carpeta si no existe
    }
    fileChooser.setCurrentDirectory(carpetaDeGuardado);

    fileChooser.setDialogTitle("Guardar como");
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

    // Filtrar para que solo se puedan seleccionar archivos de texto
    fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos de texto (*.txt)", "txt"));

    int userSelection = fileChooser.showSaveDialog(null);

    // Si el usuario selecciona un archivo y confirma
    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File archivoSeleccionado = fileChooser.getSelectedFile();

        // Asegurarse de que el archivo tenga la extensión ".txt"
        if (!archivoSeleccionado.getName().toLowerCase().endsWith(".txt")) {
            archivoSeleccionado = new File(archivoSeleccionado.getAbsolutePath() + ".txt");
        }

        // Guardar el texto en el archivo seleccionado
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoSeleccionado))) {
            writer.write(text.getText());
            JOptionPane.showMessageDialog(null, "Archivo guardado exitosamente en: " + archivoSeleccionado.getAbsolutePath(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
    
    
}
