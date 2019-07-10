import org.junit.Test;

import com.google.common.collect.Lists;

import static org.junit.Assert.*;

/**
 * @author Qingyu Li
 * @since 2019/03/24
 */
public class PartitionArrayIntoThreePartsWithEqualSumTest {
    private PartitionArrayIntoThreePartsWithEqualSum test = new PartitionArrayIntoThreePartsWithEqualSum();

    @Test
    public void canThreePartsEqualSum() throws Exception {
        int[] input = Lists.newArrayList(1, 2).stream().mapToInt(Integer::valueOf).toArray();
        test.canThreePartsEqualSum(input);
    }

}