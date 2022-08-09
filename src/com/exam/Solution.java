package com.exam;


import java.util.*;

/**
 * @author zkp
 * @version 1.0
 */
public class Solution {

    Map<Integer,Integer> map = new HashMap<>();
    int[] pre;
    public int[] solve (int[] xianxu, int[] zhongxu) {
        TreeNode root = buildTree(xianxu, zhongxu);//得到树的根节点
        List<Integer> ret = rightView(root);//得到右视图
        int[] res = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            res[i] = ret.get(i);
        }
        return res;
    }
    private TreeNode buildTree(int[] xianxu, int[] zhongxu){
        pre = xianxu;
        //创建逆向数组
        for (int i = 0; i < zhongxu.length; i++) {
            map.put(zhongxu[i],i);
        }
        return helper(0,0,zhongxu.length - 1);
    }
    private TreeNode helper(int p,int l,int r){
        if(l >  r) return null;
        int index = map.get(pre[p]);
        //创建根节点节点
        TreeNode root = new TreeNode(pre[p]);
        root.left = helper(p + 1,l,index - 1);//左子树
        root.right = helper(p + index -l + 1,index + 1,r);//右子树
        return root;
    }

    //获取二叉树的右视图
    private List<Integer> rightView(TreeNode root){
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);//加入根节点
        while (!queue.isEmpty()){
            int size = queue.size();
            TreeNode t = null;
            for (int i = 0; i < size; i++) {
                t = queue.poll();
                if (t.left != null)
                    queue.offer(t.left);
                if (t.right != null)
                    queue.offer(t.right);
            }
            ret.add(t.val);
        }
        return ret;
    }

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
}
