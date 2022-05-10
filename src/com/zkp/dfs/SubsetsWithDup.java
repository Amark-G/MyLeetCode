package com.zkp.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**题90
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
public class SubsetsWithDup {
    public List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        Arrays.sort(nums);
        backTracking(nums,0,temp,visit);
        return res;

    }
    private void backTracking(int[] nums,int beginIndex ,List<Integer> temp,boolean[] visit){
        res.add(new ArrayList<>(temp));
        if (temp.size() == nums.length) return;
        for (int i = beginIndex; i < nums.length; i++) {
            if (visit[i] || (i>0 && nums[i]==nums[i-1] && !visit[i-1])) continue;
            visit[i] = true;
            temp.add(nums[i]);
            backTracking(nums,i + 1,temp,visit);
            temp.remove(temp.size() - 1);
            visit[i] = false;
        }
    }

}
