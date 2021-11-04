package com.twiss.sort;

import java.util.Arrays;

/**
 * @Author: Twiss
 * @Date: 2021/10/29 9:34 下午
 */
public class MaximumGap {

    public int getMaximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        // 找出最大值和最小值
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < len; ++i) {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        // 如果nums的元素都一样则return
        if (max - min == 0) {
            return 0;
        }
        // 设置最大，最小桶
        int[] maxBucket = new int[len - 1];
        int[] minBucket = new int[len - 1];

        Arrays.fill(maxBucket, -1);
        Arrays.fill(minBucket, Integer.MAX_VALUE);

        int interval = (int) Math.ceil((double) (max - min) / (len - 1));
        for (int i = 0; i < len; ++i) {
            // 计算当前值桶的下标索引
            int index = (nums[i] - min) / interval;
            if (nums[i] == min || nums[i] == max) continue;
            // 更新每个桶的数据
            maxBucket[index] = Math.max(maxBucket[index], nums[i]);
            minBucket[index] = Math.min(minBucket[index], nums[i]);
        }
        // maxGap 表示桶之间的最大差距
        int maxGap = 0;
        // preMax 表示前一个桶的最大值
        int preMax = min;
        for (int i = 0; i < len - 1; ++i) {
            // 表示某一个桶为空
            // 但凡某一个桶不为空，都会在前面的数据中更新掉bucketMax的值
            if (maxBucket[i] == -1) continue;
            maxGap = Math.max(minBucket[i] - preMax, maxGap);
            preMax = maxBucket[i];
        }
        maxGap = Math.max(maxGap, max - preMax);
        return maxGap;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 6, 9, 1};
        int res = new MaximumGap().getMaximumGap(numbers);
        System.out.println(res);
    }

}
