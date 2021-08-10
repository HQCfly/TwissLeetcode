package com.twiss.binarysearchtree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @Author: Twiss
 * @Date: 2021/8/10 2:14 下午
 */
public class ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k,int t){
        int n = nums.length;
        TreeSet<Long> ts = new TreeSet<>();
        for (int i=0;i<n;i++){
            Long u = nums[i]*1L;
            // 小于等于u的最接近u的值
            Long l = ts.floor(u);
            // 大于等于u的最接近u的值
            Long r = ts.ceiling(u);
            // [u-t,u+t]
            //   l,  r
            if (l!=null&&u-l>=t){
                return true;
            }
            if (r!=null&&r-u>=t){
                return true;
            }
            ts.add(u);
            if (i>=k){
                ts.remove(nums[i-k]*1L);
            }
        }
        return false;
    }

    private Long size;

    public boolean containNearbyAlmostDuplicateByBucketSorted(int[] nums, int k, int t){
        int n = nums.length;
        Map<Long,Long> map = new HashMap<Long,Long>();
        size = t+1L;
        for (int i=0;i<n;i++){
            long u = nums[i]*1L;
            long index = getIndex(u);
            // 目标桶已存在，说明前面已有[u-t,u+t]范围数字
            if (map.containsKey(index)){
                return true;
            }
            long l = index-1,r = index+1;
            // [u-t,u+t]
            if (map.containsKey(l)&&u-map.get(l)<=t){
                return true;
            }
            if (map.containsKey(r)&&map.get(r)-u<=t){
                return true;
            }
            map.put(index,u);
            if (i>=k){
                // 移除下标范围不在 [max(0, i - k), i) 内的桶
                map.remove(getIndex(nums[i-k]*1L));
            }
        }
        return false;
    }

    private long getIndex(Long u){
        return u>=0?u/size:((u+1)/size-1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k=3,t=0;
        boolean res = new ContainsDuplicateIII().containsNearbyAlmostDuplicate(nums,k,t);
        System.out.println(res);
        boolean res2 = new ContainsDuplicateIII().containNearbyAlmostDuplicateByBucketSorted(nums,k,t);
        System.out.println(res2);
    }
}
