import java.util.*;
import java.io.*;
public class boj16926 {
	// 배열 돌리기 1
	static int N,M,R,D;
	static int[][] arr;
	static int[][] arr1;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		arr1 = new int[N][M];
		
		D = Math.min(N, M)/2;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<R;i++) {
			rotate(); // R만큼 회전 
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		

	}
	
	// 회전 
	public static void rotate() {
		for(int i=0;i<D;i++) {
			// 오 -> 왼 
			int tmp = arr[i][i];
			for(int j=1+i;j<M-i;j++) {
				arr[i][j-1] = arr[i][j];
				
			}
			
			// 상 -> 하 
			for(int j=1+i;j<N-i;j++) {
				arr[j-1][M-1-i] = arr[j][M-1-i];
			}
			
			// 왼 -> 오 
			for(int j=M-2-i;j>=0+i;j--) {
				arr[N-1-i][j+1] = arr[N-1-i][j];
			}
			
			// 하 -> 상 	
			for(int j=N-2-i;j>=1+i;j--) {
				arr[j+1][i] = arr[j][i];
			}
			
			arr[i+1][i] = tmp;
		}
	}
	
	

}
