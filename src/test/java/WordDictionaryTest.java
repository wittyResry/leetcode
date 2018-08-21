import org.junit.Assert;
import org.junit.Test;

/**
 * @author Qingyu Li
 * @since 2018/08/21
 */
public class WordDictionaryTest {

    @Test
    public void search() {
        WordDictionary test = new WordDictionary();
        test.addWord("bad");
        test.addWord("dad");
        test.addWord("mad");
        Assert.assertFalse("test", test.search("pad"));
        Assert.assertTrue("test", test.search("bad"));
        Assert.assertTrue("test", test.search(".ad"));
        Assert.assertTrue("test", test.search("b.."));

    }
}