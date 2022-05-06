package com.zkp.dfs;
/**题216
 * 找出所有相加之和为n 的k个数的组合，且满足下列条件：
 *
 * 只使用数字1到9
 * 每个数字最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。

 */

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backTracking(k,n,1,temp,0,0);
        return res;
    }
    private void backTracking(int k,int target,int beginIndex,List<Integer> temp,int sum,int count){
        if (count > k || sum > target )return;
        if (count == k && sum == target){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = beginIndex; i < 10; i++) {
            if (sum + i >target) continue;
            temp.add(i);
            sum += i;
            backTracking(k,target,i + 1,temp,sum,count + 1);
            temp.remove(temp.size() - 1);
            sum -= i;
        }
    }
}
