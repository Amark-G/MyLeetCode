package com.zkp.LinkedList;

/**
 * @author zkp
 * @version 1.0
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }

}
