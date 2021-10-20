import java.util.*;
import java.io.*;
public class boj1926 {
	// 1926 그림 
	static int[][] map;
	static boolean[][] visited;
	static int cnt; // 그림 갯수
	static int max = Integer.MIN_VALUE; // 가장큰 너비 
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	static int N,M;
	static class node{
		int x;
		int y;
		public node(int x,int y) {
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		cnt = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visited[i][j] && map[i][j]==1) {
					visited[i][j] = true;
					bfs(i,j);
					cnt++; // 갯수 카운팅 
				}
			}
		}
		
		if(cnt==0) {
			max=0; // 그림이 하나도 없는 경우 
		}
		
		System.out.println(cnt);
		System.out.println(max);
		
	}
	
	static void bfs(int x,int y) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(x,y));
		int size = 0; // 각 그림 크기 구하기 
		
		while(!q.isEmpty()) {
			node cur = q.poll();
			size++;
			for(int i=0;i<4;i++) {
				int next_x = cur.x + dx[i];
				int next_y = cur.y + dy[i];
				if( next_x>=0 && next_x<N && next_y>=0 && next_y<M ) {
					if(map[next_x][next_y]==1 && !visited[next_x][next_y]) {
						visited[next_x][next_y]=true;
						q.add(new node(next_x,next_y));	
					}
				}
				
			}
		}
		
		max = Math.max(max, size);
		
	}

}
