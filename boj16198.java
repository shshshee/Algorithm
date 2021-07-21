import java.util.*;
import java.io.*;
public class boj16198 {
	// boj16198 에너지 모으기 
	static int N;
	static int[] arr;
	static boolean[] visited;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		dfs(N,0);
		
		System.out.println(max);
		
	}
	
	public static void dfs(int idx, int value) {
		if(idx==2) {
			max = Math.max(max, value);
			return;
		}
		
		for(int i=1;i<N-1;i++) {
			if(!visited[i]) {
				visited[i]=true;
				int eng = getEnergy(i);
				dfs(idx-1,value+eng);
				visited[i]=false;
			}
		}
		
	}
	
	public static int getEnergy(int idx) {
		int result = 0;
		if(!visited[idx+1]&&!visited[idx-1]) {
			result = arr[idx+1]*arr[idx-1];
		}else {
			int f = 0;
			int b = 0;
			
			for(int i=idx-1;i>=0;i--) {
				if(!visited[i]) {
					f=i;
					break;
				}
			}
			
			for(int i=idx+1;i<N;i++) {
				if(!visited[i]) {
					b=i;
					break;
				}
			}
			
			result = arr[f]*arr[b];
		}
		
		
		return result;
	}

}
