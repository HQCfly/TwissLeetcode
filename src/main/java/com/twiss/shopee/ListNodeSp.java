package com.twiss.shopee;

import com.twiss.microsoftII.ListNode;

/**
 * @Author: Twiss
 * @Date: 2022/3/22 9:10 下午
 */
public class ListNodeSp {
    int val;
    ListNodeSp next;

    ListNodeSp() {
    }

    ListNodeSp(int val) {
        this.val = val;
    }

    ListNodeSp(int val, ListNodeSp next) {
        this.val = val;
        this.next = next;
    }
}
