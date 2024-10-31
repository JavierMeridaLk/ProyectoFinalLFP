package backen;

import java.util.ArrayList;
import java.util.List;

%%

%{

private List<Token> tokenCreate = new ArrayList<>();
private List<Token> tokenTipoDato = new ArrayList<>();
private List<Token> tokenEntero = new ArrayList<>();
private List<Token> tokenDecimal = new ArrayList<>();
private List<Token> tokenFecha = new ArrayList<>();
private List<Token> tokenCadena = new ArrayList<>();
private List<Token> tokenIdentificador = new ArrayList<>();
private List<Token> tokenBooleano = new ArrayList<>();
private List<Token> tokenFuncionDeAgregacion = new ArrayList<>();
private List<Token> tokenSignos = new ArrayList<>();
private List<Token> tokenAritmeticos = new ArrayList<>();
private List<Token> tokenRacionales = new ArrayList<>();
private List<Token> tokenLogicos = new ArrayList<>();
private List<Token> tokenComentarios = new ArrayList<>();
private List<Token> tokenErrores = new ArrayList<>();
private List<List<Token>> listaTokens = new ArrayList();
private String textoAceptado = "";

public String getTextoAceptado() {
    return textoAceptado;
}

public List<Token> getTokenCreate() {
    return tokenCreate;
}

public List<Token> getTokenTipoDato() {
    return tokenTipoDato;
}

public List<Token> getTokenEntero() {
    return tokenEntero;
}

public List<Token> getTokenDecimal() {
    return tokenDecimal;
}

public List<Token> getTokenFecha() {
    return tokenFecha;
}

public List<Token> getTokenCadena() {
    return tokenCadena;
}

public List<Token> getTokenIdentificador() {
    return tokenIdentificador;
}

public List<Token> getTokenBooleano() {
    return tokenBooleano;
}

public List<Token> getTokenFuncionDeAgregacion() {
    return tokenFuncionDeAgregacion;
}

public List<Token> getTokenSignos() {
    return tokenSignos;
}

public List<Token> getTokenAritmeticos() {
    return tokenAritmeticos;
}

public List<Token> getTokenRacionales() {
    return tokenRacionales;
}

public List<Token> getTokenLogicos() {
    return tokenLogicos;
}

public List<Token> getTokenComentarios() {
    return tokenComentarios;
}

public List<Token> getTokenErrores() {
    return tokenErrores;
}

public List<List<Token>> getListaTokens() {
    return listaTokens;
}

public void anañirTextoAceptado(String token) {
        textoAceptado = textoAceptado + token + " ";
}

public void anañirTokenCreate(String token) {
        tokenCreate.add(new Token(token, yyline , yycolumn , "CREATE",yychar));
}

public void anañirTokenTipoDeDato(String token) {
        tokenTipoDato.add(new Token(token,yyline , yycolumn , "TIPO DE DATO",yychar));
}

public void anañirTokenEntero(String token) {
        tokenEntero.add(new Token(token, yyline, yycolumn,"ENTERO",yychar));
}

public void anañirTokenDecimal(String token){
        tokenDecimal.add(new Token(token, yyline , yycolumn , "DECIMAL",yychar));
}

public void anañirTokenFecha(String token){
        tokenFecha.add(new Token(token, yyline , yycolumn , "FECHA",yychar));
}

public void anañirTokenCadena(String token){
        tokenCadena.add(new Token(token, yyline , yycolumn , "CADENA",yychar));
}

public void anañirTokenIdentificador(String token){
        tokenIdentificador.add(new Token(token, yyline , yycolumn , "IDENTIFICADOR",yychar));
}

public void anañirTokenBooleano(String token){
        tokenBooleano.add(new Token(token, yyline , yycolumn , "BOOLEANO",yychar));
}

public void anañirTokenAgregacion(String token){
        tokenFuncionDeAgregacion.add(new Token(token, yyline , yycolumn , "FUNCION DE AGREGACION",yychar));
}

public void anañirTokenSignos(String token){
        tokenSignos.add(new Token(token, yyline , yycolumn , "SIGNOS",yychar));
}

public void anañirTokenAritmeticos(String token){
        tokenAritmeticos.add(new Token(token, yyline , yycolumn , "ARITMETICOS",yychar));
}

public void anañirTokenRacionales(String token){
        tokenRacionales.add(new Token(token, yyline , yycolumn , "RACIONALES",yychar));
}

public void anañirTokenLogicos(String token){
        tokenLogicos.add(new Token(token, yyline , yycolumn , "LOGICOS",yychar));
}

public void anañirTokenComentarios(String token){
        tokenComentarios.add(new Token(token, yyline , yycolumn , "COMENTARIOS",yychar));
}

public void anañirTokenErrores(String token){
        tokenErrores.add(new Token(token, yyline , yycolumn , "ERROR",yychar));
}

public void addListaTokens(List<Token> lista){
        listaTokens.add(lista);
}


%}

%public
%class AnalizadorLexico
%unicode
%line
%column
%standalone

