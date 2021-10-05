import java.util.*;
import java.io.*;
public class boj9251 {
	// 9251 LCS
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr1 = br.readLine().toCharArray();
		char[] arr2 = br.readLine().toCharArray();
		
		int[][] dp = new int[arr1.length+1][arr2.length+1];
		
		for(int i=1;i<=arr1.length;i++) {
			for(int j=1;j<=arr2.length;j++) {
				if(arr1[i-1]==arr2[j-1]) {
					// 같을 경우
					dp[i][j] = dp[i-1][j-1] + 1; 
				}else {
					// 같지 않으면
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		System.out.println(dp[arr1.length][arr2.length]);
		
		
		
	}

}
