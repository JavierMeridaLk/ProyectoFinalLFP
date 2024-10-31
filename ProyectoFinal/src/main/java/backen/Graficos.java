package backen;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Graficos {

    public void generarGraficos(String texto) {
        System.out.println(texto);
        StringBuilder graph = new StringBuilder();
        graph.append("digraph G {\n");
        graph.append("    node [shape=box, fontname=\"Arial\"];\n");

        String[] lines = texto.split("\n");
        int counter = 1;
        String previousNode = null;
        int columnCount = 3;
        String result = "";

        for (String line : lines) {
            line = line.trim();

            // CREATE DATABASE
            if (line.startsWith("CREATE DATABASE")) {
                String dbName = line.split(" ")[2].replace(";", "");
                String nodeName = "node" + counter++;
                graph.append("    ").append(nodeName).append(" [label=\"CREATE DATABASE\\n")
                        .append(dbName).append("\"];\n");

                // CREATE TABLE
            } else if (line.startsWith("CREATE TABLE")) {

                int i = 0;
                String tableName = line.split(" ")[2];
                String nodeName = "node" + counter++;
                StringBuilder tableBlock = new StringBuilder();

                // Encabezado con tipo de acción y nombre de la tabla
                tableBlock.append("    ").append(nodeName).append(" [label=\"CREATE TABLE\\n")
                        .append(tableName).append("\\n\\n");

                // Procesa los atributos dentro del bloque CREATE TABLE
                if (line.contains("CREATE TABLE")) {
                    int startIndex = line.indexOf("(") + 1; // Encuentra el índice después del paréntesis de apertura
                    int endIndex = line.indexOf(";", startIndex) + 1; // Encuentra el índice después de la primera coma
                    result = line.substring(startIndex, endIndex).trim(); // Extrae el texto y elimina espacios
                }
                String[] separado = result.split(",");

                for (int j = 0; j < separado.length; j++) {
                    String string = separado[j];
                    if (string.contains("CREATE TABLE")) {
                        string = line.split(" ")[4];
                    }

                    if (separado[j].contains("PRIMARY KEY")) {
                        tableBlock.append(separado[j]).append("\\n");
                    } else if (separado[j].contains("NOT NULL")) {
                        tableBlock.append(separado[j]).append("\\n");
                    } else if (separado[j].contains("UNIQUE")) {
                        tableBlock.append(separado[j]).append("\\n");
                    } else if (separado[j].contains("CONSTRAINT") && separado[j].contains("FOREIGN KEY")) {
                        tableBlock.append(separado[j]).append("\\n");
                    } else if (!separado[j].contains(");")) {
                        // Agrega las columnas que no tienen restricciones especiales
                        tableBlock.append(separado[j]).append("\\n");
                    }
                }

                tableBlock.append("\"];\n");
                graph.append(tableBlock.toString());
            } else if (line.startsWith("ALTER TABLE")) {
                String[] parts = line.split(" ");
                String tableName = parts[2];
                String nodeName = "node" + counter++;
                StringBuilder alterBlock = new StringBuilder();
                alterBlock.append("    ").append(nodeName).append(" [label=\"ALTER TABLE\\n")
                        .append(tableName).append("\\n");

                if (line.contains("ADD COLUMN")) {
                    alterBlock.append("\\n ADD COLUMN ").append(parts[4]).append(" ").append(parts[5]);
                } else if (line.contains("ALTER COLUMN")) {
                    alterBlock.append("\\n ALTER COLUMN ").append(parts[4]).append(" TYPE ").append(parts[6]);
                } else if (line.contains("DROP COLUMN")) {
                    alterBlock.append("\\n DROP COLUMN ").append(parts[4]);
                } else if (line.contains("ADD CONSTRAINT")) {
                    alterBlock.append("\\n ADD CONSTRAINT ").append(parts[4]).append(" ").append(parts[5]);
                    if (line.contains("UNIQUE")) {
                        alterBlock.append(" UNIQUE (").append(parts[7]).append(")");
                    } else if (line.contains("FOREIGN KEY")) {
                        alterBlock.append(" FOREIGN KEY (").append(parts[7]).append(") REFERENCES ")
                                .append(parts[9]).append("(").append(parts[10]).append(")");
                    }
                }
                alterBlock.append("\"];\n");
                graph.append(alterBlock.toString());

                // DROP TABLE
            } else if (line.startsWith("DROP TABLE")) {
                String tableName = line.split(" ")[4].replace(";", "");
                String nodeName = "node" + counter++;
                graph.append("    ").append(nodeName).append(" [label=\"DROP TABLE\\n")
                        .append(tableName).append(" CASCADE\"];\n");
            }

            // Linking nodes in a sequence for layout
            if (counter > 1 && previousNode != null) {
                graph.append("    ").append(previousNode).append(" -> ").append("node" + (counter - 1))
                        .append(" [style=invis];\n");
            }
            previousNode = "node" + (counter - 1);
        }

        graph.append("}\n");

        // Write the .dot file
        try (FileWriter writer = new FileWriter("output.dot")) {
            writer.write(graph.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Archivo Graphviz generado como 'output.dot'. Puedes convertirlo usando Graphviz.");
        generarImagen();
    }

    private void generarImagen() {
        try {
            // Crea la carpeta "Graficas" si no existe
            File directorio = new File("Graficas");
            if (!directorio.exists()) {
                directorio.mkdir();
            }

            String imagenPath = "Graficas/Grafica DDL DB.png"; // Cambia el nombre de la imagen

            String[] command = {
                "dot", "-Tpng", "output.dot", "-o", imagenPath
            };
            Process process = new ProcessBuilder(command).start();
            process.waitFor();

            // Abre la imagen generada
            File imageFile = new File(imagenPath);
            if (imageFile.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(imageFile);
                } else {
                    System.out.println("No se puede abrir la imagen automáticamente. Archivo generado: " + imagenPath);
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
