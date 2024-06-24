package DynamicProgramming;

public class LongestCommonSubsequence {
    static int calculateLCS(char[] A,char[] B,int m,int n){
        int[][] table = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    table[i][j] = 0;
                } else if(A[i-1]==B[j-1]){
                    table[i][j] = table[i-1][j-1] + 1;
                } else {
                    table[i][j] = Math.max(table[i-1][j],table[i][j-1]);
                }
            }

        }
        return table[m][n];
    }
    public static void main(String[] args) {

        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int m = s1.length();
        int n = s2.length();
        System.out.println("Longest common subsequence length: "+calculateLCS(s1.toCharArray(),s2.toCharArray(),m,n));
    }
}
