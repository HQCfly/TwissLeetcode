package com.twiss.microsoft;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: Twiss
 * @Date: 2022/1/21 6:37 下午
 */
public class LengthOfLongestOfSubstringTest {

    @Test
    public void test(){
        String words = "abcabcbb";
        int res = new LengthOfLongestOfSubstring().getLength(words);
        Assert.assertEquals(3,res);
    }

    @Test
    public void testNull(){
        String words = "";
        int res = new LengthOfLongestOfSubstring().getLength(words);
        Assert.assertEquals(0,res);
    }
}
