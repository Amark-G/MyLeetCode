package com.zkp.dfs;

import com.zkp.tree.TreeNode;

import java.util.List;

public class BinaryTreePaths {

    public static void main(String[] args){

    }
    List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        backTracking(root,new StringBuilder(String.valueOf(root.val)));
        return res;
    }
    public void backTracking(TreeNode root,StringBuilder str){
        if (root.left == null && root.right == null){
            res.add(String.valueOf(str));
            return;
        }
        String temp  = String.valueOf(str);
        if (root.left != null){
            str.append("->").append(String.valueOf(root.left.val));
            backTracking(root.left,str);
            str = new StringBuilder(temp);
        }
        if (root.right != null){
            str.append("->").append(String.valueOf(root.right.val));
            backTracking(root.right,str);
            str = new StringBuilder(temp);
        }
    }
}
