package com.zkp.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author zkp
 * @version 1.0
 * 最浅叶子结点的和
 */

public class SumLeafValue {

    public static void main(String[] args){
        TreeNode node10 = new TreeNode(9);
        TreeNode node9 = new TreeNode(8);
        TreeNode node8 = new TreeNode(9,node9,node10);
        TreeNode node7 = new TreeNode(21);
        TreeNode node6 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4,null,node8);
        TreeNode node4 = new TreeNode(2);
        TreeNode node3 = new TreeNode(18,node6,node7);
        TreeNode node2 = new TreeNode(3,node4,node5);
        TreeNode node1 = new TreeNode(10,node2,node3);
        SumLeafValue test = new SumLeafValue();
        System.out.println(test.leafSum(node1));
        
    }
    public int leafSum(TreeNode root){
        if(root == null) return 0;
        int ret = 0;
        boolean flag = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!flag && !queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode cur = queue.poll();
                if(cur.left == null && cur.right == null){
                    //当前层所有叶子结点的和
                    ret += cur.val;
                    flag = true;
                }else{
                    if (cur.left != null)
                        queue.add(cur.left);
                    if (cur.right != null)
                        queue.add(cur.right);
                }
                size--;
            }
        }
        return ret;
    }
}
