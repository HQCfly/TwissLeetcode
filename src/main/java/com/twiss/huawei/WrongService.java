package com.twiss.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 服务失效判断
 * @Author: Twiss
 * @Date: 2022/6/29 9:04 下午
 */
public class WrongService {

    public static boolean dfs(List<String[]> serviceReplay,String node,List<String> wrongService){
        if(wrongService.contains(node)){ //此时服务故障则返回true
            return true;
        }
        for(int i=0;i<serviceReplay.size();i++){
            if(serviceReplay.get(i)[0].equals(node) && dfs(serviceReplay,serviceReplay.get(i)[1],wrongService)){
                //如果此时服务依赖另外一个服务，则对依赖的服务进行一次故障判断，如为故障则返回true
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String[] s = sc.nextLine().split(",");
//            sc.nextLine();
            List<String> wrongService = Arrays.asList(sc.nextLine().split(","));
            List<String[]> serviceReplay = new ArrayList<>();
            List<String> allService = new ArrayList<>();
            for (int i=0;i<s.length;i++){
                String[] replay = s[i].split("-");
                serviceReplay.add(replay);
                String a = replay[0];
                String b = replay[1];
                if (!allService.contains(a)){
                    allService.add(a);
                }
                if (!allService.contains(b)){
                    allService.add(b);
                }
            }
            // 删除故障节点
            for (int i=0;i<wrongService.size();i++){
                allService.remove(wrongService.get(i));
            }
            // 获取正常的服务节点
            List<String> normalService = new ArrayList<>();
            for (int i=0;i<allService.size();i++){
                String node = allService.get(i);
                if (!dfs(serviceReplay,node,wrongService)){
                    normalService.add(node);
                }
            }
            if (normalService.size()==0){
                System.out.println(",");
            }else {
                String res = "";
                for (int i=0;i<normalService.size();i++){
                    res+=normalService.get(i);
                    if (i!=normalService.size()-1){
                        res+=",";
                    }
                }
                System.out.println(res);
            }
        }
    }
}
