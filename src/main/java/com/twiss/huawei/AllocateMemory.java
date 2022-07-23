package com.twiss.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 简易内存池
 *
 * @Author: Twiss
 * @Date: 2022/7/23 4:21 下午
 */
public class AllocateMemory {

    private TreeMap<Integer, Integer> allocateMemory;
    private int REQUEST_MEMORY_HEAD = 0;
    private int REQUEST_MEMORY_END = 100;

    public AllocateMemory() {
        allocateMemory = new TreeMap<>();
    }

    public String request(int size) {
        int addressHead = REQUEST_MEMORY_HEAD;
        if (size <= 0 || size > 100) {
            return "error";
        }
        if (allocateMemory.isEmpty()) {
            allocateMemory.put(addressHead, size);
        } else {
            List<Integer> headList = new ArrayList<>(allocateMemory.keySet());
            for (int i = 0; i < headList.size(); i++) {
                if (headList.get(i) - addressHead >= size) {
                    allocateMemory.put(addressHead, addressHead + size);
                } else {
                    addressHead = allocateMemory.get(headList.get(i));
                }
            }
            if (size <= REQUEST_MEMORY_END - addressHead) {
                allocateMemory.put(addressHead, addressHead + size);
            } else {
                return "error";
            }
        }
        return String.valueOf(addressHead);
    }

    public boolean release(int startAddress) {
        if (allocateMemory.containsKey(startAddress)) {
            allocateMemory.remove(startAddress);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        AllocateMemory memory = new AllocateMemory();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[][] lines = new String[n][2];
        for (int i = 0; i < n; i++) {
            lines[i] = sc.nextLine().split("=");
            if ("REQUEST".equals(lines[i][0])) {
                System.out.println(memory.request(Integer.parseInt(lines[i][1])));
            } else {
                boolean ret = memory.release(Integer.parseInt(lines[i][1]));
                if (!ret) {
                    System.out.println("error");
                }
            }
        }
    }
}
