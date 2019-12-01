package com.keiissland.leetcode.part0003;

import com.keiissland.leetcode.datastructure.ListNode;


public class Solution00024 {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode thirdNode = head.next.next;

        ListNode resHead = head.next;
        resHead.next = head;
        head.next = thirdNode;

        ListNode preCursor = resHead.next;
        ListNode curCursor = preCursor.next;

        while (curCursor != null && curCursor.next != null) {

            ListNode nextNode = curCursor.next;
            ListNode rearNode = nextNode.next;

            preCursor.next = nextNode;
            nextNode.next = curCursor;
            curCursor.next = rearNode;

            preCursor = preCursor.next.next;
            curCursor = preCursor.next;
        }

        return resHead;
    }
}