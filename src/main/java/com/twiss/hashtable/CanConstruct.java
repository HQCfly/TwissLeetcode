package com.twiss.hashtable;

/**
 * 赎金信
 * @Author: Twiss
 * @Date: 2022/6/3 6:51 下午
 */
public class CanConstruct {

    public boolean isValid(String ransomNote, String magazine){
        int[] record = new int[26];
        int tmp;
        for (int i=0;i<magazine.length();i++){
            record[magazine.charAt(i)-'a']++;
        }
        for (int j = 0;j<ransomNote.length();j++){
            tmp = record[ransomNote.charAt(j)-'a'];
            if(record[tmp]>0){
                record[tmp]--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "ab";
        boolean ans = new CanConstruct().isValid(ransomNote,magazine);
        System.out.println(ans);
    }
}
