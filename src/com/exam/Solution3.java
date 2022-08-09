package com.exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author zkp
 * @version 1.0
 */
public class Solution3 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        /*int count = 1;
        Node root = null;
        Node pre = null;
        while (scanner.hasNextInt()){
            if (count == 1){
                root = new Node(scanner.nextInt());
                pre = root;
                count++;
            }
            Node cur = new Node(scanner.nextInt());
            pre.next = cur;
            pre = cur;
        }*/
        String input = scanner.nextLine();
        String[] str = input.split(" ");
        for (int i = 0; i < str.length; i++) {
            list.add(Integer.valueOf(str[i]));
        }
        Node root = new Node(list.get(0));
        Node newHead = sortList(root);
        Node start = newHead;
        while (start.next != null){
            System.out.print(start.val + ' ');
            start = start.next;
        }
        System.out.print(start.val);
    }
    private static Node sortList(Node head){
        if (head == null)
            return head;
        int len = 0;
        Node cur = head;
        while (cur != null){
            len++;
            cur = cur.next;
        }
        Node dumHead = new Node(0);
        dumHead.next = head;
        for (int subLen = 1; subLen < len; subLen <<=1) {
            Node pre = dumHead;
            Node curr = dumHead.next;
            while (curr != null){
                Node head1 = curr;
                for (int i = 1; i < subLen && curr.next != null; i++) {
                    curr = curr.next;
                }
                Node head2 = curr.next;
                for (int i = 1; i <subLen && curr!= null && curr.next!=null; i++) {
                    curr = curr.next;
                }
                Node next = null;
                if (curr != null){
                    next = curr.next;
                    curr.next = null;
                }
                //merge排序
                Node merge = merge(head1,head2);
                pre.next = merge;
                while (pre.next != null){
                    pre = pre.next;
                }
                curr = next;
            }
        }
        return dumHead.next;
    }
    private static Node merge(Node head1,Node head2){
        Node dumHead = new Node(0);
        Node temp = dumHead;
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != null && temp2 != null){
            if (temp1.val < temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            }else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null){
            temp.next = temp1;
        }else if(temp2 != null){
            temp.next = temp2;
        }
        return dumHead;
    }


}
class Node {
    int val;
    Node next;
    public Node(int val){
        this.val = val;
    }
}
