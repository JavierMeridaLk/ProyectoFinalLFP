/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fronted;

import backen.AnalizadorLexico;
import backen.AnalizadorSintactico;
import backen.Archivos;
import backen.Graficos;
import backen.Reportes;
import backen.Token;
import java.awt.Color;
import java.io.StringReader;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author xavi
 */
public class FramePrincipal extends javax.swing.JFrame {

    private List<Token> tokenCreate;
    private List<Token> tokenTipoDato;
    private List<Token> tokenEntero;
    private List<Token> tokenDecimal;
    private List<Token> tokenFecha;
    private List<Token> tokenCadena;
    private List<Token> tokenIdentificador;
    private List<Token> tokenBooleano;
    private List<Token> tokenFuncionDeAgregacion;
    private List<Token> tokenSignos;
    private List<Token> tokenAritmeticos;
    private List<Token> tokenRacionales;
    private List<Token> tokenLogicos;
    private List<Token> tokenComentarios;
    private List<Token> tokenError;
    private List<String> erroresSintacticos;
    private List<String> reportesDeTablas;
    private List<String> reportesDeModificaciones;
    private String graficosTxt;
    private int create;
    private int delete;
    private int update;
    private int select;
    private int alter;

    private boolean lexicoCorrecto;

    /**
     * Creates new form FramePrincipal
     */
    public FramePrincipal() {
        //limpiar();
        initComponents();
        this.setSize(1100, 700);
        this.setTitle("Analizador SQL");
        jTextPaneFilas.setEditable(false);
        jTextPaneFilas.setEnabled(false);
        jTextPaneTexto.setEnabled(false);
        jTextPaneFilas.setForeground(Color.LIGHT_GRAY);
        buttonAnalizar.setEnabled(false);
        this.setLocationRelativeTo(null);

        jTextPaneTexto.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarConteoLineas();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarConteoLineas();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarConteoLineas();
            }

