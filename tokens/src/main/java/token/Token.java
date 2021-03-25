package token;

public class Token {
    TokenType type;
    String value;
    int startingColumn;
    int endingColumn;
    int startingLine;
    int endingLine;

}

enum TokenType {
    STRING,
    INTEGER,
    ASSIGNATION,
    IDENTIFIER,
    SEMICOLON,
    LET,
    ADDITION,
    SUBSTRACTION,
    MULTIPLICATION,
    DIVISION
}