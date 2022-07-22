package com.zkp.firstPass.list;

import java.util.ArrayList;
import java.util.List;

/**JZ6 从尾到头打印链表
 * @author zkp
 * @version 1.0
 */

public class TailToHead {
    public static void main(String[] args){
       printListFromTailToHead(new ListNode(6));
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        List<Integer> ret = new ArrayList<>();
        ret.add(0,1);
        ret.add(0,9);
        ret.add(0,55);
        for (Integer integer : ret) {
            System.out.println(integer);
        }
        return null;
    }
}
