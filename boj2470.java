import java.util.*;
import java.io.*;
public class boj2470 {
	// 2470 두 용액 
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr); // 오름차순 정렬 
		int[] result = twoPointer(arr);
		
		System.out.println(result[0]+" "+result[1]);
		
	}
	
	static int[] twoPointer(int[] arr) {
		int sum = Integer.MAX_VALUE;
		int startPoint = 0, endPoint = arr.length-1;
		int[] result = new int[2];
		
		// 절대값이 가장 작은 수 
		while(true) {
			if(startPoint == endPoint) break;
			else {
				
				if(sum > Math.abs(arr[startPoint]+arr[endPoint])) {
					sum = Math.abs(arr[startPoint]+arr[endPoint]);
					result[0] = arr[startPoint];
					result[1] = arr[endPoint];
				}
				
				if(Math.abs(arr[startPoint+1]+arr[endPoint]) < Math.abs(arr[startPoint] + arr[endPoint-1])) {
					startPoint++;
				}else {
					endPoint--;
				}
					
			}
			
		}
		
		return result;
	}

}
