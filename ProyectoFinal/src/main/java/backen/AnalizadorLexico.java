// DO NOT EDIT
// Generated by JFlex 1.9.1 http://jflex.de/
// source: AnalizadorLexico.flex

package backen;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("fallthrough")
public class AnalizadorLexico {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\5\u0100\1\u0200\1\u0300\1\u0100\5\u0400\1\u0500\1\u0600"+
    "\1\u0700\6\u0100\1\u0800\1\u0900\1\u0a00\1\u0b00\1\u0c00\1\u0d00"+
    "\3\u0100\1\u0e00\205\u0100\1\u0600\1\u0100\1\u0f00\1\u1000\1\u1100"+
    "\1\u1200\54\u0100\10\u1300\37\u0100\1\u0900\4\u0100\1\u1400\10\u0100"+
    "\1\u1500\2\u0100\1\u1600\1\u1700\1\u1200\1\u0100\1\u0500\1\u0100"+
    "\1\u1800\1\u1500\1\u0800\3\u0100\1\u1100\1\u1900\114\u0100\1\u1a00"+
    "\1\u1100\153\u0100\1\u1b00\11\u0100\1\u1c00\1\u1200\6\u0100\1\u1100"+
    "\u0f16\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\10\0\1\1\1\2\1\3\1\4\1\5\1\3\22\0"+
    "\1\2\6\0\1\6\2\7\2\10\1\7\1\11\1\7"+
    "\1\10\1\12\1\13\1\14\1\15\6\16\1\0\1\7"+
    "\1\17\1\20\1\17\2\0\1\21\1\22\1\23\1\24"+
    "\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44"+
    "\1\45\1\46\1\47\1\50\1\51\5\0\1\52\1\0"+
    "\32\53\12\0\1\4\u01da\0\12\54\206\0\12\54\306\0"+
    "\12\54\234\0\12\54\166\0\12\54\140\0\12\54\166\0"+
    "\12\54\106\0\12\54\u0116\0\12\54\106\0\12\54\u0146\0"+
    "\12\54\46\0\12\54\u012c\0\12\54\200\0\12\54\246\0"+
    "\12\54\6\0\12\54\266\0\12\54\126\0\12\54\206\0"+
    "\12\54\6\0\12\54\316\0\2\4\u01a6\0\12\54\46\0"+
    "\12\54\306\0\12\54\26\0\12\54\126\0\12\54\u0196\0"+
    "\12\54\6\0\u0100\4\240\0\12\54\206\0\12\54\u012c\0"+
    "\12\54\200\0\12\54\74\0\12\54\220\0\12\54\166\0"+
    "\12\54\146\0\12\54\206\0\12\54\106\0\12\54\266\0"+
    "\12\54\u0164\0\62\54\100\0\12\54\266\0";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[7424];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\1\1\4\2\5\1\6"+
    "\1\7\25\1\1\10\1\0\1\11\4\0\1\10\1\7"+
    "\3\0\1\12\3\0\1\12\23\0\1\13\16\0\1\14"+
    "\2\15\1\0\1\13\1\16\44\0\1\14\11\0\1\17"+
    "\12\0\1\20\42\0\1\21";

