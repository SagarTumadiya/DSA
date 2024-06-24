package DynamicProgramming;

import java.util.Arrays;

public class MinCostPathMemo {
    static final int R = 3;
    static final int C = 3;
    static int min(int x,int y,int z){
        if(x<y){
            return x<z?x:z;
        } else {
            return y<z?y:z;
        }
    }
    static int minCostMemo(int[][] cost,int m,int n,int[][] memo){
        if(m<0 || n<0){
            return Integer.MAX_VALUE;
        } else if (m==0 && n==0) {
            return cost[m][n];
        }
        if(memo[m][n]!=-1){
            return memo[m][n];

        }
        memo[m][n] = cost[m][n]+min(minCostMemo(cost,m-1,n-1,memo),minCostMemo(cost,m-1,n,memo),minCostMemo(cost,m,n-1,memo));
        return memo[m][n];
    }
    static int minCost(int[][] cost,int m,int n){
        int[][] memo = new int[R][C];
        for(int[] row:memo){
            Arrays.fill(row,-1);
        }
        return minCostMemo(cost,m,n,memo);
    }

    public static void main(String[] args) {
        int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };

        System.out.println(minCost(cost, 2, 2));
    }
}
