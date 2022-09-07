package com.twiss.zoom;

import java.util.*;

/**
 * intput:
 * 5
 * RBRBB
 * 2 5
 * 1 5
 * 4 1
 * 3 5
 * <p>
 * output:
 * 3
 *
 * @Author: Twiss
 * @Date: 2022/8/10 7:51 下午
 */
public class TheSumOfWeight {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String divide = sc.nextLine();

        List<List<Integer>> adjacency = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int tmp = Integer.MIN_VALUE;
        int root = 1;
        for (int i = 0; i < n - 1; i++) {
            List<Integer> subAdj = new ArrayList<>();
            String[] adjs = sc.nextLine().split(" ");
            int num1 = Integer.parseInt(adjs[0]);
            int num2 = Integer.parseInt(adjs[1]);
            map.put(num1, map.getOrDefault(num1, 0) + 1);
            map.put(num2, map.getOrDefault(num2, 0) + 1);
            subAdj.add(num1);
            subAdj.add(num2);
            adjacency.add(subAdj);
        }

        for (int ele : map.keySet()) {
            int times = map.get(ele);
            if (times > tmp) {
                tmp = times;
                root = ele;
            }
        }
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            if (adjacency.get(i).contains(root)) {
                Set<Integer> path = new HashSet<>();
                int num1 = adjacency.get(i).get(0);
                int num2 = adjacency.get(i).get(1);
                int tmpNode = num1;
                if (tmpNode == root) {
                    tmpNode = num2;
                }
                path.add(num1);
                path.add(num2);
                for (int j = i + 1; j < n - 1; j++) {
                    if (adjacency.get(j).contains(tmpNode)) {
                        int subNum1 = adjacency.get(j).get(0);
                        int subNum2 = adjacency.get(j).get(1);
                        path.add(subNum1);
                        path.add(subNum2);
                    }
                }
                sum += calculate(path, divide);
            }
        }
        System.out.println(sum);
    }


    public static int calculate(Set<Integer> path, String weight) {
        int red = 0;
        int blue = 0;
        for (int ele : path) {
            if (weight.charAt(ele - 1) == 'R') {
                red++;
            } else {
                blue++;
            }
        }
        return Math.abs(red - blue);
    }
}
