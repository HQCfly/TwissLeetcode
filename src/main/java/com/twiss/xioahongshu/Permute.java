package com.twiss.xioahongshu;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2022/8/28 5:03 下午
 */
public class Permute {

    public List<List<Integer>> getResult(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        if (nums==null||nums.length==0){
            return ans;
        }
        int len = nums.length;
        boolean[] used = new boolean[len];
        Arrays.sort(nums);
        Deque<Integer> path = new ArrayDeque<>();

        backtrace(nums,2,0,path,used,ans);
        return ans;
    }

    private void backtrace(int[] nums,
                           int len,int depth,
                           Deque<Integer> path,
                           boolean[] used,
                           List<List<Integer>> res){
        if (depth==len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=0;i<nums.length;i++){
//            if (used[i]||(i>0&&nums[i]==nums[i-1]&&!used[i-1])){
//                continue;
//            }
            if (!used[i]){
                path.addLast(nums[i]);
                used[i] = true;

                backtrace(nums,len,depth+1,path,used,res);
                used[i] = false;
                path.removeLast();
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] config = sc.nextLine().split(" ");
        int n = Integer.parseInt(config[0]);
        int k = Integer.parseInt(config[1]);
        int[] nums = new int[n];
        String[] value = sc.nextLine().split(" ");
        for (int i=0;i<n;i++){
            nums[i] = Integer.parseInt(value[i]);
        }
        List<List<Integer>> ans = new Permute().getResult(nums);
        System.out.println(JSONObject.toJSONString(ans));
        int res = 0;
        if (ans.size()>0){
            for (int i=0;i<ans.size();i++){
                List<Integer> elements = ans.get(i);
                int tmp = 1;
                if (elements.size()==2){
                    for (int j=0;j<2;j++){
                        tmp*=elements.get(j);
                    }
                }
                if (tmp>=k){
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
