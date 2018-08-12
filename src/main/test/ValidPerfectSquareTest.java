import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author resry.lqy
 * @version $Id: ValidPerfectSquareTest.java, v 0.1 2018-08-12 22:24 resry.lqy Exp $
 */
public class ValidPerfectSquareTest {

    @Test
    public void isPerfectSquare() {
        ValidPerfectSquare validPerfectSquare = new ValidPerfectSquare();
        Assert.assertEquals("test", true, validPerfectSquare.isPerfectSquare(16));
    }
}