package com.twiss.microsoft;
import org.junit.Assert;
import org.junit.Test;
/**
 * @Author: Twiss
 * @Date: 2021/12/24 11:37 下午
 */
public class KthLargestTest {

    @Test
    public void test(){
        int[] nums = {3,2,1,5,6,4};
        int k = 1;
        int res = new KthLargest().getKthLargest(nums,k);
        Assert.assertEquals(6,res);
    }
}
