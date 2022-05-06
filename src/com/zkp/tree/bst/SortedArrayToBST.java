package com.zkp.tree.bst;

import com.zkp.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**题108
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。

 */
public class SortedArrayToBST {
    public static void main(String[] args){
       int[] arr = {-10,-3,0,5,9};
        List<Integer> list = new ArrayList<Integer>();


        sortedArrayToBST(arr);
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        TreeNode root = buildBST(nums,0,len-1);
        return root;
    }
    public static TreeNode buildBST(int[] nums,int start,int end){
        if(start > end )return null;
        if(start == end) return new TreeNode(nums[start]);
        TreeNode root = new TreeNode(nums[start + (end - start)/2]);
        root.left = buildBST(nums,start,start + (end - start)/2-1);
        root.right = buildBST(nums,start + (end - start)/2 +1 ,end);
        return root;
    }
}
