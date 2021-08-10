import java.util.*;
import java.io.*;
public class boj1915 {
	// 1915 가장 큰 정사각형 -> 정사각형의 넓이 구하기 (dp) 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int result = 0; // 정사각형의 넓이
		
		int[][] map = new int[n][m];
		int[][] dp = new int[n][m];
		
		for(int i=0;i<n;i++) {
			String[] s = br.readLine().split("");
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(s[j]);
				if(map[i][j]==1) {
					dp[i][j]=1;
					result = 1;
				}
			}
		}
		
		for(int i=1;i<n;i++) {
			for(int j=1;j<m;j++) {
				if(map[i][j]==1) {
					dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
					result = Math.max(dp[i][j], result);
				}
			}
		}
		
		System.out.println(result*result);
		
		
	}

}
