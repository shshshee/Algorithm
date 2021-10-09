import java.util.*;
import java.io.*;
public class boj15683 {
	// 15683 감시
	static int N,M;
	static int[][] map;
	static int[][] copymap;
	static int[] dir;
	static int result = Integer.MAX_VALUE;
	static ArrayList<cctv> list = new ArrayList<>();
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static class cctv {
		int x;
		int y;
		cctv(int x,int y){
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
		copymap = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]>0 && map[i][j]<6) {
					list.add(new cctv(i,j));
				}
			}
		}
		
		dir = new int[list.size()];
		dfs(0,list.size());
		
		System.out.println(result);
		
		
	}
	
	// dfs 조합 구하기 
	static void dfs(int depth, int r) {
		if(depth == r) {
			copy(); // 배열 복사
			for(int i=0;i<list.size();i++) {
				watch(list.get(i),dir[i]);
			}
			getSpotCnt(); // 사각지대 count
			return;
		}
		
		// 중복순열 check
		for(int i=0;i<4;i++) {
			dir[depth] = i;
			dfs(depth+1,r);
		}
	}
	
	// 감시 - 방향 check
	static void watch(cctv cur, int d) {
		int num = map[cur.x][cur.y]; // 현재 cctv 방향
		if(num == 1) {
			if(d==0) {
				bfs(cur,0);
			}else if(d==1) {
				bfs(cur,1);
			}else if(d==2) {
				bfs(cur,2);
			}else if(d==3) {
				bfs(cur,3);
			}
		}else if(num == 2) {
			if(d==0 || d==2) {
				bfs(cur,0);
				bfs(cur,2);
			}else if(d==1||d==3) {
				bfs(cur,1);
				bfs(cur,3);
			}
		}else if(num == 3) {
			if(d==0) {
				bfs(cur,1);
				bfs(cur,2);
			}else if(d==1) {
				bfs(cur,2);
				bfs(cur,3);
			}else if(d==2) {
				bfs(cur,0);
				bfs(cur,3);
			}else if(d==3) {
				bfs(cur,1);
				bfs(cur,0);
			}
		}else if(num == 4) {
			if(d == 0) {
				bfs(cur,0);
				bfs(cur,1);
				bfs(cur,3);
			}else if(d==1) {
				bfs(cur,0);
				bfs(cur,1);
				bfs(cur,2);
			}else if(d==2) {
				bfs(cur,1);
				bfs(cur,2);
				bfs(cur,3);
			}else if(d==3) {
				bfs(cur,0);
				bfs(cur,2);
				bfs(cur,3);
			}
		}else if(num == 5) { // 네방향 모두  
			bfs(cur,0);
			bfs(cur,1);
			bfs(cur,2);
			bfs(cur,3);
		}
	}
	
	// 감시 bfs 
	static void bfs(cctv cur, int d) {
		
		int next_x = cur.x;
		int next_y = cur.y;
		
		while(true) {
			
			next_x += dx[d];
			next_y += dy[d];
			
			if( next_x >= N || next_y >= M || next_x < 0 || next_y < 0 || copymap[next_x][next_y] == 6) {
				break;
			}else if(copymap[next_x][next_y]==0){
				copymap[next_x][next_y] = -1;
			}
			
			
		}
		
	}
	
	//사각지대 갯수 구하기 
	static void getSpotCnt() {
		int cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copymap[i][j]==0) {
					cnt++;
				}
			}
		}
		
		result = Math.min(result, cnt);
	}
	
	//copy 
	static void copy() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				copymap[i][j] = map[i][j];
			}
		}
	}

}
