import java.util.*;
import java.io.*;
public class boj1654 {
	// 1654 랜선자르기 - 이분탐색 
	public static void main(String[] args) throws IOException {
	// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[k];
		
		for(int i=0;i<k;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr); //정렬 
		
		long left = 1;
		long right = arr[k-1];
		long result = 0; // 결과를 저장하기 위한 변수 선언
		long mid = 0;
		
		while(left<=right) {
			mid = (left+right)/2;
			int cnt = 0;
			
			for(int i=0;i<k;i++) {
			  	cnt += arr[i]/mid; // 나눈 나머지 
			}
			
			
			if(cnt>=n) {
				left = mid+1; // 간격 늘리기 
				result = mid;
			}else {
				right = mid-1;
			}
			
		}
		
		System.out.println(result);
		
	}

}
