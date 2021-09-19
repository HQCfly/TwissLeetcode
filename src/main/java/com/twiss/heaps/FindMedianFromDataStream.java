package com.twiss.heaps;

import java.util.PriorityQueue;

/**
 * @Author: Twiss
 * @Date: 2021/9/16 7:09 下午
 */
public class FindMedianFromDataStream {
    PriorityQueue<Integer> l = new PriorityQueue<>((a, b)->b-a);
    PriorityQueue<Integer> r = new PriorityQueue<>((a,b)->a-b);

    public void addNum(int num){
        int s1 = l.size(), s2 = r.size();
        // 当数据流元素数量为偶数：l 和 r 大小相同，此时动态中位数为两者堆顶元素的平均值；
        if (s1==s2){
            if (r.isEmpty()||num<=r.peek()){
                l.add(num);
            }else {
                l.add(r.poll());
                r.add(num);
            }
        }else {
            // 当数据流元素数量为奇数：l 比 r 多一，此时动态中位数为 l 的堆顶原数。
            if (l.peek()<=num){
                r.add(num);
            }else {
                r.add(l.poll());
                l.add(num);
            }
        }
    }

    public double findMedian(){
        int s1 = l.size(),s2=r.size();
        if (s1==s2){
            return (l.peek()+r.peek())/2.0;
        }else {
            return l.peek();
        }
    }

    public static void main(String[] args) {
        FindMedianFromDataStream ds = new FindMedianFromDataStream();

        ds.addNum(1);
        ds.addNum(2);
        double mediaNum = ds.findMedian();
        System.out.println("mediaNum:"+mediaNum);
        ds.addNum(3);
        double mediaNum2 = ds.findMedian();
        System.out.println("mediaNum2:"+mediaNum2);
    }
}
