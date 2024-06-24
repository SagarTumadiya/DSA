package DynamicProgramming;

public class MinCostTabu {
    static int min(int x,int y,int z){
        if(x<y){
            return x<z?x:z;
        } else {
            return y<z?y:z;
        }
    }
    static int minCost(int[][] cost,int m,int n){
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = cost[0][0];
        for(int i=1;i<=m;i++)
            dp[0][i] = cost[0][i] + dp[0][i-1];
        for(int j=1;j<=n;j++)
            dp[j][0] = cost[j][0] + dp[j-1][0];
        for(int i=1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                dp[i][j] = cost[i][j] + min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };

        System.out.println(minCost(cost, 2, 2));
    }
}
