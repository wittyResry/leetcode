import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

import static org.junit.Assert.*;

/**
 * @author Qingyu Li
 * @since 2019/03/23
 */
public class LongestIncreasingSubsequenceTest {
    private LongestIncreasingSubsequence test = new LongestIncreasingSubsequence();

    @Test
    public void lengthOfLIS() throws Exception {
        List<Integer> list = Lists.newArrayList(10, 9, 2, 5, 3, 7, 101, 18);
        int res = test.lengthOfLIS(list.stream().mapToInt(Integer::valueOf).toArray());
        Assert.assertEquals(res, 4);
    }

}