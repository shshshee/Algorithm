import java.util.*;
import java.io.*;
public class boj2293 {
	// 백준 2293 동전1
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coin = new int[N+1];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			coin[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[10001];
		dp[0] = 1;
		
		for(int i=0;i<N;i++) {
			for(int j=coin[i];j<=K;j++) {
				dp[j] += dp[j-coin[i]]; 
			}
		}
		
		System.out.println(dp[K]);
		
		
		
		
		
		
		
	}

}
