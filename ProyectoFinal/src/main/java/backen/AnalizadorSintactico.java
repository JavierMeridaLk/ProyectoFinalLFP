/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backen;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author xavi
 */
public class AnalizadorSintactico {

    private List<String> sentencias = new ArrayList<>();
    private List<String> errores = new ArrayList<>();
    private List<String> reporteTablas = new ArrayList<>();
    private List<String> reporteModificaciones = new ArrayList<>();
    private List<String> graficas = new ArrayList<>();
    private String graficasTxt = "";

    public AnalizadorSintactico() {

    }

    public List<String> getGraficas() {
        return graficas;
    }

    public String getGraficasTxt() {
        return graficasTxt;
    }

    public List<String> getReporteTablas() {
        return reporteTablas;
    }

    public List<String> getReporteModificaciones() {
        return reporteModificaciones;
    }

    public List<String> getErrores() {
        return errores;
    }

    public void analizar(String textoAceptado) {
        separarTexto(textoAceptado);
        System.out.println("----Sentencias----");
        for (String sentencia : sentencias) {
            System.out.println("-- " + sentencia);
        }
        System.out.println("-------------------");

        for (String sentencia : sentencias) {
            if (esEstructuraCreacionDB(sentencia)) {
                System.out.println("Estructura correcta de creacion: " + sentencia);
                graficas.add(sentencia);
                graficasTxt = graficasTxt + sentencia + "\n";
            } else if (esEstructuraCreacionTablas(sentencia)) {
                System.out.println("Estructura correcta de creacion de tablas: " + sentencia);
                graficas.add(sentencia);
                graficasTxt = graficasTxt + sentencia + "\n";
            } else if (estructuraModificadores(sentencia)) {
                System.out.println("Estructura correcta de modificador " + sentencia);
                graficas.add(sentencia);
                graficasTxt = graficasTxt + sentencia + "\n";
            } else if (esInsercionValida(sentencia)) {
                System.out.println("Estructura correcta de insercion " + sentencia);
                //}else if (estructuraLectura(sentencia)) {
                //System.out.println("Estructura correcta de Lectura " + sentencia);
            } else if (estructuraActualizacion(sentencia)) {
                System.out.println("Estructura correcta de Actualizacion " + sentencia);
            } else if (estructuraEliminacion(sentencia)) {
                System.out.println("Estructura correcta de Eliminacion " + sentencia);
            } else {
                errores.add(sentencia);
            }
        }
    }

    private List<String> separarTexto(String texto) {

        String[] partes = texto.split(";"); // Dividir el texto en partes usando el punto y coma como delimitador
        for (String parte : partes) {
            if (!parte.trim().isEmpty()) { // Verificar que la parte no esté vacía
                sentencias.add(parte.trim() + ";"); // Agregar cada parte con el punto y coma al final
            }
        }

        return sentencias;
    }

