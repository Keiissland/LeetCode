package com.keiissland.leetcode.part002;

import com.keiissland.leetcode.datastructure.ListNode;


public class Solution0019 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode nFastPointer = head;
        for (int i = 0; i < n; i++) {
            nFastPointer = nFastPointer.next;
        }

        if (nFastPointer == null) {
            head = head.next;
            return head;
        }

        nFastPointer = nFastPointer.next;

        ListNode prePointer = head;
        while (nFastPointer != null) {
            nFastPointer = nFastPointer.next;
            prePointer = prePointer.next;
        }

        prePointer.next = prePointer.next.next;

        return head;
    }
}