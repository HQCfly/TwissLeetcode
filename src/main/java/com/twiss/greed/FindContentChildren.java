package com.twiss.greed;

import java.util.Arrays;

/**
 * 分发饼干
 * 时间复杂度O(nlogn)
 * 空间复杂度O(1)
 * @Author: Twiss
 * @Date: 2022/4/30 3:09 下午
 */
public class FindContentChildren {

    /**
     * 优先考虑饼干，小饼干先喂饱小胃口
     * @param biscuit 饼干尺寸
     * @param children 小孩胃口大小
     * @return
     */
    public int feedMaxChildren(int[] biscuit,int[] children){
        Arrays.sort(biscuit);
        Arrays.sort(children);
        int start = 0;
        int count = 0;
        for (int i=0;i<children.length&&start<biscuit.length;++i){
            // 满足孩子的胃口小于饼干尺寸，才能喂饱一个小孩
            if (children[i]<=biscuit[start]){
                start++;
                count++;
            }
        }
        return count;
    }

    /**
     * 大饼干优选喂饱大胃口
     * @param biscuit
     * @param children
     * @return
     */
    public int feedMaxChildrenByBigBiscuit(int[] biscuit,int[] children){
        Arrays.sort(biscuit);
        Arrays.sort(children);
        int start = biscuit.length-1;
        int count = 0;
        for (int i=children.length-1;i>=0&&start>=0;i--){
            if (children[i]<=biscuit[start]){
                start--;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] biscuits = {1,1};
        int[] children = {1,2,3};
        int res = new FindContentChildren().feedMaxChildren(biscuits,children);
        System.out.println("res: "+res);
        int res2 = new FindContentChildren().feedMaxChildrenByBigBiscuit(biscuits,children);
        System.out.println("res2: "+res2);
    }

}
