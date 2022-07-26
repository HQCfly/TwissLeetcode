package com.twiss.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 最短路径
 * @Author: Twiss
 * @Date: 2022/7/26 10:29 上午
 */
public class MinDistancePath {

    private boolean[][] mark;
    private static int m,n;
    private List<Integer> path;

    public List<Integer> getPath(int[][] grids,int startX,int startY){
        if (grids==null||grids.length==0){
            return null;
        }
        mark = new boolean[m][n];
        path = new ArrayList<>();
        dfs(grids,startX,startY,new ArrayList<>());
        return path;
    }

    private boolean dfs(int[][] grids, int x,int y,List<Integer> tmpPath){
        // 递归出口
        if (grids[x][y]==1){
            if (path.size()>0){
                if (path.size()>tmpPath.size()){
                    path.clear();
                    path.addAll(tmpPath);
                }else if (path.size()==tmpPath.size()){
                    List<Integer> cPath = compare(path,tmpPath);
                    path.clear();
                    path.addAll(cPath);
                }
            }else {
                path.addAll(tmpPath);
            }
            return true;
        }
        boolean flag = false;
        int[][] direct = {{1,0},{0,1},{0,-1},{-1,0}};
        for (int i=0;i<4;i++){
            int newX = direct[i][0]+x;
            int newY = direct[i][1]+y;
            // 超出范围，或者遇到障碍跳过
            if (newX < 0 || newX > m-1 ||
                    newY<0 || newY> n-1||
                    grids[newX][newY]==2){
                continue;
            }
            // 优先考虑到1情况
            if (grids[newX][y]==1){
                // 如果是1，只能上下走，y不变的情况
                tmpPath.add(newX);
                tmpPath.add(y);
                dfs(grids,newX,y,tmpPath);
                tmpPath.remove(tmpPath.size()-1);
                tmpPath.remove(tmpPath.size()-1);
            } else if (grids[newX][newY] == 0 && !mark[newX][newY]){//下个点是0 且未做标记,上下左右走
                mark[newX][newY] = true;
                tmpPath.add(newX);
                tmpPath.add(newY);
                if (dfs(grids,newX, newY,tmpPath)) {
                    flag = true;
                }
                tmpPath.remove(tmpPath.size()-1);
                tmpPath.remove(tmpPath.size()-1);
                mark[newX][newY] = false;
            }
        }
        return flag;
    }

    private static List<Integer> compare(List<Integer> list1,List<Integer> list2){
        int size = list1.size();
        for (int i=0;i<size;i++){
            int list1A = list1.get(i);
            int list2A = list2.get(i);
            if (list1A>list2A){
                return list2;
            }
        }
        return list1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinDistancePath minDistancePath = new MinDistancePath();
        String[] init = sc.nextLine().split(" ");
        m = Integer.parseInt(init[0]);
        n = Integer.parseInt(init[1]);
        int startX = Integer.parseInt(init[2])-1;
        int startY = Integer.parseInt(init[3])-1;
        int[][] grids = new int[m][n];
        for (int i=0;i< m;i++){
            String[] arr = sc.nextLine().split(" ");
            for (int j=0;j<n;j++){
                grids[i][j] = Integer.parseInt(arr[j]);
            }
        }
//        int[][] grids = {
//                {0,0,0,0},
//                {2,1,0,1},
//                {0,0,0,0},
//        };
//        int startX = 0, startY = 0;
//        m = 3;
//        n = 4;
        List<Integer> tmp = minDistancePath.getPath(grids,startX,startY);

        StringBuilder ans = new StringBuilder();
        ans.append(startX+1).append(" ").append(startY+1).append(" ");
        for (Integer num : tmp) {
            ans.append(num + 1).append(" ");
        }
        System.out.println(new String(ans));
    }
}

