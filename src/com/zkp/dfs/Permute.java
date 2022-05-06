package com.zkp.dfs;
/**题46
 * 不含重复数的全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *
 */

import java.util.ArrayList;
import java.util.List;

public class Permute {
    List<List<Integer>> res;
    boolean[] visit ;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        visit = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        backTracking(nums,list,visit);
        return res;
    }
    private void backTracking(int[] nums,List<Integer> list,boolean[] visit){
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visit[i]){
                visit[i] = true;
                list.add(nums[i]);
                backTracking(nums,list,visit);
                list.remove(list.size()-1);
                visit[i] = false;
            }
        }
    }
}
