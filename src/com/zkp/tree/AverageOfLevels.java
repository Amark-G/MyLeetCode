package com.zkp.tree;

import java.util.*;

/**
 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
 */
public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> res = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            double sum=0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum+=node.val;
                if(node.left!=null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            res.add(sum/size);
        }
        return res;
    }
}


