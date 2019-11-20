package com.keiissland.leetcode.part003;

import com.keiissland.leetcode.datastructure.ListNode;


public class Solution0021 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode resListHead;
        ListNode resList;

        ListNode pointer1;
        ListNode pointer2;

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            resListHead = l1;
            pointer1 = l1.next;
            pointer2 = l2;
        } else {
            resListHead = l2;
            pointer2 = l2.next;
            pointer1 = l1;
        }

        resList = resListHead;
        while (pointer1 != null || pointer2 != null) {

            if (pointer1 == null) {
                resList.next = pointer2;
                break;
            }

            if (pointer2 == null) {
                resList.next = pointer1;
                break;
            }

            if (pointer1.val > pointer2.val) {
                resList.next = new ListNode(pointer2.val);
                pointer2 = pointer2.next;
            } else if (pointer1.val < pointer2.val) {
                resList.next = new ListNode(pointer1.val);
                pointer1 = pointer1.next;
            } else {
                resList.next = new ListNode(pointer1.val);
                resList = resList.next;
                resList.next = new ListNode(pointer2.val);

                pointer1 = pointer1.next;
                pointer2 = pointer2.next;
            }

            resList = resList.next;
        }

        return resListHead;
    }
}