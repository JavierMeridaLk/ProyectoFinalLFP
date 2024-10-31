/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backen;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author xavi
 */
public class Reportes {
    
    private Token token;
    private JTable table;
    private DefaultTableModel tableModel;
    
    public Reportes(){
        
    } 
    
     public JTable reporteErrorLexico(List<Token> errores) {
          String[] columnNames = {"Token", "Línea", "Columna", "Descripcion"};

        // Crear el modelo de la tabla
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

         
        // Llenar la tabla con los datos de los tokens
        for (Token token : errores) {
            Object[] row = {
                token.getToken(), // Aquí va el valor del token
                token.getLinea(), // Aquí la expresión regular
                token.getColumna(), // Aquí el lenguaje
                "Token no reconocido" // Aquí el tipo de token
            };
            tableModel.addRow(row);
        }
        return table;
     }
     
     public JTable reporteErrorSintactico(List<String> errores) {
          String[] columnNames = {"Declaracion", "Línea", "Columna", "Descripcion"};

        // Crear el modelo de la tabla
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

         
        // Llenar la tabla con los datos de los tokens
        for (String texto : errores) {
            Object[] row = {
                texto, // Aquí va el valor del token
                "", // Aquí la expresión regular
                "", // Aquí el lenguaje
                "Estructura invalida" // Aquí el tipo de token
            };
            tableModel.addRow(row);
        }
        return table;
     }
     
     public JTable reporteTablas(List<String> errores) {
          String[] columnNames = {"Nombre de Tabla:"};

        // Crear el modelo de la tabla
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

         
        // Llenar la tabla con los datos de los tokens
        for (String texto : errores) {
            Object[] row = {
                texto,
            };
            tableModel.addRow(row);
        }
        return table;
     }
     public JTable reporteModificaciones(List<String> errores) {
          String[] columnNames = {"Nombre de Tabla","Tipo de modificacion"};

        // Crear el modelo de la tabla
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

         
        // Llenar la tabla con los datos de los tokens
         for (int i = 0; i < errores.size(); i+=2) {
             
             Object[] row = {
                errores.get(i),
                errores.get(i+1),
            };
            tableModel.addRow(row);
         }
        
        return table;
     }
}
