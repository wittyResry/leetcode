import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Qingyu Li
 * @since 2018/08/18
 */
public class ImplementTriePrefixTreeTest {

    @Test
    public void insert() {
        ImplementTriePrefixTree i = new ImplementTriePrefixTree();
        i.insert("abc");
    }
    @Test
    public void test1() {
        ImplementTriePrefixTree i = new ImplementTriePrefixTree();
        i.insert("abc");
        Assert.assertEquals("", true, i.startsWith("ab"));
        Assert.assertEquals("", false, i.startsWith("ad"));
    }
    @Test
    public void test2() {
        ImplementTriePrefixTree i = new ImplementTriePrefixTree();
        i.insert("abc");
        Assert.assertEquals("", false, i.search("ab"));
        Assert.assertEquals("", true, i.search("abc"));
    }

}