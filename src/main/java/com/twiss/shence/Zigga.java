package com.twiss.shence;

import com.alibaba.fastjson.JSONObject;

import java.util.Scanner;

/**
 * @Author: Twiss
 * @Date: 2022/8/19 4:30 下午
 */
public class Zigga {

    public static int[] two2one(int[][] input,int N){
        int n=0,x=0,y=0;
        int[] output = new int[N+N];
        output[n] = input[x][y];
        n++;
        while (true){
            if (x==0&&y<=N-2){
                y++;
                output[n] = input[x][y];
                n++;
                while (true){
                    x++;
                    y--;
                    output[n] = input[x][y];
                    n++;

                    if(y==0){
                        break;
                    }
                }
            }

            if(y==0&&x<=N-2){
                x++;
                output[n] = input[x][y];
                n++;
                while (true){
                    x--;
                    y++;
                    output[n] = input[x][y];
                    n++;

                    if(x==0){
                        break;
                    }
                }
            }

            if (x==N-1&&y<N-2){
                y++;
                output[n] = input[x][y];
                n++;
                while (true){
                    x--;
                    y++;
                    output[n] = input[x][y];
                    n++;
                    if (y==N-1){
                        break;
                    }
                }
            }

            if (y==N-1&&x<N-2){
                x++;
                output[n] = input[x][y];
                n++;
                while (true){
                    x++;
                    y--;
                    output[n] = input[x][y];
                    n++;
                    if (x==N-1){
                        break;
                    }
                }
            }

            if (x==N-1&&y==N-2){
                y++;
                output[n] = input[x][y];
                break;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] input = new int[N][N];
        sc.nextLine();
        for (int i=0;i<N;i++){
            String[] tmp = sc.nextLine().split(" ");
            for (int j=0;j<N;j++){
                input[i][j] = Integer.parseInt(tmp[i]);
            }
        }
        int[] ans = two2one(input,N);
        StringBuilder sber = new StringBuilder();
        for (int i=0;i<ans.length;i++){
            sber.append(ans[i]).append(" ");
        }
        System.out.println(new String(sber));
    }
}