    private ArrayList<String> separarPalabras(String texto) {
        ArrayList<String> palabras = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(texto, " ;", true);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!token.equals(" ")) { // Evita agregar espacios en blanco
                palabras.add(token);
            }
        }

        return palabras;
    }

    private boolean esEstructuraCreacionDB(String sentencia) {

        ArrayList<String> palabras = separarPalabras(sentencia);

        return (palabras.get(0).equals("CREATE") && palabras.get(1).equals("DATABASE") && palabras.get(3).equals(";"));

    }

    private boolean esEstructuraCreacionTablas(String sentencia) {
        boolean dentroParentesis = false;
        boolean esCorrecto = true;
        String declaracion = "";
        String llaves = "";
        String palabra = "";
        ArrayList<String> palabras = separarPalabras(sentencia);

        if (palabras.get(0).equals("CREATE") && palabras.get(1).equals("TABLE") && palabras.get(3).equals("(")
                && palabras.get(palabras.size() - 2).equals(")") && palabras.get(palabras.size() - 1).equals(";")) {

            for (int i = 4; i < palabras.size() - 2; i++) {
                palabra = palabras.get(i);

                if (palabra.equals("CONSTRAINT")) {
                    llaves = llaves + palabra + " " + palabras.get(i + 1);
                    esCorrecto = llavesValidad(llaves);
                    System.out.println("llave aceptada: " + llaves);
                    llaves = "";
                } else if (palabra.equals("FOREIGN") && palabras.get(i + 1).equals("KEY")) {
                    llaves = llaves + palabra + " " + palabras.get(i + 1) + " " + palabras.get(i + 2) + palabras.get(i + 3) + palabras.get(i + 4);
                    esCorrecto = llavesValidad(llaves);
                    System.out.println("llave aceptada: " + llaves);
                    llaves = "";
                } else if (palabra.equals("REFERENCES")) {
                    llaves = llaves + palabra + " " + palabras.get(i + 1) + palabras.get(i + 2) + palabras.get(i + 3) + palabras.get(i + 4);
                    esCorrecto = llavesValidad(llaves);
                    System.out.println("llave aceptada: " + llaves);
                    llaves = "";
                } else if (palabra.equals("(")) {
                    dentroParentesis = true;
                    declaracion += " " + palabra;
                } else if (palabra.equals(")")) {
                    dentroParentesis = false;
                    declaracion += " " + palabra;
                } else if (!palabra.equals(",")) {
                    // Agrega la palabra a la declaración si no es coma
                    declaracion += " " + palabra;
                } else if (dentroParentesis) {
                    // Agrega la coma a la declaración si estamos dentro de paréntesis
                    declaracion += palabra;
                } else {
                    // Si encontramos una coma fuera de paréntesis, se trata como delimitador
                    declaracion += " ,";
                    esCorrecto = declaracionValidad(declaracion);
                    declaracion = "";
                }
            }
            reporteTablas.add(palabras.get(2));
        } else {
            esCorrecto = false;
        }

        return esCorrecto;

    }

    private boolean declaracionValidad(String declaracion) {

        ArrayList<String> palabra = separarPalabras(declaracion);

        boolean esDato;
        if (palabra.get(1).equals("SERIAL") || palabra.get(1).equals("INTEGER") || palabra.get(1).equals("BIGINT") || palabra.get(1).equals("VARCHAR")
                || palabra.get(1).equals("DECIMAL") || palabra.get(1).equals("NUMERIC") || palabra.get(1).equals("DATE") || palabra.get(1).equals("TEXT")
                || palabra.get(1).equals("BOOLEAN")) {

            if (palabra.get(1).equals("VARCHAR") && palabra.get(2).equals("(") && palabra.get(4).equals(")")) {
                esDato = true;
            } else if (palabra.get(1).equals("DECIMAL") || palabra.get(1).equals("NUMERIC") && palabra.get(2).equals("(") && palabra.get(5).equals(")")) {
                esDato = true;
            }
            esDato = true;
        } else {
            esDato = false;
        }

        if (esDato && palabra.get(palabra.size() - 1).equals(",")) {
            System.out.println("Declaración aceptada: " + declaracion);
            return true;
        } else {

            return false;
        }
    }

    private boolean llavesValidad(String llaves) {
        ArrayList<String> palabra = separarPalabras(llaves);
        int c = 0;
        if (palabra.get(0).equals("CONSTRAINT") && palabra.size() == 2) {
            return true;
        } else if (palabra.get(0).equals("FOREIGN") && palabra.get(1).equals("KEY") && palabra.size() == 3) {
            for (int i = 0; i < palabra.get(2).length(); i++) {
                if (palabra.get(2).charAt(i) == '(' || palabra.get(2).charAt(i) == ')') {
                    c++;
                }
            }
            if (c == 2) {
                return true;
            } else {
                return false;
            }
        } else if (palabra.get(0).equals("REFERENCE") && palabra.size() == 2) {
            for (int i = 0; i < palabra.get(1).length(); i++) {
                if (palabra.get(2).charAt(i) == '(' || palabra.get(2).charAt(i) == ')') {
                    c++;
                }
            }
            if (c == 2) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean estructuraModificadores(String modificadores) {

        ArrayList<String> palabra = separarPalabras(modificadores);

        if (palabra.get(0).equals("ALTER") && palabra.get(1).equals("TABLE") && palabra.get(palabra.size() - 1).equals(";")) {

            if (palabra.get(3).equals("ADD")) {

                if (palabra.get(4).equals("COLUMN") && esDato(palabra, 6)) {
                    reporteModificaciones.add(palabra.get(2));
                    reporteModificaciones.add(palabra.get(0) + " " + palabra.get(1) + " " + palabra.get(3) + " " + palabra.get(4));
                    return true;
                } else if (palabra.get(4).equals("CONSTRAINT") && palabra.get(6).equals("FOREIGN") && palabra.get(7).equals("KEY") && palabra.get(11).equals("REFERENCES") && palabra.get(13).equals("(") && palabra.get(15).equals(")")) {
                    reporteModificaciones.add(palabra.get(2));
                    reporteModificaciones.add(palabra.get(0) + " " + palabra.get(1) + " " + palabra.get(3) + " " + palabra.get(4) + " " + palabra.get(6) + " " + palabra.get(7) + " " + palabra.get(9));
                    return true;
                } else if (palabra.get(4).equals("CONSTRAINT") && palabra.get(6).equals("UNIQUE") && palabra.get(7).equals("(") && palabra.get(9).equals(")")) {
                    reporteModificaciones.add(palabra.get(2));
                    reporteModificaciones.add(palabra.get(0) + " " + palabra.get(1) + " " + palabra.get(3) + " " + palabra.get(4) + " " + palabra.get(6));
                    return true;
                } else if (palabra.get(4).equals("CONSTRAINT") && esDato(palabra, 6)) {
                    reporteModificaciones.add(palabra.get(2));
                    reporteModificaciones.add(palabra.get(0) + " " + palabra.get(1) + " " + palabra.get(3) + " " + palabra.get(4));
                    return true;
                }
            } else if (palabra.get(3).equals("DROP") && palabra.get(4).equals("COLUMN") && palabra.size() == 7) {
                reporteModificaciones.add(palabra.get(2));
                reporteModificaciones.add(palabra.get(0) + " " + palabra.get(1) + " " + palabra.get(3) + " " + palabra.get(4));
                return true;
            } else if (palabra.get(3).equals("ALTER") && palabra.get(4).equals("COLUMN") && palabra.get(6).equals("TYPE") && esDato(palabra, 7)) {
                reporteModificaciones.add(palabra.get(2));
                reporteModificaciones.add(palabra.get(0) + " " + palabra.get(1) + " " + palabra.get(3) + " " + palabra.get(4) + " " + palabra.get(6));
                return true;
            }

        } else if (palabra.get(0).equals("DROP") && palabra.get(1).equals("TABLE") && palabra.get(2).equals("IF")
                && palabra.get(3).equals("EXIST") && palabra.get(5).equals("CASCADE") && palabra.get(6).equals(";")) {
            reporteModificaciones.add(palabra.get(4));
            reporteModificaciones.add(palabra.get(0) + " " + palabra.get(1) + " " + palabra.get(2) + " " + palabra.get(3) + " " + palabra.get(5));
            return true;
        } else {

            System.out.println("no aceptado");
            return false;
        }
        return true;

    }

    private boolean esDato(ArrayList palabra, int posicion) {

        if (palabra.get(posicion).equals("SERIAL") || palabra.get(posicion).equals("INTEGER") || palabra.get(posicion).equals("BIGINT")
                || palabra.get(posicion).equals("VARCHAR") || palabra.get(posicion).equals("DECIMAL") || palabra.get(posicion).equals("NUMERIC")
                || palabra.get(posicion).equals("DATE") || palabra.get(posicion).equals("TEXT") || palabra.get(posicion).equals("BOOLEAN")) {

            if (palabra.get(posicion).equals("VARCHAR") && palabra.get(posicion + 1).equals("(") && palabra.get(posicion + 2).equals(")")) {
                return true;
            } else if (palabra.get(posicion).equals("DECIMAL") || palabra.get(posicion).equals("NUMERIC") && palabra.get(posicion + 1).equals("(")
                    && palabra.get(posicion + 3).equals(")")) {
                return true;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean esInsercionValida(String sentencia) {
        // Separamos la sentencia en palabras
        List<String> palabras = separarPalabras(sentencia);
        System.out.println("insercion");
        for (String palabra : palabras) {
            System.out.println("--" + palabra);
        }

        // Verifica que la sentencia inicie con "INSERT INTO"
        if (!palabras.get(0).equalsIgnoreCase("INSERT") || !palabras.get(1).equalsIgnoreCase("INTO") || !palabras.get(palabras.size() - 1).equalsIgnoreCase(";")) {
            return false;
        }

        // Verificar que haya un nombre de tabla después de "INSERT INTO"
        String nombreTabla = palabras.get(2);
        if (nombreTabla.isEmpty() || nombreTabla.equals("(")) {
            return false;
        }
        boolean dentroParentesis = false;
        boolean cambiaParentesis = false;

        String parentesis = "";
        String parentesis2 = "";

        for (int i = 3; i < palabras.size(); i++) {
            if (palabras.get(i).equals("VALUES")) {
                cambiaParentesis = true;
                dentroParentesis = false;
            } else if (!cambiaParentesis && palabras.get(i).equals("(")) {
                dentroParentesis = true;
                parentesis = parentesis + palabras.get(i);
            } else if (cambiaParentesis && palabras.get(i).equals("(")) {
                dentroParentesis = true;
                parentesis2 = parentesis2 + palabras.get(i);
            } else if (!cambiaParentesis && palabras.get(i).equals(")")) {
                dentroParentesis = false;
                parentesis = parentesis + palabras.get(i);
            } else if (cambiaParentesis && palabras.get(i).equals(")")) {
                dentroParentesis = false;
                parentesis2 = parentesis2 + palabras.get(i);
            } else if (dentroParentesis && !cambiaParentesis) {
                parentesis = parentesis + " " + palabras.get(i);
            } else if (dentroParentesis && cambiaParentesis) {
                parentesis2 = parentesis2 + " " + palabras.get(i);
            }
        }
        if (parentesis.isEmpty() || parentesis2.isEmpty()) {
            System.out.println("malo");
            return false;
        } else {
            List<String> palabrasParentesis1 = separarPorComa(parentesis);
            List<String> palabrasParentesis2 = separarPorComa(parentesis2);

            return palabrasParentesis1.size() != palabrasParentesis2.size();
        }

    }

    private List<String> separarPorComa(String texto) {
        String[] partes = texto.split(",");
        List<String> resultado = new ArrayList<>();

        for (String parte : partes) {
            // Elimina paréntesis y espacios en blanco alrededor de cada parte
            resultado.add(parte.replace("(", "").replace(")", "").trim());
        }

        return resultado;
    }

    private boolean estructuraActualizacion(String sentencia) {
        List<String> palabras = separarPalabras(sentencia);
        String despuesDeSET = "";
        String despuesDeWHERE = "";
        boolean set = false;
        boolean where = false;
        if (palabras.get(0).equals("UPDATE") && palabras.get(palabras.size() - 1).equals(";") && palabras.get(2).equals("SET")) {
            for (int i = 0; i < palabras.size(); i++) {

                if (palabras.get(i).equals("SET")) {
                    set = true;
                    where = false;
                } else if (palabras.get(i).equals("WHERE")) {
                    where = true;
                    set = false;
                } else if (set) {
                    despuesDeSET = despuesDeSET + " " + palabras.get(i);
                } else if (where) {
                    despuesDeWHERE = despuesDeWHERE + " " + palabras.get(i);
                }
            }

            List<String> palabrasSet = separarPorComa(despuesDeSET);
            List<String> palabrasWhere = separarPorComa(despuesDeWHERE);

            if (palabrasSet.isEmpty()) {
                return false;
            } else {

                int c = 0;
                boolean valido = false;

                for (String string : palabrasSet) {
                    if (string == null || string.trim().isEmpty()) {
                        c = 0; // Devuelve 0 si el texto es nulo o vacío
                    }
                    // Divide el texto en palabras usando una expresión regular que considera espacios en blanco
                    String[] palabras2 = string.trim().split("\\s+");

                    System.out.println(palabras2.length);
                    c = palabras2.length;

                }

                if (palabrasWhere.equals("")) {
                    valido = false;
                } else {
                    valido = true;
                }
                if (c % 4 == 0) {
                    valido = true;
                } else {
                    valido = false;
                }

                return valido;
            }

        } else {
            return false;
        }
    }

    private boolean estructuraEliminacion(String sentencia) {
        List<String> palabras = separarPalabras(sentencia);

        if (palabras.get(0).equals("DELETE") && palabras.get(1).equals("FROM") && palabras.get(palabras.size() - 1).equals(";")) {

            if (palabras.size() == 4) {
                return true;
            } else if (palabras.get(3).equals("WHERE")) {
                return true;
            }
        }

        return false;
    }

}
