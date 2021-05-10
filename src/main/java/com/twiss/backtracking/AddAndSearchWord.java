package com.twiss.backtracking;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: Twiss
 * @Date: 2021/5/9 11:31 下午
 */
public class AddAndSearchWord {

    private static HashMap<Integer, HashSet<String>> map;

    public AddAndSearchWord() {
        map = new HashMap<>();
    }

    public static void addWord(String word) {
        int n = word.length();

        if (map.containsKey(n)) {
            HashSet<String> set = map.get(n);
            set.add(word);
        } else {
            HashSet<String> set = new HashSet<>();
            set.add(word);
            map.put(n, set);
        }
    }

    public static boolean searchWord(String word) {
        HashSet<String> set = map.getOrDefault(word.length(), new HashSet<String>());
        if (set.contains(word)) {
            return true;
        }
        for (String s : set) {
            if (equal(s, word)) {
                return true;
            }
        }
        return false;
    }

    public static boolean equal(String s, String word) {
        char[] c1 = s.toCharArray();
        char[] c2 = word.toCharArray();
        int n1 = s.length();
        int n2 = word.length();
        if (n1 != n2) {
            return false;
        }
        for (int i = 0; i < n2; i++) {
            if (c1[i]!=c2[i]&&c2[i]!='.'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        HashMap<String,Boolean> res = new HashMap<>();
        new AddAndSearchWord();
        addWord("bad");
        addWord("dad");
        addWord("mad");
        res.put("pad",searchWord("pad"));
        res.put("bad",searchWord("bad"));
        res.put("b..",searchWord("b.."));
        res.put(".ad",searchWord(".ad"));
        System.out.println(JSONObject.toJSONString(res));
    }
}
