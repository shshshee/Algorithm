import java.util.*;
import java.io.*;
public class boj9465 {
	// 9465번 스티커 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine()); // 테스트케이스 갯수
		
		for(int i=0;i<t;i++) {
			int n = Integer.parseInt(br.readLine());
		
			int[][] cost = new int[2][n+1];
			int[][] dp = new int[2][n+1];

			
			for(int k=0;k<2;k++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=1;j<=n;j++) {
					cost[k][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][1] = cost[0][1];
			dp[1][1] = cost[1][1];
			
			for(int k=2;k<=n;k++) {
				dp[0][k] = Math.max(dp[1][k-1], dp[1][k-2]) + cost[0][k];
				dp[1][k] = Math.max(dp[0][k-1], dp[0][k-2]) + cost[1][k];
			}
			
			System.out.println(Math.max(dp[0][n], dp[1][n]));
			
		}
		 
		
		
		
	}

}
