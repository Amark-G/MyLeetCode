package com.zkp.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zkp
 * @version 1.0
 */
public class FinishCourse {
    List<List<Integer>> edges ;//edges[i]里包含了学习课程edges[i]才能学习的课程
    int[] visit ;//0 代表未学习的课程，1 代表正在学习的课程，2 代表还未学习的课程
    boolean ret = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        visit = new int[numCourses];
        //深度遍历edges，存在拓扑排序则返回true
        for (int i = 0; i < numCourses && ret; i++) {
            if (visit[i] == 0)
                dfs(i);
        }
        return ret;
    }
    private void dfs(int index){
        visit[index] = 1;
        for (Integer course : edges.get(index)) {
            if (visit[course] == 0){
                //学习该课程
                dfs(course);
                if (!ret) return;
            }else if(visit[course] == 1){
                //如果该课程正在学习，说明构成环
                ret = false;
                return;
            }
        }
        visit[index] = 2;
    }
}
