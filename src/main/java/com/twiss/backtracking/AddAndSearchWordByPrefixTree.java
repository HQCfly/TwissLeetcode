package com.twiss.backtracking;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

/**
 * @Author: Twiss
 * @Date: 2021/5/10 9:02 下午
 */
public class AddAndSearchWordByPrefixTree {
    static class TrieNode {
        TrieNode[] children;
        boolean flag = false;

        public TrieNode() {
            children = new TrieNode[26];
            flag = false;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    TrieNode root;

    public AddAndSearchWordByPrefixTree() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        char[] array = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.children[array[i] - 'a'] == null) {
                cur.children[array[i] - 'a'] = new TrieNode();
            }
            cur = cur.children[array[i] - 'a'];
        }
        cur.flag = true;
    }

    public boolean search(String word) {
        return searchWord(word, root);
    }

    private boolean searchWord(String word, TrieNode root) {
        char[] array = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (array[i] == '.') {
                for (int j = 0; j < 26; j++) {
                    if (cur.children[j]!=null){
                        if (searchWord(word.substring(i+1),cur.children[j])){
                            return true;
                        }
                    }
                }
                return false;
            }
            if (cur.children[array[i]-'a']==null){
                return false;
            }
            cur = cur.children[array[i]-'a'];
        }
        return cur.flag;
    }

    public static void main(String[] args) {
        TrieNode trieNode = new TrieNode();
        AddAndSearchWordByPrefixTree func = new AddAndSearchWordByPrefixTree();
        func.addWord("bad");
        func.addWord("dad");
        func.addWord("mad");
        HashMap<String,Boolean> res = new HashMap<>();
        res.put("pad",func.search("pad"));
        res.put("bad",func.search("bad"));
        res.put(".ad",func.search(".ad"));
        res.put("b..",func.search("b.."));
        System.out.println(JSONObject.toJSONString(res));
    }
}
