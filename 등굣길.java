class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<puddles.length;i++){
            int x = puddles[i][0];
            int y = puddles[i][1];
            dp[x][y] = -1;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i==1 && j==1){
                    dp[1][1] = 1;
                }else if(dp[i][j] == -1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1])%1000000007;
                }
            }
        }

        answer = dp[m][n]%1000000007;

        return answer;
    }
}