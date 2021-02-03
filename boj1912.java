import java.util.*;
import java.io.*;

public class boj1912 {
	//백준 1912번 연속합 (dp)
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = arr[1];
		int max = dp[1];
		
		for(int i=2;i<=n;i++) {
			dp[i] = Math.max(dp[i-1]+arr[i],arr[i]);
			max = Math.max(max,dp[i]);
		}
		
		System.out.println(max);
		
	}

}
D