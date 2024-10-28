/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backen;

/**
 *
 * @author xavi
 */
public class Token {
   
    private String token;
    private int linea;
    private int columna;
    private String tipo;
    private int inicio;
    
    public Token(String token, int linea, int columna, String tipo, int inicio) {
        this.token = token;
        this.linea = linea;
        this.columna = columna;
        this.tipo = tipo;
        this.inicio = inicio;
    }



    public String getToken() {
        return token;
    }

    public void setToken(String texto) {
        this.token = texto;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int line) {
        this.linea = line;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int column) {
        this.columna = column;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }
    
    
}
