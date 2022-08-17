package com.twiss.huawei;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 数组二叉树
 * 左节点2N，右节点2N+1
 *
 * @Author: Twiss
 * @Date: 2022/7/13 4:59 下午
 */
public class ArrayTree {

    public List<Integer> getMinLeft(int[] tree) {
        List<Integer> ans = new ArrayList<>();
        if (tree == null) {
            return ans;
        }
        int n = tree.length;
        int level = (int) (Math.log(n) / Math.log(2)) - 1;
        int index = 1;
        while (level >= 0) {
            index += Math.pow(2, level - 1);
            level--;
        }
        int minNum = Integer.MAX_VALUE;
        int minIndex = index + 1;
        for (int i = index + 2; i < n; i++) {
            int num = tree[i];
            if (num != -1) {
                if (minNum > num) {
                    minNum = num;
                    minIndex = i;
                }
            }
        }
        ans.add(tree[minIndex]);
        while (minIndex >= 2) {
            // 奇数
            if (minIndex % 2 == 1) {
                minIndex = (int) ((minIndex - 1) / 2);
            } else {
                minIndex = (int) (minIndex / 2);
            }
            ans.add(tree[minIndex]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] arr = sc.nextLine().split(" ");
            int n = arr.length;
            int[] tree = new int[n + 1];
            tree[0] = 0;
            for (int i = 1; i <= n; i++) {
                tree[i] = Integer.parseInt(arr[i - 1]);
            }
            List<Integer> ans = new ArrayTree().getMinLeft(tree);
            System.out.println(JSONObject.toJSONString(ans));
        }
    }
}
