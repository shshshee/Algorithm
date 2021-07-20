import java.util.*;
import java.io.*;
public class boj14501 {
	// 14501 퇴사
	static int N;
	static int[][] arr;
	static int max=Integer.MIN_VALUE;
	
 	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0);
		System.out.println(max);
		
	}
 	 	
 	static void dfs(int idx, int maxprice) {
 		if(idx==N) {
 			max=Math.max(max, maxprice);
 			return;
 		}
 		
 		int t = arr[idx][0];
 		int p = arr[idx][1];
 		if(idx+t<=N) {
 			dfs(idx+t,maxprice+p);
 		}
 		
 		dfs(idx+1,maxprice);

 	}

}
