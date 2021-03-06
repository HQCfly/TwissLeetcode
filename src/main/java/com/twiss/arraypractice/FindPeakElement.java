package com.twiss.arraypractice;

public class FindPeakElement {

    public static int findNumber(int[] numbers){

        int l = 0, r = numbers.length-1;
        while (l<r){
            int mid = l+(r-l)/2;
            if (numbers[mid] > numbers[mid+1]){
                r = mid;
            }else {
                l = mid+1;
            }
        }
        return l;
    }

    public static int findNumber2(int[] numbers){
        return search(numbers,0,numbers.length-1);
    }

    public static int search(int[] numbers,int l, int h){
        if (l>h){
            return -1;
        }
        int mid = l + (h-l)/2;
        if ((mid ==0 || numbers[mid]>numbers[mid-1])&&(mid==numbers.length-1||numbers[mid]>numbers[mid+1])){
            return mid;
        }
        if (numbers[mid]<numbers[mid+1]){
            return search(numbers,mid+1,h);
        }else {
            return search(numbers,l,mid-1);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,1,3,5,6,4};
        int res = findNumber(numbers);
        System.out.println("peek element index is: "+res);
        int res2 = findNumber2(numbers);
        System.out.println("peek element index is: "+res2);
    }
}
