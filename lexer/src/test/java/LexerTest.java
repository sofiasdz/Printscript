import lexer.PSLexer;
import org.junit.Assert;
import org.junit.Test;
import token.Token;

import java.util.ArrayList;
import java.util.List;

public class LexerTest {

    @Test
    public void test01_GivenAStringDeclarationShouldReturnATokensListOfSize7(){
        String line = "let variableName : string = \"olive\"";
        PSLexer psLexer = new PSLexer();
        List<Token> tokenList = psLexer.identifyTokens(List.of(line));
        Assert.assertEquals(tokenList.size(),7);
    }

    @Test
    public void test02() {
        String line1 = "let name : string = \"Khali\" ;";
        String line2 = "let lastName : string = \"Stessens\" ;";
        List<String> list= new ArrayList();
        list.add(line1);
        list.add(line2);
        PSLexer psLexer= new PSLexer();
        List<Token> tokenList = psLexer.identifyTokens(list);
        System.out.println("finished");

    }
}
