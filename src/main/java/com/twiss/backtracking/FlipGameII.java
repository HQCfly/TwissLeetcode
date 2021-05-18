package com.twiss.backtracking;

/**
 * 判断先手是否会赢。如果遇到++可以转成--，如果对手无法转，则表示当前选手赢
 *
 * @Author: Twiss
 * @Date: 2021/5/18 8:45 下午
 */
public class FlipGameII {

    private boolean canWin(String words) {
        // 从博弈论角度思考，
        // 1. 先从第二个字符开始判断，如果是++，换成了--之后，是否p2能够找到一个赢的方案。
        // 2. 如果p2能找到，说明p1会输。
        // 3. 如果p2找不到，说明p1会赢。
        char[] newWords = words.toCharArray();
        for (int i = 1; i < words.length(); i++) {
            if (newWords[i] == '+' && newWords[i - 1] == '+' &&
                    !canWin(words.substring(0, i - 1) + "--" + words.substring(i + 1))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String words = "++++";
        boolean res = new FlipGameII().canWin(words);
        System.out.println(res);
    }

}
