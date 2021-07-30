import java.util.*;
import java.io.*;
public class boj1937 {
	// 1937번 욕심쟁이 판다 
	static int[][] map;
	static int[][] dp;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static int N;

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		dp = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				ans	= Math.max(ans, dfs(i,j));
			}
		}
		
		System.out.println(ans);
		
	}
	
	static int dfs(int i,int j) {
		if(dp[i][j]!=0) return dp[i][j]; // 갱신된 지역 리턴 
		
		dp[i][j] = 1; 
		
		for(int k=0;k<4;k++) {
			int dx = i + dir[k][0];
			int dy = j + dir[k][1];
			
			if(dx>=0 && dx<N && dy>=0 && dy<N) {
				if(map[i][j]<map[dx][dy]) {
					// 이전 지역보다 크다면 
					dp[i][j] = Math.max(dp[i][j], dfs(dx,dy)+1);
				}
			}
			
		}
		
		
		return dp[i][j];
		
	}
	
	

}
