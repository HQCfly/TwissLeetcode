package com.twiss.xioahongshu;

import java.util.*;

//3 3 2
//90 90 90
//80 100 90
//80 85 85

/**
 * @Author: Twiss
 * @Date: 2022/8/28 4:30 下午
 */
public class SortPriority {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] config = sc.nextLine().split(" ");
        int n = Integer.parseInt(config[0]);
        int m = Integer.parseInt(config[1]);
        int id = Integer.parseInt(config[2]) - 1;

        int[][] arr = new int[n][m];
        int[] queue = new int[n];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            String[] tmp = sc.nextLine().split(" ");
            int tmpSum = 0;
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
                tmpSum += arr[i][j];
            }
            map.put(i, tmpSum);
            queue[i] = tmpSum;
        }
        Arrays.sort(queue);
        int pri = 0;
        for (Integer key : map.keySet()) {
            if (key < id && map.get(key).equals(map.get(id))) {
                pri++;
            }
        }
        int priority = 0;
        for (int i = queue.length - 1; i >= 0; i--) {
            if (queue[i] == map.get(id)) {
                priority = queue.length - i;
                break;
            }
        }
        System.out.println(pri + priority);
    }
}
