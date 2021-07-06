package com.twiss.sort;

/**
 * @Author: Twiss
 * @Date: 2021/7/6 10:35 上午
 */
public class ReversePairs {

    int count;

    public int getReverseCount(int[] numbers) {
        this.count = 0;
        merge(numbers, 0, numbers.length - 1);
        return count;
    }

    public void merge(int[] numbers, int left, int right) {
        int mid = left + ((right - left) >> 1);
        if (left < right) {
            // 左边的数组
            merge(numbers, left, mid);
            // 右边的数组
            merge(numbers, mid + 1, right);
            // 归并排序
            mergeSort(numbers, left, mid, right);
        }
    }

    public void mergeSort(int[] numbers, int left, int mid, int right) {
        // 存储临时排序后的数组
        int[] tempArr = new int[right - left + 1];
        int index = 0;
        int tempLeft = left, tempMid = mid + 1;

        while (tempLeft <= mid && tempMid <= right) {
            // 添加左子数组当前元素
            if (numbers[tempLeft] <= numbers[tempMid]) {
                tempArr[index++] = numbers[tempLeft++];
            } else {
                // 用来统计逆序对的个数，并添加右子数组到当前元素
                count += (mid - tempLeft + 1);
                tempArr[index++] = numbers[tempMid++];
            }
        }

        // 以上假如已添加完右子数组的元素，并且退出 while循环
        // 则执行把左边剩余的数移入数组中
        while (tempLeft <= mid) {
            tempArr[index++] = numbers[tempLeft++];
        }

        // 以上假如已添加完左子数组的元素，并且退出 while循环
        // 则执行把右边剩余的数移入数组中
        while (tempMid <= right) {
            tempArr[index++] = numbers[tempMid++];
        }

        // 把新排序好的数组覆盖到numbers数组中
        for (int k = 0; k < tempArr.length; k++) {
            numbers[k + left] = tempArr[k];
        }
    }

    public static void main(String[] args) {
        int[] numbers = {7, 5, 6, 4};
        int count = new ReversePairs().getReverseCount(numbers);
        System.out.println(count);
    }
}
