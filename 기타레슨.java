import java.util.*;
import java.io.*;
public class boj2343 {
	// 2343 기타레슨 - 이분탐색 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N]; 
		int total = 0;
		int max = -1;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			total += arr[i];
			max = Math.max(arr[i], max);
		}
		
		int left = max; // 최소 
		int right = total; //최대 
		int mid = 0;
		
		while(left<=right) {
			mid = (left + right)/2;
			int cnt = 0;
			int sum = 0;
			for(int i=0;i<N;i++) {
				if(sum + arr[i] > mid) {
					cnt++;
					sum=0;
				}
				sum += arr[i];
			}
			
			cnt++;
			
			if(cnt>M) {
				left = mid+1;
			}else {
				right = mid-1;
			}
			
		}
		
		System.out.println(left);
		
		
	}

}
