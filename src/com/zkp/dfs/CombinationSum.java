package com.zkp.dfs;
/**题39
 *给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。
 * 你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 *
 */

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backTracking(candidates,target,0,temp,0);
        return res;
    }
    private void backTracking(int[] candidates,int target,int beginIndex,List<Integer> temp,int sum){
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = beginIndex; i < candidates.length; i++) {
            if(sum + candidates[i] > target)continue;
            temp.add(candidates[i]);
            sum+=candidates[i];
            backTracking(candidates,target,i,temp,sum);
            temp.remove(temp.size() - 1);
            sum -= candidates[i];
        }
    }

}
