package com.twiss.arraypractice;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static Boolean containsDuplicates(int[] arrays){
        Set<Integer> numbersSet = new HashSet<Integer>();
        for (int i=0;i<arrays.length;i++){
            if (!numbersSet.contains(arrays[i])){
                numbersSet.add(arrays[i]);
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arrays = {1,1,4,2,7,3};
        Boolean res = containsDuplicates(arrays);
        System.out.println(res);
    }
}
