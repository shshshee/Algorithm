import java.util.*;
import java.io.*;
public class boj14502 {
	//연구소 -> 안전영역의 최댓값 구하기
	static int N;
	static int M;
	static int[][] map;
	static int[][] copy;
	static int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
	static Queue<virus> q = new LinkedList<>();
	static int result=0;
	static class virus {
		int x;
		int y;
		virus (int x, int y){
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
		copy = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		
		System.out.println(result);

	}
 	
 	static void dfs(int depth) {
 		// 벽세우기
 		if(depth==3) {
 			spread(); // 벽 3개 세워졌을 경우 바이러스 확산 
 			return;
 			
 		}
 		
 		for(int i=0;i<N;i++) {
 			for(int j=0;j<M;j++) {
 				if(map[i][j]==0) {
 					map[i][j]=1;
 					dfs(depth+1);
 					map[i][j]=0;
 				}
 			}
 		}
 		
 	}
 	
 	static void spread() {
 		
 		copymap();
 		
 		while(!q.isEmpty()) {
 			virus v = q.poll();
 			
 			for(int i=0;i<4;i++) {
 				int dx = v.x+dir[i][0];
 				int dy = v.y+dir[i][1];
 				
 				if(dx>=0 && dx<N && dy>=0 && dy<M) {
 					if(copy[dx][dy]==0) {
 						copy[dx][dy]=2;
 						q.offer(new virus(dx,dy)); // 확산될 수 있다면 해당 좌표 큐에 넣기
 					}
 				}
 				
 			}

 		}
 		
 		countSpot();
 		
 		
 	}
 	
 	static void copymap() {
 		for(int i=0;i<N;i++) {
 			for(int j=0;j<M;j++) {
 				copy[i][j] = map[i][j];
 				if(map[i][j]==2) {
 					q.offer(new virus(i,j));
 				}
 			}
 		}
 	}
 	
 	static void countSpot() {
 		int cnt=0;
 		for(int i=0;i<N;i++) {
 			for(int j=0;j<M;j++) {
 				if(copy[i][j]==0) cnt++;
 			}
 		}
 		
 		result = Math.max(cnt,result);
 	}
 	

}
