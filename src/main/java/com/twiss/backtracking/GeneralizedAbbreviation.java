package com.twiss.backtracking;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/5/19 9:36 下午
 */
public class GeneralizedAbbreviation {

    private List<String> getGeneralizedAbbreviation2(String word) {
        List<String> res = new ArrayList<>();
        if (word == null || word.length() == 0) {
            return res;
        }
        dfs(word, 0, 0, "", res);
        return res;
    }

    private void dfs(String word, int i, int count, String cur, List<String> res) {
        if (i == word.length()) {
            if (count != 0) {
                cur += count;
            }
            res.add(cur);
            return;
        }
        // 从低向上遍历，即先找到4
        // 其次在找到3d
        // 在找到2r1--->然后走后面逻辑寻找2rd
        // 1o2--->然后走后面逻辑寻找1o1d/1or1/1ord
        dfs(word, i + 1, count + 1, cur, res);

        if (count != 0) {
            cur += count;
        }
        cur += word.charAt(i);
        dfs(word, i + 1, 0, cur, res);
    }


    /**
     * << : 左移运算符，num << 1,相当于num乘以2
     * >> : 右移运算符，num >> 1,相当于num除以2
     *
     * @param word
     * @return
     */
    private List<String> getGeneralizedAbbreviation(String word) {
        List<String> res = new ArrayList<>();
        if (word == null) {
            return res;
        }
        char[] newWord = word.toCharArray();
        for (int i = 0; i < 1 << word.length(); i++) {
            res.add(abbr(i, newWord));
        }
        return res;
    }

    private String abbr(int num, char[] newWord) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (int j = 0; j < newWord.length; j++, num >>= 1) {
            // 0表示不缩写当前char，1表示缩写当前char
            if ((num & 1) == 0) {
                // 先加上之前的非0，再把count清零操作
                if (count != 0) {
                    stringBuilder.append(count);
                    count = 0;
                }
                stringBuilder.append(newWord[j]);
            } else {
                count++;
            }
        }
        // 最后把非零的count不要忘记加入stringBuilder中
        if (count != 0) {
            stringBuilder.append(count);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String word = "word";
        List<String> res = new GeneralizedAbbreviation().getGeneralizedAbbreviation(word);
        System.out.println(JSONObject.toJSONString(res));
        List<String> res2 = new GeneralizedAbbreviation().getGeneralizedAbbreviation2(word);
        System.out.println(JSONObject.toJSONString(res2));
    }
}
