package com.zkp.firstPass.list;

/**JZ24 反转链表
 * 三个指针变量即可完成
 * @author zkp
 * @version 1.0
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while(null != head){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
