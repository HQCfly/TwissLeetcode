package com.twiss.arraypractice;

public class FindMinimumInRotatedSortedArrayII {

    public static int minNumber(int[] numbers, int low, int high){

        while (low<high){
            int mid = low+(high-low)/2;
            if (numbers[mid]<numbers[high]){
                high = mid;
            }else if (numbers[mid]>numbers[high]){
                low = mid+1;
            } else {
                high = high - 1;
            }
        }

        return numbers[low];
    }

    public static int minNumber2(int[] numbers, int low, int high) {

        if (low>high){
            return numbers[low];
        }

        int mid = low + (high-low)/2;

        if (numbers[mid] < numbers[high]){
            return minNumber2(numbers,low,mid);
        } else if (numbers[mid] > numbers[high]){
            return minNumber2(numbers,mid+1,high);
        } else {
            return minNumber2(numbers,low,high-1);
        }


    }

    public static void main(String[] args) {
        int[] numbers = {2,2,2,0,1};
        int res = minNumber(numbers,0,numbers.length-1);
        System.out.println(res);
        int res2 = minNumber2(numbers,0,numbers.length-1);
        System.out.println(res2);
    }
}
