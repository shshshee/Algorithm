import java.util.*;
import java.io.*;
public class sw1206 {
	// view 
	static int N;
	static int[] arr;
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1;tc<11;tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			result = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 하나씩 다 검사..? 
			for(int i=2;i<N-2;i++) {
				if(arr[i-2]<arr[i] && arr[i-1]<arr[i] && arr[i+1]<arr[i] && arr[i+2]<arr[i]) {
					int Max = Math.max(arr[i-2], arr[i-1]);
					Max = Math.max(Max, Math.max(arr[i+2],arr[i+1]));
					result+=arr[i]-Max;
				}
				
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
			
		}
		
		System.out.println(sb.toString());
		
		
	}

}
