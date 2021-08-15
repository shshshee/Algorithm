import java.util.*;
import java.io.*;
public class boj2193 {
	// 이친수 
	// 1. 0으로 시작하지 않는다
	// 2. 1이 두번 연속으로 나타나지 않는다. 
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // N자리 이친수 구하기
		
		long[] dp = new long[N+1];
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i=2;i<=N;i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[N]);
		
	}

}
