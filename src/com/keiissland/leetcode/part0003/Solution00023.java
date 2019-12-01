package com.keiissland.leetcode.part0003;

import com.keiissland.leetcode.datastructure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;


public class Solution00023 {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode resHead = null;
        ListNode resCursor = null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        while (!queue.isEmpty()) {
            ListNode minNode = queue.poll();

            if (minNode == null) {
                break;
            }

            if (resHead == null) {
                resHead = minNode;
                resCursor = resHead;
            } else {
                resCursor.next = minNode;
                resCursor = resCursor.next;
            }

            ListNode curNode = minNode.next;
            if (curNode != null) {
                queue.offer(curNode);
            }

            resCursor.next = null;
        }

        return resHead;
    }
}