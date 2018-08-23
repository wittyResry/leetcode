import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Qingyu Li
 * @since 2018/08/23
 */
public class WordSearchIiTest {

    @Test
    public void test01() {
        char[][] board = new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' },
                                        { 'i', 'h', 'k', 'r' }, { 'i', 'f', 'l', 'v' } };
        String[] words = new String[] { "oath", "pea", "eat", "rain" };
        WordSearchIi test = new WordSearchIi();
        List<String> res = test.findWords(board, words);
        System.out.println(res);
    }
    @Test
    public void test02() {
        char[][] board = new char[][] { { 'a' , 'b' },
                { 'c' , 'd' } };
        String[] words = new String[] { "abcd" };
        WordSearchIi test = new WordSearchIi();
        List<String> res = test.findWords(board, words);
        System.out.println(res);
    }
}