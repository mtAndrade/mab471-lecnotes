/* The following code was generated by JFlex 1.4.3 on 4/30/13 2:14 PM */

/* 
* A primeira seção da especificação vai até o primeiro %%,
* e consiste de código Java que é copiado ao pé da letra
*
*/

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 4/30/13 2:14 PM from the specification file
 * <tt>minijava.jflex</tt>
 */
public class ScannerMascarenhas {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
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
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\1\1\3\1\0\2\1\22\0\1\1\1\36\4\0\1\37"+
    "\1\0\1\40\1\40\1\4\1\40\1\40\1\40\1\34\1\2\12\43"+
    "\1\0\1\40\1\40\1\35\3\0\22\41\1\25\7\41\1\40\1\0"+
    "\1\40\1\0\1\42\1\0\1\11\1\5\1\13\1\17\1\10\1\30"+
    "\1\27\1\32\1\22\2\41\1\7\1\24\1\12\1\6\1\20\1\41"+
    "\1\26\1\14\1\16\1\21\1\23\1\31\1\15\1\33\1\41\1\40"+
    "\1\0\1\40\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\2\3\20\4\2\3\1\1\1\5"+
    "\1\2\1\0\13\4\1\6\7\4\1\7\1\10\1\11"+
    "\1\0\4\4\1\12\5\4\1\13\11\4\1\14\3\4"+
    "\1\15\1\16\1\4\1\17\1\20\10\4\1\21\5\4"+
    "\1\22\1\23\1\4\1\24\1\4\1\25\1\26\1\27"+
    "\1\4\1\30\1\31\1\32\13\0\1\33";

