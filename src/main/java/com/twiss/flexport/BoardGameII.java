package com.twiss.flexport;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 只能网斜前方走，能吃掉棋子
 * @Author: Twiss
 * @Date: 2022/8/21 4:30 下午
 */
public class BoardGameII {

    private char[][] board;
    private char[][] tmpBoard;

    public BoardGameII(){

    }

    public void move(int[] current, int[] target, boolean isNextPlayer){
        if (canMove(current,target,isNextPlayer)){
            if (isNextPlayer){
                tmpBoard[target[0]][target[1]] = '2';
            }else {
                tmpBoard[target[0]][target[1]] = '1';
            }
            board = tmpBoard.clone();

        }else {
            System.out.println("Target position couldn't arrival!");
        }
    }

    public boolean canMove(int[] current, int[] target, boolean isNextPlayer){
         tmpBoard = board.clone();
         int x = current[0];
         int y = current[1];
         int targetX = target[0];
         int targetY = target[1];
        return moveNextStep(tmpBoard,x,y,targetX,targetY,isNextPlayer);
    }

    private boolean moveNextStep(char[][] newBoard,
                                 int x,int y,
                                 int targetX,int targetY,
                                 boolean isNextPlayer){
        // 走出范围
        // ||白棋：已经走到x坐标小于目标坐标x了说明无法到达
        // ||黑棋：已经走到x坐标大于目标坐标x了说明无法到达
        if (x==targetX&&y==targetY){
            return true;
        }
        if (!inAreas(x,y)||
                (isNextPlayer&&(targetX>x))||
                (!isNextPlayer&&(targetX<x))){

            return false;
        }

        boolean ans = false;
        char tmp = newBoard[x][y];
        if (isNextPlayer){
            // 白旗走法
            newBoard[x][y] = '2';
            ans = moveNextStep(newBoard,x-1,y-1,targetX,targetY,isNextPlayer)||
                    moveNextStep(newBoard,x-1,y+1,targetX,targetY,isNextPlayer);
            if (!ans){
                newBoard[x][y] = tmp;
            }

        }else {
            // 黑旗走法
            newBoard[x][y] = '1';
            ans = moveNextStep(newBoard,x+1,y+1,targetX,targetY,isNextPlayer)||
                    moveNextStep(newBoard,x+1,y-1,targetX,targetY,isNextPlayer);
            if (!ans){
                newBoard[x][y] = tmp;
            }
        }
        return ans;
    }


    /**
     *
     * @param isNextPlayer 那个player的可能要走的steps
     * @return
     */
    public List<int[]> getAllNextStep(boolean isNextPlayer){
        List<int[]> allNextStep = new ArrayList<>();
        if (isNextPlayer){
            getNextStep(board.length-1, board.length-1, allNextStep,isNextPlayer);
        }else {
            getNextStep(0,0, allNextStep,isNextPlayer);
        }
        return allNextStep;
    }

    private void getNextStep(int i,int j,List<int[]> steps,boolean isNextPlayer){
        if (!inAreas(i,j)){
            return;
        }
        if (board[i][j]=='0'){
            steps.add(new int[]{i,j});
            return;
        }
        if (isNextPlayer){
            // 白旗走法
            if (board[i][j]=='2'){
                getNextStep(i-1,j-1,steps,isNextPlayer);
                getNextStep(i-1,j+1,steps,isNextPlayer);
            }

        }else {
            // 黑旗走法
            if (board[i][j]=='1'){
                getNextStep(i+1,j+1,steps,isNextPlayer);
                getNextStep(i+1,j-1,steps,isNextPlayer);
            }
        }
    }

    private boolean inAreas(int i,int j){
        return 0<=i&&i< board.length&&
                0<=j&&j<board.length;
    }


    public static void main(String[] args) {
        BoardGameII bg = new BoardGameII();
        int n = 4;
        bg.board = new char[][]{
                {'1','0','0','0'},
                {'0','1','0','0'},
                {'0','0','2','0'},
                {'0','0','0','2'}
        };
        List<int[]> black = bg.getAllNextStep(false);
        System.out.println(JSONObject.toJSONString(black));
        int[] current = {1,1};
        int[] target = {3,1};
        boolean ans = bg.canMove(current,target,false);
        System.out.println(ans);

        bg.move(current,target,false);
        System.out.println(JSONObject.toJSONString(bg.board));
    }
}
