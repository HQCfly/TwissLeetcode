package com.twiss.microsoft;
import org.junit.Assert;
import org.junit.Test;
/**
 * @Author: Twiss
 * @Date: 2021/12/26 10:56 下午
 */
public class ReverseLinkedListTest {

    @Test
    public void test(){
        LinkedNode linkedNode = new LinkedNode(10,new LinkedNode(20,new LinkedNode(30)));
        LinkedNode res = new ReverseLinkedList().reverseNode(linkedNode);
        Assert.assertEquals(30,res.val);
    }

    @Test
    public void testRecur(){
        LinkedNode linkedNode = new LinkedNode(10,new LinkedNode(20,new LinkedNode(30)));
        LinkedNode res = new ReverseLinkedList().reverseListByRecursion(linkedNode);
        Assert.assertEquals(30,res.val);
    }
}
