package com.keiissland.leetcode.part0001;

import com.keiissland.leetcode.datastructure.ListNode;

public class Solution00002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode cursor1 = l1;
        ListNode cursor2 = l2;

        ListNode resHead = new ListNode(0);
        ListNode resCursor = resHead;

        int carry = 0;
        while (cursor1 != null || cursor2 != null || carry > 0) {

            int val1 = cursor1 == null ? 0 : cursor1.val;
            int val2 = cursor2 == null ? 0 : cursor2.val;

            int sum = val1 + val2 + carry;

            carry = sum / 10;

            resCursor.next = new ListNode(sum % 10);
            resCursor = resCursor.next;

            cursor1 = cursor1 == null ? null : cursor1.next;
            cursor2 = cursor2 == null ? null : cursor2.next;
        }

        return resHead.next;
    }
}
