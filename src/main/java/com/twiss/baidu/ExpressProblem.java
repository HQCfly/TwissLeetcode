package com.twiss.baidu;

import java.util.Scanner;

/**
 * 快递问题
 * 给01串，对于相邻两位，00和11可以随便删任意一个，01只能删0，问能生成多少个新串
 * 10010 可以生成：10010 1010 1001 110 101 11 10 01 1.
 * https://www.nowcoder.com/discuss/870963?type=all&order=recall&pos=&page=1&ncTraceId=&channel=-1&source_id=search_all_nctrack&gio_id=849BB49B57B86B1C2B598C045E5BDC1B-1648385503023
 * @Author: Twiss
 * @Date: 2022/3/27 11:36 下午
 */
public class ExpressProblem {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//乡村数量
        int m = in.nextInt();//单向道路数量
        int k = in.nextInt();//双向道路数量
        int s = in.nextInt() - 1;//快递站所在编号
        int[][] singlePathLoad = new int[m][3];
        int[][] doublePathLoad = new int[k][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) singlePathLoad[i][j] = in.nextInt();
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 3; j++) doublePathLoad[i][j] = in.nextInt();
        }
        int a = in.nextInt();//当面取件耗时，t为奇数
        int b = in.nextInt();//快递柜耗时,t为偶数
        int q = in.nextInt();//快递数量
        int[] bags = new int[q];
        for (int i = 0; i < q; i++) bags[i] = in.nextInt() - 1;
        int[][] minPath = prim(singlePathLoad, doublePathLoad, n);
        System.out.println(timeNeeded(minPath, a, b, bags, s));

    }

    public static int timeNeeded(int[][] path, int a, int b, int[] bags, int s) {
        int from = s;
        int time = 0;
        int cost;
        for (int i = 0; i < bags.length; i++) {
            int to = bags[i];
            cost = path[from][to];
            time += cost;
            if (time % 2 == 0) time += b;
            else time += a;
            from = to;
        }
        time += path[from][s];
        return time;

    }

    public static int[][] prim(int[][] singlePath, int[][] doublePath, int n) {
        int[][] path = new int[n][n];
        for (int[] Spath : singlePath) {
            int from = Spath[0] - 1, to = Spath[1] - 1, weight = Spath[2];
            if (from != to && path[from][to] == 0) {
                path[from][to] = weight;
            }
            if (path[from][to] > weight) path[from][to] = weight;
        }
        for (int[] Dpath : doublePath) {
            int dist1 = Dpath[0] - 1, dist2 = Dpath[1] - 1, weight = Dpath[2];
            if (dist1 != dist2) {
                if (path[dist1][dist2] == 0 || path[dist1][dist2] > weight) path[dist1][dist2] = weight;
                if (path[dist2][dist1] == 0 || path[dist2][dist1] > weight) path[dist2][dist1] = weight;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                else if (path[i][j] == 0) path[i][j] = 100000;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                for (int k = 0; k < n; k++) {
                    if (k == j || k == i) continue;
                    path[j][k] = Math.min(path[j][k], path[j][i] + path[i][k]);
                }
            }
        }
        return path;

    }
}
