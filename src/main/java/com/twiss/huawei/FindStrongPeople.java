package com.twiss.huawei;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * 找到比自己强的人
 * @Author: Twiss
 * @Date: 2022/6/21 10:34 下午
 */
public class FindStrongPeople {

    public int[] getStrongPeople(int[][] people){
        if (people==null||people.length==0){
            return null;
        }
        Map<Integer,Integer> hashMap = new HashMap<>();
        for (int i=0;i<people.length;i++){
            int teacher = people[i][0];
            int student = people[i][1];
            // teacher大于student，说明该teacher的徒弟考试超过他
            if (teacher>student){
                hashMap.put(teacher,hashMap.getOrDefault(student,0)+1);
            }
            if (!hashMap.containsKey(student)){
                hashMap.put(student,0);
            }
        }
        int[] ans = new int[hashMap.keySet().size()];
        int index = 0;
        for (int key:hashMap.keySet()){
            ans[index] = hashMap.get(key);
            index++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int numLen = sc.nextInt();
            int[][] arr = new int[numLen][];
            int i = 0;
            // 放到此处
            sc.nextLine();
            while(i < numLen){
                String[] str = sc.nextLine().split(",");
                arr[i] = new int[]{Integer.parseInt(str[0]),Integer.parseInt(str[1])};
                i++;
            }
            int[] ans = new FindStrongPeople().getStrongPeople(arr);
            System.out.println(JSONObject.toJSONString(ans));
        }
    }
}
