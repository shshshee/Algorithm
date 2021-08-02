import java.util.*;
import java.io.*;
public class boj2206 {
	// 벽 부수고 이동하기 
	static int N;
	static int M;
	static int[][] map;
	static boolean[][][] visited;
	static int[][] dir = {{1,0},{0,1},{0,-1},{-1,0}};
	static int result;
	
	static class point {
		int x;
		int y;
		int dist;
		int cnt;
		
		public point(int x,int y,int dist,int cnt) {
			this.x=x;
			this.y=y;
			this.dist=dist;
			this.cnt=cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M][2]; // 벽을 부순 여부까지 체크하기 위해 삼차원배열로 선언
		
		for(int i=0;i<N;i++) {
			String[] str = br.readLine().split("");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		result = -1;
		bfs();
		
		System.out.println(result);
		
		
	}
	
	public static void bfs() {
		
		Queue<point> q = new LinkedList<>();
		q.add(new point(0,0,1,0));
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			point now = q.poll();
			
			if(now.x == N-1 && now.y == M-1) {
				result = now.dist;
				break;
			}
			
			for(int i=0;i<4;i++) {
				int dx = now.x + dir[i][0];
				int dy = now.y + dir[i][1];
				
				if(dx>=0 && dx<N && dy>=0 && dy<M) {
					if(map[dx][dy]==0) {
						// 방문하지 않았으며 벽이 없는 경우 
						if(!visited[dx][dy][now.cnt]) {
							visited[dx][dy][now.cnt]=true;
							q.add(new point(dx,dy,now.dist+1,now.cnt));
						}
					}else if(map[dx][dy]==1) {
						//부신적이 있거나 방문한 적이 있다면
						if(now.cnt !=0 || visited[dx][dy][now.cnt+1]) continue;
						visited[dx][dy][now.cnt+1]=true;
						q.add(new point(dx,dy,now.dist+1,now.cnt+1));
						
					}
				}
			}
			
		}
			
		
	}

}