  private static int [] zzUnpackAction() {
    int [] result = new int[117];
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
    "\0\0\0\44\0\44\0\110\0\44\0\154\0\220\0\264"+
    "\0\330\0\374\0\u0120\0\u0144\0\u0168\0\u018c\0\u01b0\0\u01d4"+
    "\0\u01f8\0\u021c\0\u0240\0\u0264\0\u0288\0\u02ac\0\u02d0\0\u02f4"+
    "\0\u0318\0\u033c\0\u0360\0\u0384\0\u03a8\0\u03cc\0\u03f0\0\u0414"+
    "\0\u0438\0\u045c\0\u0480\0\u04a4\0\u04c8\0\u04ec\0\220\0\u0510"+
    "\0\u0534\0\u0558\0\u057c\0\u05a0\0\u05c4\0\u05e8\0\44\0\44"+
    "\0\44\0\u060c\0\u0630\0\u0654\0\u0678\0\u069c\0\220\0\u06c0"+
    "\0\u06e4\0\u0708\0\u072c\0\u0750\0\220\0\u0774\0\u0798\0\u07bc"+
    "\0\u07e0\0\u0804\0\u0828\0\u084c\0\u0870\0\u0894\0\220\0\u08b8"+
    "\0\u08dc\0\u0900\0\220\0\220\0\u0924\0\220\0\220\0\u0948"+
    "\0\u096c\0\u0990\0\u09b4\0\u09d8\0\u09fc\0\u0a20\0\u0a44\0\220"+
    "\0\u0a68\0\u0a8c\0\u0ab0\0\u0ad4\0\u0af8\0\220\0\220\0\u0b1c"+
    "\0\220\0\u0b40\0\220\0\220\0\220\0\u0b64\0\220\0\220"+
    "\0\220\0\u0b88\0\u0bac\0\u0bd0\0\u0bf4\0\u0c18\0\u0c3c\0\u0c60"+
    "\0\u0c84\0\u0ca8\0\u0ccc\0\u0cf0\0\44";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[117];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\3\1\5\1\6\1\7\1\10"+
    "\1\11\1\7\1\12\1\13\1\14\1\7\1\15\1\7"+
    "\1\16\1\7\1\17\1\20\1\21\1\22\1\23\1\7"+
    "\1\24\1\25\2\7\1\5\1\26\1\27\1\30\1\5"+
    "\1\7\1\2\1\31\46\0\1\32\1\0\1\33\44\0"+
    "\1\7\1\34\25\7\5\0\3\7\5\0\27\7\5\0"+
    "\3\7\5\0\3\7\1\35\23\7\5\0\3\7\5\0"+
    "\2\7\1\36\5\7\1\37\16\7\5\0\3\7\5\0"+
    "\3\7\1\40\23\7\5\0\3\7\5\0\2\7\1\41"+
    "\24\7\5\0\3\7\5\0\11\7\1\42\15\7\5\0"+
    "\3\7\5\0\21\7\1\43\3\7\1\44\1\7\5\0"+
    "\3\7\5\0\14\7\1\45\12\7\5\0\3\7\5\0"+
    "\5\7\1\46\15\7\1\47\3\7\5\0\3\7\5\0"+
    "\1\7\1\50\25\7\5\0\3\7\5\0\4\7\1\51"+
    "\22\7\5\0\3\7\5\0\11\7\1\52\14\7\1\53"+
    "\5\0\3\7\5\0\3\7\1\54\23\7\5\0\3\7"+
    "\5\0\4\7\1\55\22\7\5\0\3\7\5\0\25\7"+
    "\1\56\1\7\5\0\3\7\35\0\1\57\43\0\1\60"+
    "\45\0\1\61\47\0\1\31\3\32\1\0\40\32\4\33"+
    "\1\62\37\33\5\0\1\7\1\63\25\7\5\0\3\7"+
    "\5\0\5\7\1\64\21\7\5\0\3\7\5\0\7\7"+
    "\1\65\17\7\5\0\3\7\5\0\11\7\1\66\15\7"+
    "\5\0\3\7\5\0\24\7\1\67\2\7\5\0\3\7"+
    "\5\0\4\7\1\70\22\7\5\0\3\7\5\0\4\7"+
    "\1\71\22\7\5\0\3\7\5\0\14\7\1\72\12\7"+
    "\5\0\3\7\5\0\15\7\1\73\11\7\5\0\3\7"+
    "\5\0\1\74\26\7\5\0\3\7\5\0\11\7\1\75"+
    "\15\7\5\0\3\7\5\0\15\7\1\76\11\7\5\0"+
    "\3\7\5\0\15\7\1\77\11\7\5\0\3\7\5\0"+
    "\21\7\1\100\5\7\5\0\3\7\5\0\7\7\1\101"+
    "\17\7\5\0\3\7\5\0\11\7\1\102\15\7\5\0"+
    "\3\7\5\0\2\7\1\103\24\7\5\0\3\7\5\0"+
    "\15\7\1\104\11\7\5\0\3\7\2\33\1\3\1\33"+
    "\1\62\37\33\5\0\2\7\1\105\24\7\5\0\3\7"+
    "\5\0\22\7\1\106\4\7\5\0\3\7\5\0\3\7"+
    "\1\107\23\7\5\0\3\7\5\0\3\7\1\110\23\7"+
    "\5\0\3\7\5\0\7\7\1\111\17\7\5\0\3\7"+
    "\5\0\11\7\1\112\15\7\5\0\3\7\5\0\3\7"+
    "\1\113\23\7\5\0\3\7\5\0\7\7\1\114\17\7"+
    "\5\0\3\7\5\0\2\7\1\115\24\7\5\0\3\7"+
    "\5\0\12\7\1\116\14\7\5\0\3\7\5\0\5\7"+
    "\1\117\21\7\5\0\3\7\5\0\15\7\1\120\11\7"+
    "\5\0\3\7\5\0\11\7\1\121\15\7\5\0\3\7"+
    "\5\0\14\7\1\122\12\7\5\0\3\7\5\0\7\7"+
    "\1\123\17\7\5\0\3\7\5\0\2\7\1\124\24\7"+
    "\5\0\3\7\5\0\3\7\1\125\23\7\5\0\3\7"+
    "\5\0\11\7\1\126\15\7\5\0\3\7\5\0\5\7"+
    "\1\127\21\7\5\0\3\7\5\0\7\7\1\130\17\7"+
    "\5\0\3\7\5\0\15\7\1\131\11\7\5\0\3\7"+
    "\5\0\15\7\1\132\11\7\5\0\3\7\5\0\5\7"+
    "\1\133\21\7\5\0\3\7\5\0\3\7\1\134\23\7"+
    "\5\0\3\7\5\0\21\7\1\135\5\7\5\0\3\7"+
    "\5\0\3\7\1\136\23\7\5\0\3\7\5\0\3\7"+
    "\1\137\23\7\5\0\3\7\5\0\4\7\1\140\22\7"+
    "\5\0\3\7\5\0\25\7\1\141\1\7\5\0\3\7"+
    "\5\0\12\7\1\142\14\7\5\0\3\7\5\0\6\7"+
    "\1\143\20\7\5\0\3\7\5\0\6\7\1\144\20\7"+
    "\5\0\3\7\5\0\22\7\1\145\4\7\5\0\3\7"+
    "\5\0\17\7\1\146\7\7\5\0\3\7\5\0\5\7"+
    "\1\147\21\7\5\0\3\7\5\0\5\7\1\150\21\7"+
    "\5\0\3\7\5\0\7\7\1\151\17\7\5\0\3\7"+
    "\5\0\27\7\1\152\4\0\3\7\6\0\1\153\56\0"+
    "\1\154\40\0\1\155\61\0\1\156\27\0\1\157\51\0"+
    "\1\160\37\0\1\161\33\0\1\162\47\0\1\163\34\0"+
    "\1\164\46\0\1\165\31\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3348];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
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


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\2\11\1\1\1\11\25\1\1\0\23\1\3\11"+
    "\1\0\67\1\13\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[117];
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

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */

	public ScannerMascarenhas() { }

	public void input(String input) {
	    // inicializa entrada pro analisador
		yyreset(new StringReader(input));
	}
	
	public List<Token> tokens() throws IOException {
		List<Token> tokens = new ArrayList<Token>();
		Token tok = nextToken();
		while(tok.getTipo() != Token.EOF) {
			tokens.add(tok);
			tok = nextToken();
		}
		tokens.add(tok);
		return tokens;
	}



  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public ScannerMascarenhas(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public ScannerMascarenhas(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 126) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Token nextToken() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
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
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
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


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
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
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 5: 
          { return new Token(Token.NUM, yytext(), yyline, yycolumn);
          }
        case 28: break;
        case 10: 
          { return new Token(Token.NEW, yytext(), yyline, yycolumn);
          }
        case 29: break;
        case 23: 
          { return new Token(Token.STRING, yytext(), yyline, yycolumn);
          }
        case 30: break;
        case 7: 
          { return new Token(Token.EQ, yytext(), yyline, yycolumn);
          }
        case 31: break;
        case 1: 
          { throw new RuntimeException("erro léxico, linha: " + 
               (yyline+1) + ", coluna : " + (yycolumn+1) + ", char: " + 
               yytext());
          }
        case 32: break;
        case 9: 
          { return new Token(Token.AND, yytext(), yyline, yycolumn);
          }
        case 33: break;
        case 15: 
          { return new Token(Token.VOID, yytext(), yyline, yycolumn);
          }
        case 34: break;
        case 6: 
          { return new Token(Token.IF, yytext(), yyline, yycolumn);
          }
        case 35: break;
        case 26: 
          { return new Token(Token.EXTENDS, yytext(), yyline, yycolumn);
          }
        case 36: break;
        case 3: 
          { return new Token(yytext().charAt(0), yytext(), yyline, yycolumn);
          }
        case 37: break;
        case 13: 
          { return new Token(Token.TRUE, yytext(), yyline, yycolumn);
          }
        case 38: break;
        case 12: 
          { return new Token(Token.ELSE, yytext(), yyline, yycolumn);
          }
        case 39: break;
        case 18: 
          { return new Token(Token.FALSE, yytext(), yyline, yycolumn);
          }
        case 40: break;
        case 4: 
          { return new Token(Token.ID, yytext(), yyline, yycolumn);
          }
        case 41: break;
        case 27: 
          { return new Token(Token.PRINTLN, yytext(), yyline, yycolumn);
          }
        case 42: break;
        case 20: 
          { return new Token(Token.LENGTH, yytext(), yyline, yycolumn);
          }
        case 43: break;
        case 21: 
          { return new Token(Token.STATIC, yytext(), yyline, yycolumn);
          }
        case 44: break;
        case 25: 
          { return new Token(Token.BOOLEAN, yytext(), yyline, yycolumn);
          }
        case 45: break;
        case 8: 
          { return new Token(Token.NEQ, yytext(), yyline, yycolumn);
          }
        case 46: break;
        case 11: 
          { return new Token(Token.INT, yytext(), yyline, yycolumn);
          }
        case 47: break;
        case 16: 
          { return new Token(Token.MAIN, yytext(), yyline, yycolumn);
          }
        case 48: break;
        case 14: 
          { return new Token(Token.THIS, yytext(), yyline, yycolumn);
          }
        case 49: break;
        case 24: 
          { return new Token(Token.RETURN, yytext(), yyline, yycolumn);
          }
        case 50: break;
        case 19: 
          { return new Token(Token.WHILE, yytext(), yyline, yycolumn);
          }
        case 51: break;
        case 17: 
          { return new Token(Token.CLASS, yytext(), yyline, yycolumn);
          }
        case 52: break;
        case 22: 
          { return new Token(Token.PUBLIC, yytext(), yyline, yycolumn);
          }
        case 53: break;
        case 2: 
          { 
          }
        case 54: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
              {
                return new Token(Token.EOF, "<<EOF>>", yyline, yycolumn);
              }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
