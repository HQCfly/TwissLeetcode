package com.twiss.greed;

/**
 * 分糖果果
 * 时间复杂度O()
 * 空间复杂度O()
 * @Author: Twiss
 * @Date: 2022/5/4 9:09 下午
 */
public class DistributeCandies {

    public int getMinCandies(int[] scores){
        if (scores==null||scores.length==0){
            return 0;
        }
        int n = scores.length;
        int[] candyVec = new int[n];
        candyVec[0] = 1;
        for (int i=1;i<n;i++){
            if (scores[i]>scores[i-1]){
                candyVec[i] = candyVec[i-1]+1;
            }else {
                candyVec[i] = 1;
            }
        }

        for (int i=n-2;i>=0;i--){
            if (scores[i]>scores[i+1]){
                candyVec[i] = Math.max(candyVec[i],candyVec[i+1]+1);
            }
        }

        int ans = 0;
        for (int i=0;i<n;i++){
            ans+= candyVec[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] scores = {1,0,2};
        int ans = new DistributeCandies().getMinCandies(scores);
        System.out.println(ans);
    }
}
