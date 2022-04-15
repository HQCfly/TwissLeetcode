package com.twiss.weilai;

import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2022/4/15 7:45 下午
 */
public class MinJump {

    public static int run(int[] arr){
        int len = arr.length;
        Map<Integer,List<Integer> > map = new HashMap<>();
        // 存储数组对应下标索引
        for (int i=len-1;i>=0;i--){
            List<Integer> list = map.getOrDefault(arr[i],new ArrayList<>());
            list.add(i);
            map.put(arr[i],list);
        }

        // 广度优先遍历
        Deque<Integer> queue = new ArrayDeque<>();
        int min = 0;
        queue.add(0);
        HashSet<Integer> set = new HashSet<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;++i){
                int firstEle = queue.pollFirst();
                // 去重
                if (set.contains(firstEle)){
                    continue;
                }
                set.add(firstEle);
                if (firstEle == len-1){
                    return min;
                }
                // 入队
                if (firstEle-1>0){
                    queue.offerLast(firstEle-1);
                }
                if (firstEle+1<len){
                    queue.offerLast(firstEle+1);
                }

                List<Integer> list = map.getOrDefault(arr[firstEle],new ArrayList<>());
                for (int j:list){
                    queue.offerLast(j);
                }
                map.remove(arr[firstEle]);
            }
            min++;
        }
        return min;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] list = str.split(",");
        int[] list2 = new int[list.length];

        for (int i=0;i< list.length;++i){
            list2[i] = Integer.parseInt(list[i]);
        }
        int ret = run(list2);
        System.out.println(ret);
    }

}
