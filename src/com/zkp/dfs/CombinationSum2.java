package com.zkp.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**题40
 * 给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 *
 * candidates中的每个数字在每个组合中只能使用一次。
 *
 * 注意：解集不能包含重复的组合。
 *

 */
public class CombinationSum2 {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        boolean[] visit = new boolean[candidates.length];
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(candidates,target,0,temp,0,visit);
        return res;
    }
    private void backTracking(int[] candidates,int target,int beginIndex,List<Integer> temp,int sum,boolean[] visit){
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = beginIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target ||(i>0 && !visit[i-1] && candidates[i]==candidates[i-1])) continue;
            visit[i] = true;
            temp.add(candidates[i]);
            sum += candidates[i];
            backTracking(candidates,target,i+1,temp,sum,visit);
            temp.remove(temp.size() - 1);
            sum -= candidates[i];
            visit[i] = false;
        }
    }
}
