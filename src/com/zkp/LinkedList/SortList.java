package com.zkp.LinkedList;

/**
 * @author zkp
 * @version 1.0
 */
public class SortList {


    public ListNode sort(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode fast = newHead,slow = newHead;
        while (slow != null && slow.next != null){
            fast = fast.next;
            slow = slow.next.next;
        }
        //slow走到中间节点了
        ListNode rHead = slow.next;
        slow.next = null;
        ListNode left = sort(head);
        ListNode right = sort(rHead);
        return merge(left,right);
    }

    private ListNode merge(ListNode left,ListNode right){
        if (left == null || right == null) return left == null ? right : left;
        ListNode head = left.val < right.val ? left : right;
        if (head == left)
            left = left.next;
        else
            right = right.next;

        ListNode cur = head;
        while (left != null && right != null){
            if (left.val < right.val){
                ListNode temp = left.next;
                cur.next = left;
                left.next = null;
                left = temp;
            }else {
                ListNode temp = right.next;
                cur.next = right;
                right.next = null;
                right = temp;
            }
            cur = cur.next;
        }
        if (left == null)
            cur.next = right;
        else
            cur.next = left;
        return head;
    }
}
