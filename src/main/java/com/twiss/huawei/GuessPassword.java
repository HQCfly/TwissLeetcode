package com.twiss.huawei;


import java.util.*;

/**
 * 猜游戏
 * 组合问题
 * @Author: Twiss
 * @Date: 2022/6/24 7:57 下午
 */
public class GuessPassword {

    public List<List<Integer>> combine(int[] nums, int k){
        List<List<Integer>> ans = new ArrayList<>();
        if (nums==null||nums.length==0){
            return ans;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums,k,0,path,ans);
        return ans;
    }

    private void dfs(int[] nums, int k, int begin,
                     Deque<Integer> path,List<List<Integer>> ans){
        if (path.size()>=k){
            ans.add(new ArrayList<>(path));
            // 判断结束条件，很重要
            if (path.size()==nums.length){
                return;
            }
        }
        // 遍历begin以及以后的节点
        for (int i=begin;i<nums.length;i++){
            path.offerLast(nums[i]);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            dfs(nums,k,i+1,path,ans);
            path.pollLast();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String[] arr = sc.nextLine().split(",");
            int k = sc.nextInt();
            int[] nums = new int[arr.length];
            for (int i=0;i<arr.length;i++){
                nums[i] = Integer.parseInt(arr[i]);
            }
            List<List<Integer>> ans = new GuessPassword().combine(nums,k);
            for (int i=0;i<ans.size();i++){
                StringBuilder st = new StringBuilder();
                List<Integer> tmp = ans.get(i);
                for (int j=0;j<tmp.size();j++){
                    st.append(tmp.get(j));
                    if (j!=tmp.size()-1){
                        st.append(",");
                    }
                }
                System.out.println(new String(st));
            }
        }
    }
}
