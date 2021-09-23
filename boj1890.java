import java.io.*;
import java.util.StringTokenizer;
public class Main {
	// 1890 점프 
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n+1][n+1];
		long[][] dp = new long[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}	
		}
		
		dp[1][1] = 1;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(dp[i][j]==0 || (i==n && j==n)) {
					continue;
				}
				
				int next_x = arr[i][j] + i;
				int next_y = arr[i][j] + j;
				
				if(next_x <=n && next_x > 0) {
					dp[next_x][j] += dp[i][j]; 
				}
				if(next_y <=n && next_y > 0) {
					dp[i][next_y] += dp[i][j];
				}
				
			}
		}
		
		System.out.println(dp[n][n]);
		
	
		
	}
}
