package TwoSum;

import org.junit.Assert;
import org.junit.Test;

public class TwoSumTest {
    @Test
    public void testTwoSum(){
        Method m = new Method();
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = m.twoSum(nums, target);
        Assert.assertEquals(new int[]{2,1}, result);
    }
}
