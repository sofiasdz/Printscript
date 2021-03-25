import lexer.PSLexer;

import java.util.ArrayList;
import java.util.List;

public class LexerTest {

    public static void main(String[] args) {
        String line1 = "let firstName : String = \"Khali\" ;";
        String line2 = "let lastName : String = \"Stessens\" ;";
        List<String> list= new ArrayList();
        list.add(line1);
        list.add(line2);
        PSLexer psLexer= new PSLexer();
        psLexer.identifyTokens(list);

    }
}
