package com.zkp.tree;

import java.security.cert.PolicyQualifierInfo;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树的 根节点 root，
 * 请找出该二叉树的 最底层 最左边 节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 */
public class FindBottomLeftValue {
    //右向左层次遍历
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node = root;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.right != null) queue.offer(node.right);
            if (node.left != null) queue.offer(node.left);
        }

        return node.val;
    }

}
