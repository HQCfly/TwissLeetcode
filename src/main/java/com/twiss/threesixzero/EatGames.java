package com.twiss.threesixzero;

import java.util.Scanner;

/**
 * @Author: Twiss
 * @Date: 2022/8/27 3:24 下午
 */
public class EatGames {

    public int getMaxGroups(int[] group){
        if (group==null||group.length==0){
            return 0;
        }
        int one = group[0];
        int two = group[1];
        int three = group[2];
        int four = group[3];

        int oneThreeCombine = Math.min(one,three);
        int resOne = one-oneThreeCombine;
        int resThree = three-oneThreeCombine;

        int twoGroup = two/2;
        int restTwo = two%2;

        int twoThreeCombine = 0;
        while (resThree>0&&restTwo>0){
            resThree--;
            restTwo--;
            twoThreeCombine++;
        }
        int oneTwoCombine = 0;
        while (restTwo>0&&resOne>1){
            resOne= resOne-2;
            restTwo--;
            oneTwoCombine++;
        }
        int ans = four+oneThreeCombine+twoGroup+twoThreeCombine+oneTwoCombine;
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n<1||n>100){
            return;
        }
        int[][] groups = new int[n][4];
        sc.nextLine();
        for (int i=0;i<n;i++){
            String[] tmp = sc.nextLine().split(" ");
            for (int j=0;j<4;j++){
                int t = Integer.parseInt(tmp[j]);
                if (t<0||t>150){
                    return;
                }
                groups[i][j] = t;
            }
        }
        int[] ans = new int[n];
        for (int i=0;i<n;i++){
            ans[i] = new EatGames().getMaxGroups(groups[i]);
        }
        for (int i=0;i<n;i++){
            System.out.println(ans[i]);
        }
    }
}
