package DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MatrixChainMemo {
    static int[][] dp = new int[100][100];
    static int calculateMin(int[] arr,int i,int j){
        if(i==j)
            return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        dp[i][j] = Integer.MAX_VALUE;
        for(int k = i;k<j;k++){
            dp[i][j] = Math.min(dp[i][j],calculateMin(arr,i,k)+calculateMin(arr,k+1,j)+arr[i-1]*arr[k]*arr[j]);
        }
        return dp[i][j];
    }
    public static void main(String[] args) {
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int[] arr = {1,2,3,4};
        System.out.println(calculateMin(arr,1,arr.length-1));
    }
}
