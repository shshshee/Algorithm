import java.util.*;
import java.io.*;

public class boj14719 {
	//14719 빗물 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[W];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<W;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		int right = 0;
		int mid = 0;
		int left = 0;
		
		for(int i=1;i<W-1;i++) {
			mid = arr[i]; // 빗물이 고일 수 있는 제일 작은 중간 값 
			right = 0;
			left = 0;
			
			//right 값 
			for(int k=i;k>=0;k--) {
				if(arr[k]>mid) {
					left = Math.max(left, arr[k]);
				}
			}
			//left값 
			for(int j=i;j<W;j++) {
				if(arr[j]>mid) {
					right = Math.max(right, arr[j]);
				}
			}
			
			if(Math.min(right, left)>mid) {
				count += (Math.min(right, left)-mid);
			}
		}
		
		System.out.println(count);
		
	}

}