ENTERO = [0-9]+
ESPACIO = [ \r\t\n]+
FECHA = \'(\d{4})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])\'
IDENTIFICADOR = [a-z0-9]+(_[a-z0-9]+)*
CADENA = \'[^\']*\' 
COMENTARIO = "--" [\t\n\r\f ]+ [^\n\r]*
ESPACIOS = [" "\r\t\b\n]

%%
{ESPACIOS}          {}
{ENTERO}            { anañirTokenEntero(yytext()); anañirTextoAceptado(yytext());}
{ENTERO}.{ENTERO}   { anañirTokenDecimal(yytext()); anañirTextoAceptado(yytext());}
{FECHA}             { anañirTokenFecha(yytext()); anañirTextoAceptado(yytext());}
{CADENA}            { anañirTokenCadena(yytext()); anañirTextoAceptado(yytext());}
{COMENTARIO}        { anañirTokenComentarios(yytext()); anañirTextoAceptado(yytext());}
{IDENTIFICADOR}     { anañirTokenIdentificador(yytext()); anañirTextoAceptado(yytext());}    
"CREATE"            { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"DATABASE"          { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"TABLE"             { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"KEY"               { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"NULL"              { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"PRIMARY"           { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"UNIQUE"            { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"FOREIGN"           { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"REFERENCES"        { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"ALTER"             { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"ADD"               { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"COLUMN"            { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"TYPE"              { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"DROP"              { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"CONSTRAINT"        { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"IF"                { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"EXIST"             { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"CASCADE"           { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"ON"                { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"DELETE"            { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"SET"               { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"UPDATE"            { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"INSERT"            { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"INTO"              { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"VALUES"            { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"SELECT"            { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"FROM"              { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"WHERE"             { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"AS"                { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"GROUP"             { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"ORDER"             { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"BY"                { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"ASC"               { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"DESC"              { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"LIMIT"             { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"JOIN"              { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());}
"INTEGER"           { anañirTokenTipoDeDato(yytext()); anañirTextoAceptado(yytext());}
"BIGINT"            { anañirTokenTipoDeDato(yytext()); anañirTextoAceptado(yytext());}
"VARCHAR"           { anañirTokenTipoDeDato(yytext()); anañirTextoAceptado(yytext());}
"DECIMAL"           { anañirTokenTipoDeDato(yytext()); anañirTextoAceptado(yytext());}
"DATE"              { anañirTokenTipoDeDato(yytext()); anañirTextoAceptado(yytext());}
"TEXT"              { anañirTokenTipoDeDato(yytext()); anañirTextoAceptado(yytext());}
"BOOLEAN"           { anañirTokenTipoDeDato(yytext()); anañirTextoAceptado(yytext());}
"SERIAL"            { anañirTokenTipoDeDato(yytext()); anañirTextoAceptado(yytext());}
"NUMERIC"           { anañirTokenTipoDeDato(yytext()); anañirTextoAceptado(yytext());}
"TRUE"              { anañirTokenBooleano(yytext()); anañirTextoAceptado(yytext());}
"FALSE"             { anañirTokenBooleano(yytext()); anañirTextoAceptado(yytext());}
"SUM"               { anañirTokenAgregacion(yytext()); anañirTextoAceptado(yytext());}
"AVG"               { anañirTokenAgregacion(yytext()); anañirTextoAceptado(yytext());}
"COUNT"             { anañirTokenAgregacion(yytext()); anañirTextoAceptado(yytext());}
"MAX"               { anañirTokenAgregacion(yytext()); anañirTextoAceptado(yytext());}
"MIN"               { anañirTokenAgregacion(yytext()); anañirTextoAceptado(yytext());}
"("                 { anañirTokenSignos(yytext()); anañirTextoAceptado(yytext());}
")"                 { anañirTokenSignos(yytext()); anañirTextoAceptado(yytext());}
","                 { anañirTokenSignos(yytext()); anañirTextoAceptado(yytext());}
";"                 { anañirTokenSignos(yytext()); anañirTextoAceptado(yytext());}
"."                 { anañirTokenSignos(yytext()); anañirTextoAceptado(yytext());}
"="                 { anañirTokenSignos(yytext()); anañirTextoAceptado(yytext());}
"+"                 { anañirTokenAritmeticos(yytext()); anañirTextoAceptado(yytext());}
"-"                 { anañirTokenAritmeticos(yytext()); anañirTextoAceptado(yytext());}
"*"                 { anañirTokenAritmeticos(yytext()); anañirTextoAceptado(yytext());}
"/"                 { anañirTokenAritmeticos(yytext()); anañirTextoAceptado(yytext());}
"<"                 { anañirTokenRacionales(yytext()); anañirTextoAceptado(yytext());}
">"                 { anañirTokenRacionales(yytext()); anañirTextoAceptado(yytext());}
"<="                { anañirTokenRacionales(yytext()); anañirTextoAceptado(yytext());}
">="                { anañirTokenRacionales(yytext()); anañirTextoAceptado(yytext());}
"AND"               { anañirTokenLogicos(yytext()); anañirTextoAceptado(yytext());}
"OR"                { anañirTokenLogicos(yytext()); anañirTextoAceptado(yytext());}
"NOT"               { anañirTokenLogicos(yytext()); anañirTextoAceptado(yytext());}
.                   { anañirTokenErrores(yytext()); }
