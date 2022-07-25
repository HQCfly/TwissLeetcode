package com.twiss.huawei;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * TopKURL
 * @Author: Twiss
 * @Date: 2022/7/25 3:40 下午
 */
public class TopKUrl {

    private HashMap<String,Integer> allUrl;
    private HashMap<String,Integer> top;
    private String minUrl;
    private int topNum = 10;

    /**
     * 保存URL地址出现的次数，并同步刷新topN的URL。topN只维护前N个URL地址
     * @param url
     * @return
     */
    public void saveUrl(String url){
        if (minUrl==null){
            minUrl = url;
        }
        // 当前url不在allURL中
        if (allUrl.containsKey(url)){
            allUrl.put(url,allUrl.get(url)+1);
        }else {
            allUrl.put(url,1);
        }
        // 1.topN为空，确定minUrl的值
        if (top.isEmpty()){
            top.put(url,1);
            minUrl = url;
        }else if (top.containsKey(url)){
            // 2.url在topN中，刷新访问量，重新计算minUrl
            top.put(url,top.get(url)+1);
            minUrl = compare(minUrl,url);
        }else if (!top.containsKey(url)&&top.size()<topNum){
            // 3.url不在topN中、且topN长度小于N，保存至topN中，重新计算min_url
            top.put(url,allUrl.get(url));
            minUrl = compare(minUrl,url);
        }else {
            // 4.url不在topN中、且topN长度超过N，临时保存至topN中、再对min_url做删除，最后重新计算min_url
            top.put(url,allUrl.get(url));
            List<Map.Entry<String,Integer>> sortedTop= getSortedTop();
            String key = sortedTop.get(sortedTop.size()-1).getKey();
            top.remove(key);
            minUrl = sortedTop.get(sortedTop.size()-1).getKey();
        }
    }

    public String getTopUrl(int n){
        List<Map.Entry<String,Integer>> sortedTop= getSortedTop();
        StringBuilder ans = new StringBuilder();
        for (int i=0;i<n;i++){
            ans.append(sortedTop.get(i).getKey());
            if (i!=n-1){
                ans.append(",");
            }
        }
        return new String(ans);
    }

    private List<Map.Entry<String,Integer>> getSortedTop(){

        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(top.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue() - o1.getValue());
            }
        });
        return list;
    }
    private String compare(String url1,String url2){
        if (allUrl.get(url1)>allUrl.get(url2)){
            return url2;
        }else if (allUrl.get(url1)<allUrl.get(url2)){
            return url1;
        }else if (url1.compareTo(url2)>0){
            return url2;
        }else if (url1.compareTo(url2)<=0){
            return url1;
        }else {
            return url1;
        }
    }

    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TopKUrl topk = new TopKUrl();
        topk.allUrl = new HashMap<>();
        topk.top = new HashMap<>();
        while (sc.hasNext()){
            String str = sc.nextLine();
            if (!isNumeric(str)){
                topk.saveUrl(str);
            }else{
                String ans = topk.getTopUrl(Integer.parseInt(str));
                System.out.println(ans);
            }
        }
    }
}
