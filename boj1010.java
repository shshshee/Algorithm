import java.util.*;
import java.io.*;
public class boj1010 {

	static int[][] dp = new int[30][30];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			System.out.println(combi(M,N));
		}
		
	}
	
	static int combi(int m, int n) {
		if(dp[m][n]>0) {
			return dp[m][n];
		}
		
		if(m==n || n==0) {
			return dp[m][n] = 1;
		}
		
		return dp[m][n] = combi(m-1,n-1) + combi(m-1,n);
		
		
	}

}
