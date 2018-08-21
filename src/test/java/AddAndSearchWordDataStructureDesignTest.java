import org.junit.Assert;
import org.junit.Test;

/**
 * @author Qingyu Li
 * @since 2018/08/20
 */
public class AddAndSearchWordDataStructureDesignTest {

    @Test
    public void test01() {
        AddAndSearchWordDataStructureDesign test = new AddAndSearchWordDataStructureDesign();
        test.addWord("bad");
        test.addWord("dad");
        test.addWord("mad");
        Assert.assertFalse("test", test.search("pad"));
        Assert.assertTrue("test", test.search("bad"));
        Assert.assertTrue("test", test.search(".ad"));
        Assert.assertTrue("test", test.search("b.."));
    }
}