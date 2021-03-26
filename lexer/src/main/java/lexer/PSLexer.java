package lexer;

import token.Token;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PSLexer  implements Lexer{
    @Override
    public List<Token> identifyTokens(List<String> text) {
        List<Token> tokens= new ArrayList<>();
        for (int i = 0; i <text.size() ; i++) {
            //line to char
            List<String> currentLine = lineToChars(text.get(i));
            lineToToken(currentLine,i);
        }
        return tokens;
    }


    private List<String> lineToChars(String line){
        List<String> chars = Arrays.asList(line.split("(?!^)"));
        return chars;
    }

    private List<Token> lineToToken(List<String> line, int lineNumber){
        String currentWord = "";
        List<Token> list = new ArrayList<Token>();
        for (int i = 0; i <line.size() ; i++) {
            Optional<Token> token = tokenIdentifier(currentWord,lineNumber,i);
            if(token.isPresent()){
                list.add(token.get());
                currentWord = "";
            }
            else currentWord+=line.get(i);
        }
        return list;
    }

    private Optional<Token> tokenIdentifier(String token, int lineNumber, int columnNumber){
        return switch (token) {
            case "let" -> Optional.of(Token.let(lineNumber, columnNumber));
            case "string" -> Optional.of(Token.string(lineNumber, columnNumber));
            case "number" -> Optional.of(Token.integer(lineNumber, columnNumber));
            case "=" -> Optional.of(Token.assignation(lineNumber, columnNumber));
            case ":" -> Optional.of(Token.colon(lineNumber, columnNumber));
            case ";" -> Optional.of(Token.semicolon(lineNumber, columnNumber));
            default -> Optional.empty();
        };
    }
}
