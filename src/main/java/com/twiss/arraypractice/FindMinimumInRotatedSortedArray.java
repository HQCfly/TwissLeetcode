package com.twiss.arraypractice;

public class FindMinimumInRotatedSortedArray {

    public static int minNumber(int[] numbers){
        int low = 0, high = numbers.length-1 ;

        return search(numbers, low , high);
    }

    public static int search(int[] numbers, int low, int high){
        if (low > high ){
            return numbers[0];
        }

        int mid = low + (high - low) / 2;

        if (mid < numbers.length-1 && numbers[mid] > numbers[mid+1]){
            return numbers[mid+1];
        }

        if (mid > 0 && numbers[mid-1] > numbers[mid]){
            return numbers[mid];
        }

        if (numbers[mid] > numbers[high]){
            return search(numbers,mid+1,high);
        }else {
            return search(numbers,low,mid-1);
        }

    }

    public static void main(String[] args) {
        int[] numbers = {4,5,6,7,2,3};
        int res = minNumber(numbers);
        System.out.println(res);
    }
}
