import java.util.*;
import java.io.*;
public class boj6603 {
	//백준 6603 로또
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			if(N==0) break;
			int arr[] = new int[N];
			boolean[] visited = new boolean[N];
			
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			

			dfs(visited, arr, 0,0);
			System.out.println();

			
			
		}
		
	}
	
	public static void dfs(boolean[] visited, int arr[], int line, int count) {
		if(count == 6) {
			for(int i=0;i<arr.length;i++) {
				if(visited[i]) {
					System.out.print(arr[i]+" ");
				}
			}
			System.out.println("");
			return;
		}
		
		for(int i=line;i<arr.length;i++) {
			visited[i]=true;
			dfs(visited,arr,i+1,count+1);
			visited[i]=false;
			
		}
		
	}
}
