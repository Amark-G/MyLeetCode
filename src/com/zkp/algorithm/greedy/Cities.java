package com.zkp.algorithm.greedy;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 最少广播站覆盖全部城市
 */
public class Cities {
    public static void main(String[] args){
        //包含所有未覆盖的城市集合
        HashSet<String> allCities = new HashSet<>();
        allCities.add("北京");
        allCities.add("上海");
        allCities.add("天津");
        allCities.add("广州");
        allCities.add("深圳");
        allCities.add("成都");
        allCities.add("杭州");
        allCities.add("大连");
        //每个广播站及其对应覆盖的城市
        HashMap<String, HashSet<String>> hashMap = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        hashMap.put("K1",hashSet1);
        hashMap.put("K2",hashSet2);
        hashMap.put("K3",hashSet3);
        hashMap.put("K4",hashSet4);
        hashMap.put("K5",hashSet5);

        //结果集合
        HashSet<String> res = new HashSet<>();
        //查看每个广播站与未覆盖区域的交集
        HashSet<String> tempSet = new HashSet<>();

        //遍历后最大交集的广播站
        String MaxKey = null;

        while (!allCities.isEmpty()){
            //每次遍历hashMap前将MaxKey置空
            MaxKey = null;
            Set<String> set = hashMap.keySet();

            for (String k : set) {
                tempSet.clear();
                HashSet<String> areas = new HashSet<String>();
                areas = hashMap.get(k);
                tempSet.addAll(areas);
                tempSet.retainAll(allCities);
                //以下是贪婪算法的关键
                //tempSet.size() > 0 是为了保证无交集的时候改变MaxKey
                if (tempSet.size() > 0 && (MaxKey == null || tempSet.size() > hashMap.get(MaxKey).size())){
                    MaxKey = k;
                }
            }
            res.add(MaxKey);
            //将MaxKey指向的城市在allCities中移除
            allCities.removeAll(hashMap.get(MaxKey));
        }
        System.out.println("结果集为" + res);
    }

}
