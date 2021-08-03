import java.util.*;
import java.io.*;
public class boj1987 {
	// 알파벳
	static int N;
	static int M;
	static char[][] arr;
	static boolean[] visited;
	static int max = 0;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		visited = new boolean[26];
		
		for(int i=0;i<N;i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		
		dfs(0,0,0);
		
		System.out.println(max);
		
	}
	
	public static void dfs(int x, int y, int cnt) {
		
		if(visited[arr[x][y]-'A']) {
			max = Math.max(cnt, max);
			return;
		}
		
		visited[arr[x][y]-'A']=true;
		
		for(int i=0;i<4;i++) {
			int dx = x + dir[i][0];
			int dy = y + dir[i][1];
			
			if(dx>=0 && dx<N && dy>=0 && dy<M) {
					dfs(dx,dy,cnt+1);
			}
		}
		
		visited[arr[x][y]-'A']= false;
	
			
	}


}
