package com.zkp.dfs;
/**题78
 *给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        res.add(new ArrayList<>());
        backTracking(nums,0,temp);
        return res;
    }

    private void backTracking(int[] nums,int beginIndex,List<Integer> temp){
        res.add(new ArrayList<>(temp));//每一种子集都加入到结果集中
        if (temp.size() == nums.length){
            return;
        }
        for (int i = beginIndex; i < nums.length; i++) {
            temp.add(nums[i]);
            backTracking(nums,i + 1,temp);
            temp.remove(temp.size() - 1);
        }
    }
}
