package com.twiss.shopee;

/**
 *
 * @Author: Twiss
 * @Date: 2022/4/6 7:49 下午
 */
public class GetMinCalculateCountOper {

    public long upBound;
    public long GetMinCalculateCount(long sourceX, long sourceY, long targetX, long targetY){
        if (sourceX>targetX||sourceY>targetY){
            return -1;
        }
        if (sourceX==targetX&&sourceY==targetY){
            return 1;
        }
        upBound = Math.max(Math.abs(targetX-sourceX),Math.abs(targetY-sourceY));
        dfs(sourceX,sourceY,targetX,targetY,0);
        return upBound;
    }

    public void dfs(long sourceX, long sourceY, long targetX, long targetY,int count){
        if (count==upBound||sourceX>targetX||sourceY>targetY){
            return;
        }
        if (sourceX==targetX&&sourceY==targetY){
            upBound = count;
            return;
        }
        dfs(sourceX*2,sourceY*2,targetX,targetY,count+1);
        dfs(sourceX+1,sourceY+1,targetX,targetY,count+1);
    }

    public static void main(String[] args) {
        long x = 10, y =100;
        long tx = 22, ty = 202;
        long ans = new GetMinCalculateCountOper().GetMinCalculateCount(x,y,tx,ty);
        System.out.println(ans);
    }
}
