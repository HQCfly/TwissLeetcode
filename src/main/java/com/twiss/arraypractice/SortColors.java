package com.twiss.arraypractice;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/4/15 8:12 下午
 */
public class SortColors {

    public static int[] getColors(int[] colors) {
        int n = colors.length;
        int ptr = 0;
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) {
                int tmp = colors[i];
                colors[i] = colors[ptr];
                colors[ptr] = tmp;
                ++ptr;
            }
        }
        for (int i = ptr; i < n; i++) {
            if (colors[i] == 1) {
                int tmp = colors[i];
                colors[i] = colors[ptr];
                colors[ptr] = tmp;
                ++ptr;
            }
        }
        return colors;
    }

    public static int[] getColors2(int[] colors) {
        int n = colors.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; i++) {
            if (colors[i] == 1) {
                int tmp = colors[i];
                colors[i] = colors[p1];
                colors[p1] = tmp;
                ++p1;
            } else if (colors[i] == 0) {
                int tmp = colors[i];
                colors[i] = colors[p0];
                colors[p0] = tmp;
                if (p0 < p1) {
                    tmp = colors[i];
                    colors[i] = colors[p1];
                    colors[p1] = tmp;
                }
                ++p1;
                ++p0;
            }
        }
        return colors;
    }

    public static int[] getColors3(int[] colors) {
        int n = colors.length;
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i < n; i++) {
            while (i < p2 && colors[i] == 2) {
                int tmp = colors[i];
                colors[i] = colors[p2];
                colors[p2] = tmp;
                p2--;
            }
            if (colors[i]==0){
                int tmp = colors[i];
                colors[i] = colors[p0];
                colors[p0] = tmp;
                p0++;
            }
        }
        return colors;
    }

    public static void main(String[] args) {
        int[] colors = {2, 0, 2, 1, 1, 0};
        int[] res = getColors(colors);
        System.out.println(JSONObject.toJSONString(res));

        int[] colors2 = {2, 0, 2, 1, 1, 0};
        int[] res2 = getColors2(colors2);
        System.out.println(JSONObject.toJSONString(res2));

        int[] colors3 = {2, 0, 2, 1, 1, 0};
        int[] res3 = getColors2(colors3);
        System.out.println(JSONObject.toJSONString(res3));
    }
}
