package com.zkp.LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zkp
 * @version 1.0
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        //将每个链表的头节点放入优先队列
        for (int i = 0; i < lists.length; i++) {
            ListNode cur = lists[i];
            queue.offer(cur);
        }
        ListNode ret = new ListNode();
        ListNode cur = ret;
        while (!queue.isEmpty()){
            ListNode min = queue.poll();
            ListNode node = new ListNode(min.val);
            cur.next = node;
            cur = node;
            if (min.next != null){
                queue.offer(min.next);
            }
        }
        return ret.next;
    }
}
