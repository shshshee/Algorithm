import java.io.*;
import java.util.*;

public class boj1931 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		int count = 1;
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr,new Comparator<int[]>() {
			@Override
			public int compare(int[] t1, int[] t2) {
				if(t1[1]==t2[1]) {
					return t1[0]-t2[0]; // 오름차순 정렬 
				} else {
					return t1[1]-t2[1]; // 오름차순 정렬 
				}
			}
		});
		
		int time = arr[0][1]; // 종료시간  
		
		for(int i=1;i<n;i++) {
			if(time<=arr[i][0]) {
				//종료시간이 시작시간보다 같거나 크면  
				time = arr[i][1];
				count ++;
			}
			
		}
	
		System.out.println(count);
	}
	
	

}
