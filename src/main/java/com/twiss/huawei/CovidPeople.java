package com.twiss.huawei;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

//L S
//6 5
//A B C D E
//F G H I J
//K L M N O
//P Q R S T
//U V W X Y
//Z 0 1 2 3

/**
 *
 * @Author: Twiss
 * @Date: 2022/8/17 7:35 下午
 */
public class CovidPeople {

    public List<String> getPeople(String[][] people, List<int[]> axi) {
        int[][] direct = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int m = people.length;
        int n = people[0].length;
        List<String> touch = new ArrayList<>();
        List<int[]> touchIndex = new ArrayList<>();
        for (int i = 0; i < direct.length; i++) {
            for (int j=0;j<axi.size();j++){
                int x = axi.get(j)[0];
                int y = axi.get(j)[1];
                int newX = x + direct[i][0];
                int newY = y + direct[i][1];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
                    continue;
                }
                touchIndex.add(new int[]{newX, newY});
            }

        }
        List<int[]> secondTouchIndex = new ArrayList<>();
        for (int i = 0; i < touchIndex.size(); i++) {
            int touchX = touchIndex.get(i)[0];
            int touchY = touchIndex.get(i)[1];
            String peo = people[touchX][touchY];
            if (!touch.contains(peo)) {
                touch.add(peo);
            }
            Collections.sort(touch);
            for (int j = 0; j < direct.length; j++) {
                for (int k=0;k<axi.size();k++){
                    int x = touchX;
                    int y = touchX;
                    int newX = x + direct[j][0];
                    int newY = y + direct[j][1];
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n|| (newX == x && newY == y)) {
                        continue;
                    }
                    secondTouchIndex.add(new int[]{newX, newY});
                }
            }
        }
        for (int i = 0; i < secondTouchIndex.size(); i++) {
            int touchX = secondTouchIndex.get(i)[0];
            int touchY = secondTouchIndex.get(i)[1];
            String peo = people[touchX][touchY];
            if (!touch.contains(peo)) {
                touch.add(peo);
            }

        }
        return touch;
    }


    public static void main(String[] args) {
//        String[][] people = {
//                {"A","B","C","D","E"},
//                {"F","G","H","I","J"},
//                {"K","L","M","N","O"},
//                {"P","Q","R","S","T"},
//                {"U","V","W","X","Y"},
//                {"Z","0","1","2","3"},
//        };
//        int x = 2, y =1;
        Scanner sc = new Scanner(System.in);
        String[] covid = sc.nextLine().split(" ");
        String[] config = sc.nextLine().split(" ");

        int m = Integer.parseInt(config[0]);
        int n = Integer.parseInt(config[1]);
        String[][] people = new String[m][n];
        List<int[]> axi = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] tmp = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                for (int k=0;k<covid.length;k++){
                    if (covid[k].equals(tmp[j])) {
                        axi.add(new int[]{i,j});
                    }
                }
                people[i][j] = tmp[j];
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i=0;i<axi.size();i++){
            List<String> tmp = new CovidPeople().getPeople(people, axi);
            System.out.println(JSONObject.toJSONString(tmp));
//            Collections.sort(tmp);
            if (ans.size()==0){
                ans = tmp;
            }else {
                for (int j=0;j<tmp.size();j++){
                    String p = tmp.get(j);
                    if (!ans.contains(p)){
                        ans.add(p);
                    }
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<ans.size();i++){
            if (i==0){
                stringBuilder.append("[").append(ans.get(i)).append(", ");
            }else if (i<ans.size()-1){
                stringBuilder.append(ans.get(i)).append(", ");
            }else {
                stringBuilder.append(ans.get(i)).append("]");
            }
        }
        System.out.println(new String(stringBuilder));
    }
}
