package com.twiss.arraypractice;

import java.util.Stack;

public class FIndTheCelebrity {

    public static int findFamousPeople(int[][] candidates){
        Stack<Integer> people = new Stack<Integer>();
        if (candidates.length<=0) return -1;
        if (candidates.length==1) return 0;
        for (int i = 0; i < candidates.length; i++ ){
            people.push(i);
        }

        int a,b = 0;
        while (people.size()>1){
            a = people.pop();
            b = people.pop();
            if (knows(candidates,a,b)){
                people.push(b);
            }else {
                people.push(a);
            }
        }
        int c = people.pop();
        for (int i = 0; i<candidates.length;i++){
            if (i!=c&&knows(candidates,c,i)||!knows(candidates,i,c)){
                return -1;
            }
        }
        return c;
    }

    public static int findFamousPeople2(int[][] candidates){
        int res = 0;
        for (int i =1;i<candidates.length;i++){
            if (knows(candidates,res,i)) {
                res = i;
            }
        }
        for (int j =0;j<candidates.length;j++){
            if (j!=res && knows(candidates,res,j) || !knows(candidates,j,res)){
                return -1;
            }
        }
        return res;
    }

    public static boolean knows(int[][] candidates,int a,int b){
        return candidates[a][b] == 1;
    }

    public static void main(String[] args) {
        int[][] candidates ={{1,1,0},{0,1,0},{1,1,1}};
        int celebrity = findFamousPeople(candidates);
        System.out.println(celebrity);
        int celebrity2 = findFamousPeople2(candidates);
        System.out.println(celebrity2);
    }
}
