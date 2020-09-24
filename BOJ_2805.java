import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// 2805번 나무 자르기 
	// m미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값 구하기 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr); // 정렬
		
		//이분탐색
		int min = 0; //최소길이
		int max = arr[arr.length-1]; //최대길이
		
		while(min<=max) {
			int mid = (min+max)/2;
			long result = 0;
            
			for(int num : arr) {
				if(num-mid > 0) {
					result += num-mid;
				}
			}
			
			if(result<M) {
				max = mid-1;
			}else{
				min = mid+1;
			}
		}
		
		System.out.print(max);
		
		br.close();
	}


}

