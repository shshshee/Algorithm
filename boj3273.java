import java.util.*;
import java.io.*;
public class boj3273 {
	// 두수의합
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int X = Integer.parseInt(br.readLine());
		
		int start = 0; // 시작점 - 배열의 첫번째 인덱스 
		int end = N-1;
		int cnt = 0; // 갯수 
		int sum = 0; // 합 -> X랑 같아야함 
		
		
		// 투포인터
		while(start<end) {
			
			sum = arr[start]+arr[end];
			
			if(sum==X) {
				cnt++;
			}
			
			if(sum<=X) {
				start++;
			}else {
				end--;
			}
			
		}
		
		System.out.println(cnt);
			
		
	}

}
