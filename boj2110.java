import java.util.*;
import java.io.*;
public class boj2110 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 집 갯수 
		int C = Integer.parseInt(st.nextToken()); // 공유기 갯수
		
		int[] house = new int[N];
		
		for(int i=0;i<N;i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(house);
		
		int left = 1; // 최소거리 
		int right = house[N-1]-house[0]; // 최대거리 
		int d = 0;
		int result = 0;
		
		while(left<=right) {
			int mid = (left + right)/2; 
			int start = house[0];
			int cnt = 1; // 설치 갯수 count하기 위한 변수
			
			for(int i=1;i<N;i++) {
				d = house[i] - start;
				if(mid <= d) { // 거리를 만족한다면 
					cnt ++;
					start = house[i];
				}
			}
			
			
			
			if(cnt >= C) { // 설치된 공유기가 많다면 간격 늘리기 
				left = mid+1;
				result = mid;
			}else { // 간격 줄이기 
				right = mid-1;
			}
			
		}
		
		
		
		System.out.println(result); // 최대 간격 출력

	}

}
