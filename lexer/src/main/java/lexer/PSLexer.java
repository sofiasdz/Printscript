package lexer;

import token.Token;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PSLexer  implements Lexer{
    @Override
    public List<Token> identifyTokens(List<String> text) {


        List<Token> tokens= new ArrayList<>();
        for (int i = 0; i <text.size() ; i++) {
            //line to char
            List<String> currentLine = lineToChars(text.get(i));
            lineToToken(currentLine);

        }

        return tokens;
    }


    private List<String> lineToChars(String line){
        List<String> chars = Arrays.asList(line.split("(?!^)"));
        return chars;
    }

    private List<Token> lineToToken(List<String> line){
        String currentWord = "";
        for (int i = 0; i <line.size() ; i++) {
            System.out.println(line.get(i));
        }
        for (int i = 0; i <line.size() ; i++) {
            if (line.get(i).equals(" ")){
                System.out.println(currentWord);
                currentWord="";
            }
            else currentWord+=line.get(i);
        }
        return new ArrayList<Token>();
    }
}
