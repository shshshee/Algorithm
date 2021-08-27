import java.util.*;
import java.io.*;
public class boj2003 {
	// 2003 수들의 합 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(twoPointer(arr,m));
		
	}
	
	static int twoPointer(int[] arr, int m) {
		int count = 0;
		int startPoint = 0, endPoint = 0;
		int len = arr.length;
		int sum = 0;
		
		while(true) {
			// m이 sum보다 크면 값을 줄여서 m을 맞춰야 함
			if(sum >= m) {
				sum -= arr[startPoint++];
			}else if(endPoint >= len) {
				break;
			}else { // m보다 sum이 작으면 m을 맞춰야 하므로 현재 endInde를 한칸 앞으로 이동시키고 원소 값을 더해줌 
				sum += arr[endPoint++];
			}
			
			if(sum == m) {
				count++;
			}
		}
		
		return count;
	}

}