            // Método para actualizar el contador de líneas
            private void actualizarConteoLineas() {
                if (!jTextPaneTexto.getText().isEmpty()) {
                    buttonAnalizar.setEnabled(true);

                } else {
                    buttonAnalizar.setEnabled(false);

                }

                int lineCount = jTextPaneTexto.getDocument().getDefaultRootElement().getElementCount();  // Obtener el número de líneas
                String textoFinal = "";

                for (int i = 0; i < lineCount; i++) {
                    textoFinal = textoFinal + String.valueOf((i + 1) + "\n");
                }
                jTextPaneFilas.setText(textoFinal);
            }
        });

        jTextPaneTexto.addCaretListener(e -> {
            int dot = e.getDot(); // Posición del cursor
            try {
                // Obtener el documento
                JTextPane textPane1 = (JTextPane) e.getSource();
                StyledDocument doc = textPane1.getStyledDocument();
                // Obtener la ubicación de la posición del cursor
                Element element = doc.getDefaultRootElement();
                int line = element.getElementIndex(dot); // Fila
                int column = dot - element.getElement(line).getStartOffset(); // Columna
                // Actualizar la etiqueta con la posición
                columnaLabel.setText(String.valueOf(column));
                filaLabel.setText(String.valueOf(line + 1));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneTexto = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPaneFilas = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        filaLabel = new javax.swing.JLabel();
        columnaLabel = new javax.swing.JLabel();
        buttonAnalizar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(null);

        jLabel1.setFont(new java.awt.Font("Courier 10 Pitch", 0, 36)); // NOI18N
        jLabel1.setText("ANALIZADOR SQL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(379, 379, 379)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBorder(null);

        jScrollPane1.setViewportView(jTextPaneTexto);

        jScrollPane2.setViewportView(jTextPaneFilas);

        jLabel2.setFont(new java.awt.Font("Courier 10 Pitch", 0, 15)); // NOI18N
        jLabel2.setText("Fila:");

        jLabel3.setFont(new java.awt.Font("Courier 10 Pitch", 0, 15)); // NOI18N
        jLabel3.setText(", Columna: ");

        filaLabel.setFont(new java.awt.Font("Courier 10 Pitch", 0, 15)); // NOI18N

        columnaLabel.setFont(new java.awt.Font("Courier 10 Pitch", 0, 15)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 999, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(columnaLabel)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(columnaLabel)
                    .addComponent(jLabel3)
                    .addComponent(filaLabel)
                    .addComponent(jLabel2)))
        );

        buttonAnalizar.setFont(new java.awt.Font("Courier 10 Pitch", 0, 18)); // NOI18N
        buttonAnalizar.setText("ANALIZAR");
        buttonAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnalizarActionPerformed(evt);
            }
        });

        jMenu1.setText("Archivo");

        jMenuItem5.setText("Cargar Archivo");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Crear Archivo");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem7.setText("Guardar Archivo");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem8.setText("Guardar como...");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Graficos");

        jMenuItem11.setText("Generar Graficos");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem11);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Reportes");

        jMenuItem2.setText("Reporte Lexico");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setText("Reporte Sintactico´");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setText("Reporte de Tablas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem9.setText("Tablas modificadas");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuItem10.setText("Numero de operaciones");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAnalizar)
                .addGap(2, 2, 2)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        reportesErrorSintacticos reporte = new reportesErrorSintacticos(this, true);
        Reportes reporte1 = new Reportes();
        reporte.subirTabla(reporte1.reporteErrorSintactico(erroresSintacticos));
        reporte.setVisible(true);

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        reportesTablas reporte = new reportesTablas(this, true);
        Reportes reporte1 = new Reportes();
        reporte.subirTabla(reporte1.reporteTablas(reportesDeTablas));
        reporte.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void buttonAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAnalizarActionPerformed
        // TODO add your handling code here:
        analizar();
    }//GEN-LAST:event_buttonAnalizarActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        limpiar();
        jTextPaneTexto.setEnabled(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        Archivos archivo = new Archivos();
        archivo.leer(jTextPaneTexto);
        jTextPaneTexto.setEnabled(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        Archivos archivo = new Archivos();
        String nombreArchivo = JOptionPane.showInputDialog(null, "Ingrese el nombre del archivo:", "Nombre del Archivo", JOptionPane.PLAIN_MESSAGE);
        archivo.guardarTextoEnArchivo(jTextPaneTexto.getText(), nombreArchivo + ".txt");
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:

        Archivos archivo = new Archivos();
        archivo.guardarComo(jTextPaneTexto);

    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        reportesErrorToken reporte = new reportesErrorToken(this, true);
        Reportes reporte1 = new Reportes();
        reporte.subirTabla(reporte1.reporteErrorLexico(tokenError));
        reporte.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        reportesModificaciones reporte = new reportesModificaciones(this, true);
        Reportes reporte1 = new Reportes();
        reporte.subirTabla(reporte1.reporteModificaciones(reportesDeModificaciones));
        reporte.setVisible(true);

    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        Graficos graficos = new Graficos();
        graficos.generarGraficos(graficosTxt);

    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        reportesOperaciones reporte = new reportesOperaciones(this, true);
        Reportes reporte1 = new Reportes();
        reporte.subirTabla(reporte1.reporteOperaciones(create, delete, update, select, alter));
        reporte.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void limpiar() {
        //metodo para limpiar componentes

        columnaLabel.setText("");
        filaLabel.setText("");
        buttonAnalizar.setEnabled(false);
        jTextPaneFilas.setText("");
        jTextPaneTexto.setText("");

    }

    public void analizar() {
        String entrada = jTextPaneTexto.getText();
        AnalizadorLexico analizadorLexico = new AnalizadorLexico(new StringReader(entrada));

        try {
            StyledDocument doc = jTextPaneTexto.getStyledDocument();

            // Definición de los colores
            SimpleAttributeSet azul = new SimpleAttributeSet();
            StyleConstants.setForeground(azul, Color.BLUE);

            SimpleAttributeSet verde = new SimpleAttributeSet();
            StyleConstants.setForeground(verde, Color.GREEN);

            SimpleAttributeSet morado = new SimpleAttributeSet();
            StyleConstants.setForeground(morado, new Color(75, 0, 130));

            SimpleAttributeSet naranja = new SimpleAttributeSet();
            StyleConstants.setForeground(naranja, Color.ORANGE);

            SimpleAttributeSet amarillo = new SimpleAttributeSet();
            StyleConstants.setForeground(amarillo, Color.YELLOW);

            // Nuevo color fucsia
            SimpleAttributeSet fucsia = new SimpleAttributeSet();
            StyleConstants.setForeground(fucsia, new Color(255, 0, 255)); // Fucsia (RGB: 255, 0, 255)

            SimpleAttributeSet negro = new SimpleAttributeSet();
            StyleConstants.setForeground(negro, Color.BLACK);

            SimpleAttributeSet gris = new SimpleAttributeSet();
            StyleConstants.setForeground(gris, Color.GRAY);

            // Limpiar estilos previos
            doc.setCharacterAttributes(0, entrada.length(), new SimpleAttributeSet(), true);

            // Analiza el texto y llena las listas de tokens
            while (analizadorLexico.yylex() != AnalizadorLexico.YYEOF) {
            }

            // Obtener listas de tokens
            tokenCreate = analizadorLexico.getTokenCreate();
            tokenTipoDato = analizadorLexico.getTokenTipoDato();
            tokenEntero = analizadorLexico.getTokenEntero();
            tokenDecimal = analizadorLexico.getTokenDecimal();
            tokenFecha = analizadorLexico.getTokenFecha();
            tokenCadena = analizadorLexico.getTokenCadena();
            tokenIdentificador = analizadorLexico.getTokenIdentificador();
            tokenBooleano = analizadorLexico.getTokenBooleano();
            tokenFuncionDeAgregacion = analizadorLexico.getTokenFuncionDeAgregacion();
            tokenSignos = analizadorLexico.getTokenSignos();
            tokenAritmeticos = analizadorLexico.getTokenAritmeticos();
            tokenRacionales = analizadorLexico.getTokenRacionales();
            tokenLogicos = analizadorLexico.getTokenLogicos();
            tokenComentarios = analizadorLexico.getTokenComentarios();
            tokenError = analizadorLexico.getTokenErrores();

            // Aplicar los colores correspondientes
            pintarTokens(tokenCreate, naranja, doc);
            pintarTokens(tokenTipoDato, morado, doc);
            pintarTokens(tokenEntero, azul, doc);
            pintarTokens(tokenDecimal, azul, doc);
            pintarTokens(tokenFecha, amarillo, doc);
            pintarTokens(tokenCadena, verde, doc);
            pintarTokens(tokenIdentificador, fucsia, doc);
            pintarTokens(tokenBooleano, azul, doc);
            pintarTokens(tokenFuncionDeAgregacion, azul, doc);
            pintarTokens(tokenSignos, negro, doc);
            pintarTokens(tokenAritmeticos, negro, doc);
            pintarTokens(tokenRacionales, negro, doc);
            pintarTokens(tokenLogicos, naranja, doc);
            pintarTokens(tokenComentarios, gris, doc);

            // Manejo de errores
            List<Token> listaErrores = analizadorLexico.getTokenErrores();
            if (!listaErrores.isEmpty()) {
                lexicoCorrecto = false;
                for (Token error : listaErrores) {
                    System.out.println(error);
                }
                //} else {
                //    lexicoCorrecto = true;
                //    AnalizadorSintactico anal = new AnalizadorSintactico();
                //    anal.procesarEstructuras(entrada, tokenCreate, tokenIdentificador, tokenTipoDato, tokenSignos, tokenEntero, tokenAritmeticos, tokenLogicos, tokenCadena, tokenFecha, tokenDecimal, tokenRacionales);
            }

            AnalizadorSintactico analizadorSintactico = new AnalizadorSintactico();
            analizadorSintactico.analizar(analizadorLexico.getTextoAceptado());
            erroresSintacticos = analizadorSintactico.getErrores();
            reportesDeTablas = analizadorSintactico.getReporteTablas();
            reportesDeModificaciones = analizadorSintactico.getReporteModificaciones();
            graficosTxt = analizadorSintactico.getGraficasTxt();
            create = analizadorSintactico.getNumeroDeCreate();
            delete = analizadorSintactico.getNumeroDeDelete();
            update = analizadorSintactico.getNumeroDeUpdate();
            select = analizadorSintactico.getNumeroDeSelect();
            alter = analizadorSintactico.getNumeroDeAlter();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("-----texto aceptado----");

        System.out.println(analizadorLexico.getTextoAceptado());

        System.out.println("--------------------------");
    }

    private void pintarTokens(List<Token> tokens, SimpleAttributeSet estilo, StyledDocument doc) {
        try {
            String text = doc.getText(0, doc.getLength());  // Obtener todo el texto del documento

            for (Token token : tokens) {
                int start = calcularPosicionInicial(token, text);  // Calcular la posición inicial basándose en line y column
                int length = token.getToken().length();  // Longitud del token

                // Asegurarse de que la longitud no sea 0 y la posición es válida
                if (start >= 0 && length > 0) {
                    doc.setCharacterAttributes(start, length, estilo, true);  // Aplica el estilo al token completo
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para calcular la posición inicial en el documento a partir de las
     * líneas y columnas del token.
     */
    private int calcularPosicionInicial(Token token, String texto) {
        int line = token.getLinea();   // Obtener la línea del token
        int column = token.getColumna();  // Obtener la columna del token
        int pos = 0;  // Posición inicial en el texto (que empezará en 0)

        // Recorremos el texto línea por línea hasta alcanzar la línea deseada
        int currentLine = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (currentLine == line) {
                // Si estamos en la línea correcta, la posición es la columna en esa línea
                pos = i + column;
                break;
            }

            // Si encontramos un salto de línea, incrementamos el contador de líneas
            if (texto.charAt(i) == '\n') {
                currentLine++;
            }
        }

        return pos;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAnalizar;
    private javax.swing.JLabel columnaLabel;
    private javax.swing.JLabel filaLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPaneFilas;
    private javax.swing.JTextPane jTextPaneTexto;
    // End of variables declaration//GEN-END:variables
}