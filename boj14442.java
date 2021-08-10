import java.util.*;
import java.io.*;
public class boj14442 {
	// 벽 부수고 이동하기 2 
	static int N,M,K;
	static boolean[][][] visited;
	static int[][] map;
	static int[][] dir = {{1,0},{0,1},{0,-1},{-1,0}};
	static int result=0;
	static class point {
		int x;
		int y;
		int dist; // 거리 저장
		int cnt; // 벽 부순 횟수 저장 
		
		public point(int x,int y,int dist, int cnt) {
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
		K = Integer.parseInt(st.nextToken()); // 벽을 부술수 있는 횟수 
		
		map = new int[N][M];
		visited = new boolean[N][M][K+1]; // K만큼 벽을 부수기 가능
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		bfs();
		
		if(result==0) { // 벽을 부술수 없다면 -1 리턴
			System.out.println("-1");
		}else {
			System.out.println(result);
		}
		
	}
	
	//bfs 탐색 ->
	public static void bfs() {
		Queue<point> q = new LinkedList<>();
		q.offer(new point(0,0,1,0)); // 처음 시작점부터 1 count 해서 넣어주기
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			point now = q.poll();
			
			// 배열 끝까지 탐색을 완료한 경우 
			if(now.x == N-1 && now.y == M-1) {
				result = now.dist;
				break;
			}
			
			for(int i=0;i<4;i++) {
				int dx = now.x + dir[i][0];
				int dy = now.y + dir[i][1];
				
				if(dx >=0 && dx < N && dy >=0 && dy < M) {
					if(map[dx][dy]==0) {
						if(!visited[dx][dy][now.cnt]) {
							visited[dx][dy][now.cnt] = true;
							q.offer(new point(dx,dy,now.dist+1,now.cnt));
							
						}
						
					}else if(map[dx][dy]==1) {
						// 벽을 더이상 부술 수 없거나 (=횟수 초과) or 이미 방문한 경우
						if(now.cnt>=K || visited[dx][dy][now.cnt+1]) continue; 
						visited[dx][dy][now.cnt+1]=true; // 방문체크 , 이미 벽을 부수고 이동해왔기 때문에 현재 횟수 +1 하여 방문체크 해줌
						q.offer(new point(dx,dy,now.dist+1,now.cnt+1));
					}
				}
				
			}
		}
		
		
	}

}
