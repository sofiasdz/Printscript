package token;

public class Token {
    TokenType type;
    String value;
    int startingColumn;
    int endingColumn;
    int startingLine;
    int endingLine;

    private Token(TokenType type, String value, int startingColumn, int endingColumn, int startingLine, int endingLine) {
        this.type = type;
        this.value = value;
        this.startingColumn = startingColumn;
        this.endingColumn = endingColumn;
        this.startingLine = startingLine;
        this.endingLine = endingLine;
    }

    public static Token let(int ln, int cn){
        return new Token(TokenType.LET,"let",cn,cn+2,ln,ln);
    }

    public static Token string(int ln, int cn){
        return new Token(TokenType.STRING,"string",cn,cn+5,ln,ln);
    }

    public static Token integer(int ln, int cn) {
        return new Token(TokenType.INTEGER,"integer",cn,cn+6,ln,ln);
    }

    public static Token assignation(int ln, int cn){
        return new Token(TokenType.ASSIGNATION,"=",cn,cn,ln,ln);
    }

    public static Token colon(int ln, int cn){
        return new Token(TokenType.COLON,":",cn,cn,ln,ln);
    }

    public static Token semicolon(int ln, int cn){
        return new Token(TokenType.SEMICOLON,";",cn,cn,ln,ln);
    }

    public static Token identifier(String value, int ln, int cn){
        return new Token(TokenType.IDENTIFIER,value,cn,cn+value.length()-1,cn,cn);
    }

    public String getValue() {
        return value;
    }
}

enum TokenType {
    STRING,
    INTEGER,
    ASSIGNATION,
    IDENTIFIER,
    COLON,
    SEMICOLON,
    LET,
    ADDITION,
    SUBSTRACTION,
    MULTIPLICATION,
    DIVISION
}