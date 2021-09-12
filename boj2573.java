import java.util.*;
import java.io.*;
public class boj2573 {
	// 2573번 빙산 (0912)
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int[][] move = {{0,1},{0,-1},{1,0},{-1,0}}; //이동 좌표 (상,하,좌,우)
	
	static class ice{
		int x;
		int y;
		
		ice(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		
		while(true) {
			int iceNum = check();
			if(iceNum >= 2) {
				break;
			}else if(iceNum == 0) {
				time = 0;
				break;
			}
			melt();
			time++;
		}

		System.out.println(time);
		
	}
	
	
	static void melt() {
	
		Queue<ice> queue = new LinkedList<>();
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] != 0) {
					queue.add(new ice(i,j));
					visited[i][j] = true;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			
			ice cur = queue.poll();
			visited[cur.x][cur.y] = true;
			int cnt = 0;	
			
			for(int i=0;i<4;i++) {
				int dx = cur.x + move[i][0];
				int dy = cur.y + move[i][1];
				if(dx<0 || dx >= N || dy<0 || dy >= M) continue;
				if(!visited[dx][dy] && map[dx][dy] == 0) {
					cnt ++; //0 갯수 세기 
				}
			}
				
			int result = map[cur.x][cur.y]-cnt;
			if(result<0) result = 0;
				
			map[cur.x][cur.y] = result;	
			
			
			
		}
			
	}
	
	//덩어리 갯수 체크 
	static int check() {
		int result = 0;
		
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]!=0 && !visited[i][j]) {
					dfs(i,j);
					result ++; // 덩어리 갯수
				}
			}
		}
		
		
		return result;
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0;i<4;i++) {
			int dx = x + move[i][0];
			int dy = y + move[i][1];
			
            if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
                continue;
            }
            
            if(map[dx][dy] != 0 && !visited[dx][dy]) {
            	dfs(dx,dy);
            }
			
		}
		
		
		
	}
	
	

}
