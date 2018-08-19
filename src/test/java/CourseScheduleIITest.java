import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.junit.Assert;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * @author Qingyu Li
 * @since 2018/08/19
 */
public class CourseScheduleIITest {

    @Test
    public void findOrder() {
        CourseScheduleII c = new CourseScheduleII();
        int[][] prerequisites = new int[4][2];
        prerequisites = JSON.parseObject("[[1,0],[2,0],[3,1],[3,2]]", new TypeReference<int[][]>() {
        });
        int[] expected = JSON.parseObject("[0,1,2,3]", new TypeReference<int[]>() {
        });
        int[] res = c.findOrder(4, prerequisites);
        for (int i = 0; i < expected.length; ++i) {
            Assert.assertEquals(ReflectionToStringBuilder.toString(res), expected[i], res[i]);
        }
    }
}