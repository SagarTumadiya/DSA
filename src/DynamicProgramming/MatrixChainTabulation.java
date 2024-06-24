package DynamicProgramming;

public class MatrixChainTabulation {
    static int calculateMin(int[] arr,int n){
        int[][] dp = new int[n][n];
        int i,j,k,L,q;
        for(L = 2;L<n;L++){
           for(i = 1;i<n-L+1;i++){
               j = i+L-1;
               if(i==j)
                   continue;
               for(k=1;k<j;k++){
                   q = dp[i][k]+dp[k+1][j] + arr[i-1]*arr[k]*arr[j];
                   if(q<dp[i][j])
                       dp[i][j] = q;
               }
           }
        }
        return dp[1][n-1];
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(calculateMin(arr,arr.length));
    }
}
