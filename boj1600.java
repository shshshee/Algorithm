import java.util.*;
import java.io.*;
public class boj1600 {
	// 말이 되고픈 원숭이 - 동작 수의 최솟값 
	static int K;
	static int W,H;
	static int[][] map;
	static boolean[][][] visited;
	static class spot{
		int x;
		int y;
		int k;
		int cnt;
		public spot(int x, int y, int k, int cnt) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.cnt = cnt;
		}
	}
	static int result = Integer.MAX_VALUE;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}}; // 이동 방향 
	static int[][] hdir = {{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}}; // 말 이동 방향 
	static Queue<spot> q = new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		
		
		for(int i=0;i<H;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<W;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		q.add(new spot(0,0,K,0)); // 초기 원숭이 위치 0,0
		bfs();
		
		if(result==Integer.MAX_VALUE) {
			System.out.println("-1");
		}else {
			System.out.println(result);
		}
		
	}
	
	// bfs 
	static void bfs() {
		
		
		while(!q.isEmpty()) {
			spot s = q.poll();
			
			int x = s.x;
			int y = s.y;
			int k = s.k;
			int cnt = s.cnt;
			
			if(x==H-1 && y==W-1) {
				result = Math.min(result,cnt);
			}
			
			visited[x][y][k] = true;
			
			for(int i=0;i<4;i++) {
				int nx = x+dir[i][0];
				int ny = y+dir[i][1];
				
				if(nx>=0 && nx<H && ny>=0 && ny<W && map[nx][ny]!=1 &&!visited[nx][ny][k]) {
					visited[nx][ny][k] = true;
					q.add(new spot(nx,ny,k,cnt+1));
				}
				
			}
			
			if(k>0) {
				
				for(int i=0;i<8;i++) {
					int nx = x+hdir[i][0];
					int ny = y+hdir[i][1];
					
					if(nx>=0 && nx<H && ny>=0 && ny<W && map[nx][ny]!=1 && !visited[nx][ny][k-1]) {
						visited[nx][ny][k-1] = true;
						q.add(new spot(nx,ny,k-1,cnt+1));
					}
				}
				
			}
			
		}
		
	}

}