  private static int [] zzUnpackAction() {
    int [] result = new int[181];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\55\0\55\0\55\0\132\0\55\0\55\0\207"+
    "\0\264\0\341\0\u010e\0\u013b\0\u0168\0\u0195\0\u01c2\0\u01ef"+
    "\0\u021c\0\u0249\0\u0276\0\u02a3\0\u02d0\0\u02fd\0\u032a\0\u0357"+
    "\0\u0384\0\u03b1\0\u03de\0\u040b\0\u0438\0\u0465\0\u0492\0\u04bf"+
    "\0\u04ec\0\55\0\u0519\0\u0546\0\u0573\0\u05a0\0\u05cd\0\55"+
    "\0\u05fa\0\u0627\0\u0654\0\u0681\0\u06ae\0\u06db\0\u0708\0\55"+
    "\0\u0735\0\u0762\0\u078f\0\u07bc\0\u07e9\0\u0816\0\u0843\0\u0870"+
    "\0\u089d\0\u08ca\0\u08f7\0\u0924\0\u0951\0\u097e\0\u09ab\0\u09d8"+
    "\0\u0a05\0\u0a32\0\u0a5f\0\u0a8c\0\u0ab9\0\u0ae6\0\u0b13\0\u0b40"+
    "\0\u0b6d\0\u0b9a\0\u0bc7\0\u0bf4\0\u0c21\0\u0c4e\0\u0c7b\0\u0ca8"+
    "\0\u0cd5\0\u0d02\0\u0d2f\0\u0573\0\u05cd\0\u0d5c\0\55\0\55"+
    "\0\u0d89\0\u0db6\0\u0de3\0\u0e10\0\u0e3d\0\u0e6a\0\u0e97\0\u0ec4"+
    "\0\u0ef1\0\u0f1e\0\u0681\0\u0f4b\0\u0f78\0\u0fa5\0\u0fd2\0\u0fff"+
    "\0\u102c\0\u1059\0\u1086\0\u10b3\0\u10e0\0\u110d\0\u113a\0\u1167"+
    "\0\u1194\0\u11c1\0\u11ee\0\u121b\0\u1248\0\u1275\0\u12a2\0\u12cf"+
    "\0\u12fc\0\u1329\0\u1356\0\u1383\0\u13b0\0\u13dd\0\u140a\0\u1437"+
    "\0\u1464\0\u1491\0\u14be\0\u14eb\0\u1518\0\u1545\0\55\0\u1572"+
    "\0\u159f\0\u15cc\0\u15f9\0\u1626\0\u1653\0\u1680\0\u16ad\0\u16da"+
    "\0\u1707\0\55\0\u1734\0\u1761\0\u178e\0\u17bb\0\u17e8\0\u1815"+
    "\0\u1842\0\u186f\0\u189c\0\u18c9\0\u18f6\0\u1923\0\u1950\0\u197d"+
    "\0\u19aa\0\u19d7\0\u1a04\0\u1a31\0\u1a5e\0\u1a8b\0\u1ab8\0\u1ae5"+
    "\0\u1b12\0\u1b3f\0\u1b6c\0\u1b99\0\u1bc6\0\u1bf3\0\u1c20\0\u1c4d"+
    "\0\u1c7a\0\u1ca7\0\u1cd4\0\u1d01\0\55";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[181];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\3\3\2\4\1\5\1\6\1\7\1\10\5\11"+
    "\1\12\1\6\1\13\1\14\1\15\1\16\1\17\1\20"+
    "\1\21\1\2\1\22\1\23\1\24\1\25\1\26\1\27"+
    "\1\30\1\31\1\2\1\32\1\33\1\34\1\35\1\36"+
    "\1\37\3\2\1\40\1\2\55\0\6\41\1\42\3\41"+
    "\5\43\35\41\1\43\11\0\1\44\43\0\3\45\3\0"+
    "\4\45\5\11\33\45\1\46\1\47\1\45\20\0\1\50"+
    "\60\0\1\51\7\0\1\52\1\0\1\53\4\0\1\54"+
    "\2\0\1\55\37\0\1\56\5\0\1\57\11\0\1\60"+
    "\24\0\1\61\15\0\1\62\2\0\1\63\33\0\1\64"+
    "\3\0\1\65\14\0\1\66\62\0\1\67\25\0\1\70"+
    "\15\0\1\71\2\0\1\72\54\0\1\73\40\0\1\60"+
    "\7\0\1\74\55\0\1\75\42\0\1\76\60\0\1\77"+
    "\44\0\1\100\7\0\1\101\62\0\1\102\5\0\1\103"+
    "\45\0\1\60\3\0\1\104\54\0\1\105\37\0\1\106"+
    "\54\0\1\107\17\0\1\110\30\0\1\111\3\0\1\112"+
    "\14\0\1\113\6\0\1\114\41\0\1\115\1\0\1\116"+
    "\35\0\1\117\63\0\1\120\36\0\5\40\33\0\1\121"+
    "\1\40\1\0\6\41\1\42\54\41\1\42\3\41\5\122"+
    "\35\41\1\122\2\0\2\123\1\0\1\123\61\0\5\124"+
    "\50\0\5\125\34\0\1\40\13\0\5\125\33\0\1\121"+
    "\1\40\25\0\1\60\74\0\1\126\34\0\1\127\53\0"+
    "\1\60\60\0\1\130\54\0\1\131\64\0\1\132\60\0"+
    "\1\133\45\0\1\134\1\0\1\135\6\0\1\136\34\0"+
    "\1\137\73\0\1\140\33\0\1\141\10\0\1\142\6\0"+
    "\1\143\50\0\1\144\46\0\1\145\57\0\1\146\62\0"+
    "\1\147\51\0\1\150\54\0\1\151\60\0\1\152\1\153"+
    "\41\0\1\154\74\0\1\60\40\0\1\155\67\0\1\130"+
    "\42\0\1\130\62\0\1\127\44\0\1\156\1\157\43\0"+
    "\1\126\61\0\1\160\51\0\1\161\62\0\1\162\5\0"+
    "\1\163\1\0\1\60\45\0\1\130\41\0\1\164\102\0"+
    "\1\165\51\0\1\166\47\0\1\167\45\0\1\170\47\0"+
    "\1\137\64\0\1\171\5\0\1\172\37\0\1\173\41\0"+
    "\5\40\34\0\1\40\1\0\6\41\1\42\3\41\5\174"+
    "\35\41\1\174\2\175\2\123\1\175\1\123\47\175\25\0"+
    "\1\176\60\0\1\177\57\0\1\200\43\0\1\201\76\0"+
    "\1\202\52\0\1\203\47\0\1\204\37\0\1\205\54\0"+
    "\1\206\3\0\1\207\60\0\1\210\50\0\1\205\67\0"+
    "\1\60\57\0\1\211\54\0\1\166\36\0\1\212\64\0"+
    "\1\60\64\0\1\144\34\0\1\213\54\0\1\214\11\0"+
    "\1\60\53\0\1\60\47\0\1\211\57\0\1\60\45\0"+
    "\1\215\64\0\1\216\44\0\1\217\54\0\1\220\60\0"+
    "\1\221\57\0\1\167\64\0\1\207\35\0\1\222\54\0"+
    "\1\60\70\0\1\223\60\0\1\224\32\0\1\225\73\0"+
    "\1\167\12\0\6\41\1\42\3\41\5\226\35\41\1\226"+
    "\3\175\1\0\51\175\42\0\1\60\50\0\1\165\43\0"+
    "\1\227\50\0\1\230\70\0\1\154\63\0\1\231\54\0"+
    "\1\130\54\0\1\167\32\0\1\232\67\0\1\221\63\0"+
    "\1\60\41\0\1\233\65\0\1\211\41\0\1\234\67\0"+
    "\1\235\33\0\1\236\75\0\1\237\35\0\1\211\52\0"+
    "\1\240\100\0\1\167\34\0\1\241\57\0\1\242\24\0"+
    "\6\41\1\42\2\41\1\243\43\41\21\0\1\244\57\0"+
    "\1\167\72\0\1\245\33\0\1\246\62\0\1\154\52\0"+
    "\1\247\60\0\1\250\65\0\1\76\37\0\1\251\63\0"+
    "\1\207\63\0\1\60\32\0\1\247\33\0\6\41\1\42"+
    "\3\41\1\252\1\253\41\41\36\0\1\207\37\0\1\254"+
    "\76\0\1\167\53\0\1\207\35\0\1\207\67\0\1\255"+
    "\16\0\6\41\1\42\4\41\4\256\44\41\1\42\3\41"+
    "\3\256\40\41\31\0\1\257\46\0\1\224\31\0\6\41"+
    "\1\42\2\41\1\260\43\41\36\0\1\211\16\0\6\41"+
    "\1\42\3\41\1\261\2\262\1\263\45\41\1\42\4\41"+
    "\4\264\44\41\1\42\3\41\5\264\44\41\1\42\3\41"+
    "\2\264\47\41\1\265\46\41";

  private static int [] zzUnpacktrans() {
    int [] result = new int[7470];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\3\11\1\1\2\11\31\1\1\0\1\11\4\0"+
    "\1\1\1\11\3\0\1\1\3\0\1\11\23\0\1\1"+
    "\16\0\3\1\1\0\2\11\44\0\1\1\11\0\1\11"+
    "\12\0\1\11\42\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[181];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen())];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  @SuppressWarnings("unused")
  private boolean zzEOFDone;

  /* user code: */

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
        tokenCreate.add(new Token(token, yyline , yycolumn , "CREATE", (int) yychar));
}

public void anañirTokenTipoDeDato(String token) {
        tokenTipoDato.add(new Token(token,yyline , yycolumn , "TIPO DE DATO", (int) yychar));
}

public void anañirTokenEntero(String token) {
        tokenEntero.add(new Token(token, yyline, yycolumn,"ENTERO", (int) yychar));
}

public void anañirTokenDecimal(String token){
        tokenDecimal.add(new Token(token, yyline , yycolumn , "DECIMAL", (int) yychar));
}

public void anañirTokenFecha(String token){
        tokenFecha.add(new Token(token, yyline , yycolumn , "FECHA", (int) yychar));
}

public void anañirTokenCadena(String token){
        tokenCadena.add(new Token(token, yyline , yycolumn , "CADENA", (int) yychar));
}

public void anañirTokenIdentificador(String token){
        tokenIdentificador.add(new Token(token, yyline , yycolumn , "IDENTIFICADOR", (int) yychar));
}

public void anañirTokenBooleano(String token){
        tokenBooleano.add(new Token(token, yyline , yycolumn , "BOOLEANO", (int) yychar));
}

public void anañirTokenAgregacion(String token){
        tokenFuncionDeAgregacion.add(new Token(token, yyline , yycolumn , "FUNCION DE AGREGACION", (int) yychar));
}

public void anañirTokenSignos(String token){
        tokenSignos.add(new Token(token, yyline , yycolumn , "SIGNOS", (int) yychar));
}

public void anañirTokenAritmeticos(String token){
        tokenAritmeticos.add(new Token(token, yyline , yycolumn , "ARITMETICOS", (int) yychar));
}

public void anañirTokenRacionales(String token){
        tokenRacionales.add(new Token(token, yyline , yycolumn , "RACIONALES", (int) yychar));
}

public void anañirTokenLogicos(String token){
        tokenLogicos.add(new Token(token, yyline , yycolumn , "LOGICOS", (int) yychar));
}

public void anañirTokenComentarios(String token){
        tokenComentarios.add(new Token(token, yyline , yycolumn , "COMENTARIOS", (int) yychar));
}

public void anañirTokenErrores(String token){
        tokenErrores.add(new Token(token, yyline , yycolumn , "ERROR", (int) yychar));
}

public void addListaTokens(List<Token> lista){
        listaTokens.add(lista);
}




  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public AnalizadorLexico(java.io.Reader in) {
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
  private boolean zzCanGrow() {
    return true;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate && zzCanGrow()) {
      /* if not, and it can grow: blow it up */
      char newBuffer[] = new char[Math.min(zzBuffer.length * 2, zzMaxBufferLen())];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      if (requested == 0) {
        throw new java.io.EOFException("Scan buffer limit reached ["+zzBuffer.length+"]");
      }
      else {
        throw new java.io.IOException(
            "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
      }
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    int initBufferSize = Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen());
    if (zzBuffer.length > initBufferSize) {
      zzBuffer = new char[initBufferSize];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  public int yylex() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return YYEOF;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { anañirTokenErrores("ERROR>> Linea: " + yyline + ", columna: " + yycolumn + ", Token -> " + yytext());
            }
          // fall through
          case 18: break;
          case 2:
            { 
            }
          // fall through
          case 19: break;
          case 3:
            { System.out.print(yytext());
            }
          // fall through
          case 20: break;
          case 4:
            { anañirTokenSignos(yytext()); anañirTextoAceptado(yytext());
            }
          // fall through
          case 21: break;
          case 5:
            { anañirTokenAritmeticos(yytext()); anañirTextoAceptado(yytext());
            }
          // fall through
          case 22: break;
          case 6:
            { anañirTokenEntero(yytext()); anañirTextoAceptado(yytext());
            }
          // fall through
          case 23: break;
          case 7:
            { anañirTokenRacionales(yytext()); anañirTextoAceptado(yytext());
            }
          // fall through
          case 24: break;
          case 8:
            { anañirTokenIdentificador(yytext()); anañirTextoAceptado(yytext());
            }
          // fall through
          case 25: break;
          case 9:
            { anañirTokenCadena(yytext()); anañirTextoAceptado(yytext());
            }
          // fall through
          case 26: break;
          case 10:
            { anañirTokenCreate(yytext()); anañirTextoAceptado(yytext());
            }
          // fall through
          case 27: break;
          case 11:
            { anañirTokenLogicos(yytext()); anañirTextoAceptado(yytext());
            }
          // fall through
          case 28: break;
          case 12:
            { anañirTokenComentarios(yytext()); anañirTextoAceptado(yytext());
            }
          // fall through
          case 29: break;
          case 13:
            { anañirTokenDecimal(yytext()); anañirTextoAceptado(yytext());
            }
          // fall through
          case 30: break;
          case 14:
            { anañirTokenAgregacion(yytext()); anañirTextoAceptado(yytext());
            }
          // fall through
          case 31: break;
          case 15:
            { anañirTokenTipoDeDato(yytext()); anañirTextoAceptado(yytext());
            }
          // fall through
          case 32: break;
          case 16:
            { anañirTokenBooleano(yytext()); anañirTextoAceptado(yytext());
            }
          // fall through
          case 33: break;
          case 17:
            { anañirTokenFecha(yytext()); anañirTextoAceptado(yytext());
            }
          // fall through
          case 34: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }

  /**
   * Runs the scanner on input files.
   *
   * This is a standalone scanner, it will print any unmatched
   * text to System.out unchanged.
   *
   * @param argv   the command line, contains the filenames to run
   *               the scanner on.
   */
  public static void main(String[] argv) {
    if (argv.length == 0) {
      System.out.println("Usage : java AnalizadorLexico [ --encoding <name> ] <inputfile(s)>");
    }
    else {
      int firstFilePos = 0;
      String encodingName = "UTF-8";
      if (argv[0].equals("--encoding")) {
        firstFilePos = 2;
        encodingName = argv[1];
        try {
          // Side-effect: is encodingName valid?
          java.nio.charset.Charset.forName(encodingName);
        } catch (Exception e) {
          System.out.println("Invalid encoding '" + encodingName + "'");
          return;
        }
      }
      for (int i = firstFilePos; i < argv.length; i++) {
        AnalizadorLexico scanner = null;
        java.io.FileInputStream stream = null;
        java.io.Reader reader = null;
        try {
          stream = new java.io.FileInputStream(argv[i]);
          reader = new java.io.InputStreamReader(stream, encodingName);
          scanner = new AnalizadorLexico(reader);
          while ( !scanner.zzAtEOF ) scanner.yylex();
        }
        catch (java.io.FileNotFoundException e) {
          System.out.println("File not found : \""+argv[i]+"\"");
        }
        catch (java.io.IOException e) {
          System.out.println("IO error scanning file \""+argv[i]+"\"");
          System.out.println(e);
        }
        catch (Exception e) {
          System.out.println("Unexpected exception:");
          e.printStackTrace();
        }
        finally {
          if (reader != null) {
            try {
              reader.close();
            }
            catch (java.io.IOException e) {
              System.out.println("IO error closing file \""+argv[i]+"\"");
              System.out.println(e);
            }
          }
          if (stream != null) {
            try {
              stream.close();
            }
            catch (java.io.IOException e) {
              System.out.println("IO error closing file \""+argv[i]+"\"");
              System.out.println(e);
            }
          }
        }
      }
    }
  }


}