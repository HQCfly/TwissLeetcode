package com.twiss.microsoft;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: Twiss
 * @Date: 2021/12/24 11:37 下午
 */
public class LRUTest {

    @Test
    public void test(){
        LRU lruTest= new LRU(2);
        lruTest.put(1,1);
        lruTest.put(2,2);
        int res1 = lruTest.get(1);
        Assert.assertEquals(1,res1);
        lruTest.put(3,3);
        int res2 = lruTest.get(2);
        Assert.assertEquals(-1,res2);
    }
}
