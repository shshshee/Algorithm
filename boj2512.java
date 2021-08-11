import java.util.*;
import java.io.*;
public class boj2512 {
	// 예산 - 이분탐색
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int total=0;
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			total+=arr[i];
			
		}
		
		int M = Integer.parseInt(br.readLine()); // 총 예산
		
		Arrays.sort(arr); // 이분탐색을 위한 오름차순 정렬
		
		if(total<=M) {
			System.out.println(arr[N-1]);
		}else {
			
			int left = 0;
			int right = arr[N-1]; // 가장 높은 금액
			
			while(left<=right) {
				int mid = (left+right)/2;
				int sum = 0;
				for(int money : arr) {
					if(money>=mid) {
						sum+=mid;
					}else {
						sum+=money;
					}
				}
			
				if(sum<=M) { // 예산 더 배분할 수 있는 경우
					total = mid;
					left = mid+1;
				}else { // 예산 줄이기
					right = mid-1;
				}
			}
			
			System.out.println(total);
		}
		
		
	}

}
