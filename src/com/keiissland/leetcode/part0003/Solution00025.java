package com.keiissland.leetcode.part0003;

import com.keiissland.leetcode.datastructure.ListNode;

import java.util.Stack;


public class Solution00025 {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode resHead = null;
        ListNode resCursor = null;

        Stack<ListNode> stack = new Stack<>();

        ListNode cursor = head;
        while (cursor != null) {

            for (int i = 0; i < k; i++) {

                if (cursor == null) {
                    if (resHead == null) {
                        resHead = head;
                    }
                    return resHead;
                }

                stack.push(cursor);
                cursor = cursor.next;
            }

            while (!stack.isEmpty()) {

                ListNode curNode = stack.pop();

                if (resHead == null) {
                    resHead = curNode;
                }

                if (resCursor == null) {
                    resCursor = curNode;
                } else {
                    resCursor.next = curNode;
                    resCursor = resCursor.next;
                }
            }

            if (resCursor == null) {
                return head;
            } else {
                resCursor.next = cursor;
            }
        }

        return resHead;
    }
}