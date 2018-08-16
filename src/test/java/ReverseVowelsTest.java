import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author resry.lqy
 * @version $Id: ReverseVowelsTest.java, v 0.1 2018-08-12 21:20 resry.lqy Exp $
 */
public class ReverseVowelsTest {

    @Test
    public void reverseVowels() {
        ReverseVowels reverseVowels = new ReverseVowels();
        Assert.assertEquals("test", "leotcede", reverseVowels.reverseVowels("leetcode"));
    }

    @Test
    public void test2() {
        ReverseVowels reverseVowels = new ReverseVowels();
        Assert.assertEquals("test", "holle", reverseVowels.reverseVowels("hello"));

    }
}