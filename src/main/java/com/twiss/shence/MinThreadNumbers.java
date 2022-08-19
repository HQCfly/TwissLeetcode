package com.twiss.shence;

import java.util.Scanner;

/**
 * @Author: Twiss
 * @Date: 2022/8/19 3:00 下午
 */
public class MinThreadNumbers {

    public int getThreadNumbers(String logs){
        if (logs==null||logs.length()==0){
            return -1;
        }
        int len = logs.length();
        int k = len/6;
        int nums = 0;
        boolean[] visited = new boolean[len];
        while (k>0){
            int idx = 0;
            StringBuilder target = new StringBuilder();
            for (int i=0;i<len;i++){
                char tmp = logs.charAt(i);
                if (tmp!='f'&&tmp!='a'&&tmp!='i'&&tmp!='l'&&tmp!='e'&&tmp!='d'){
                    return -1;
                }
                if (idx==0&&tmp=='f'&&!visited[i]){
                    visited[i] = true;
                    idx++;
                    target.append(tmp);
                }else if (idx==1&&tmp=='a'&&!visited[i]){
                    visited[i] = true;
                    idx++;
                    target.append(tmp);
                }else if (idx==2&&tmp=='i'&&!visited[i]){
                    visited[i] = true;
                    idx++;
                    target.append(tmp);
                }else if (idx==3&&tmp=='l'&&!visited[i]){
                    visited[i] = true;
                    idx++;
                    target.append(tmp);
                }else if (idx==4&&tmp=='e'&&!visited[i]){
                    visited[i] = true;
                    idx++;
                    target.append(tmp);
                }else if (idx==5&&tmp=='d'&&!visited[i]){
                    visited[i] = true;
                    idx++;
                    target.append(tmp);
                }

                if (target.length()==6&&target.toString().equals("failed")){
                    nums++;
                    target = new StringBuilder();
                }
            }
            k--;
        }

        int countVisited = 0;
        for (int i=0;i<len;i++){
            if (visited[i]){
                countVisited++;
            }
        }
        if (countVisited==len){
            nums = 1;
        }
        return nums==0?-1:nums;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String logs = sc.nextLine();
        int ans = new MinThreadNumbers().getThreadNumbers(logs);
        System.out.println(ans);
    }
}
