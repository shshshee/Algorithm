import java.util.*;
import java.io.*;
public class boj9372 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int[] ans = new int[T]; // 답을 저장하기 위한 배열
		
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken()); // 국가의 수 
			int m = Integer.parseInt(st.nextToken()); // 비행기 종류 
			
			for(int k=0;k<m;k++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
			}
			
			ans[i] = n-1;
			
			
		}
		
		for(int n : ans) {
			System.out.println(n);
		}
		
		
	}

}
