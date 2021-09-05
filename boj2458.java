import java.util.*;
import java.io.*;
public class boj2458 {
	// 2458 키순서
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); //학생들의 수 
		int m = Integer.parseInt(st.nextToken()); //비교 횟수 
		
		int result = 0;
		
		int[][] arr = new int[n+1][n+1];
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<n+1;j++) {
				arr[i][j] = 9999;
			}
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
		}
		
		floyd(arr,n+1);
		
		for(int i=1;i<n+1;i++) {
			int count = 0;
			for(int j=1;j<n+1;j++) {
				if(arr[i][j]<9999 || arr[j][i]<9999) {
					count ++;
				}
			}
			if(count == n-1) result ++;
			
		}
		
		System.out.println(result);
		
		
		
	}
	
	static void floyd(int[][] arr, int n) {
		for(int k=1;k<n;k++) {
			for(int i=1;i<n;i++) {
				for(int j=1;j<n;j++) {
					if(arr[i][j]>arr[i][k]+arr[k][j]) {
						arr[i][j] = arr[i][k]+arr[k][j];
					}
				}
			}
		}
	}

}
