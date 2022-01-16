import java.util.*;
import java.io.*;
public class boj1946 {
	// 1946 신입사원 - 그리디
	static int T;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 결과 저장
		
		T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N+1];
			
			for(int j=0;j<N;j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				arr[a] = b;
				
			}
			
			int result = 1; // 첫번째 포함
			int before = arr[1];
			
			for(int j=2;j<=N;j++) {
				if(before>arr[j]) {
					result++;
					before = arr[j];
				}
			}
			
			sb.append(result).append('\n');
			
		}
		
		System.out.println(sb.toString());
		
	}

}
