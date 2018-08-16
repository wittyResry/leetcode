import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Qingyu Li
 * @since 2018/08/16
 */
public class BitwiseAndOfNumbersRangeTest {

    @Test
    public void rangeBitwiseAnd() {
        BitwiseAndOfNumbersRange bitwiseAndOfNumbersRange = new BitwiseAndOfNumbersRange();
        Assert.assertEquals("", 4, bitwiseAndOfNumbersRange.rangeBitwiseAnd(5, 7));
    }
}