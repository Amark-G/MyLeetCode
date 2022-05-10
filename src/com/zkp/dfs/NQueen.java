package com.zkp.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueen {
    private static List<List<String>> res;
    private int n;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        boolean[] colFlag = new boolean[n];
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        List<String> temp = new ArrayList<>();
        this.n = n;
        backTracking(0, colFlag, diagonals1, diagonals2, temp);
        return res;
    }

    private void backTracking(int row, boolean[] colFlag, Set<Integer> diagonals1, Set<Integer> diagonals2, List<String> temp) {
        if (row == n) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!colFlag[col] && !diagonals1.contains(row + col) && !diagonals2.contains(row - col)) {
                colFlag[col] = true;
                diagonals1.add(row + col);
                diagonals2.add(row - col);
                String strRow = getStr(n, col);
                temp.add(strRow);
                backTracking(row + 1, colFlag, diagonals1, diagonals2, temp);
                temp.remove(temp.size() - 1);
                diagonals1.remove(row + col);
                diagonals2.remove(row - col);
                colFlag[col] = false;
            }
        }
    }

    //获取当前行放置皇后以后的结果
    private String getStr(int n, int col) {
        StringBuilder res = new StringBuilder("");
        res.append(".".repeat(n));
        res.setCharAt(col, 'Q');
        return res.toString();
    }

}
