import java.util.*;
import java.io.*;
public class boj14503 {
	// 14503 로봇청소기
	static int N;
	static int M;
	static int[][] map;
    static int[] dr = {-1, 0, 1, 0}; // 북,동,남,서
    static int[] dc = {0, 1, 0, -1};
	static int count;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M]; 
		count = 0; // 측정할 칸의 갯수
		
		st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		clean(r,c,d);
		
		System.out.println(count);
	
	}
	
	static void clean(int r,int c, int d) {
		
		// 청소하기 
		if(map[r][c]==0) {
			map[r][c] = 2;
			count ++;
		}
		
		// 방향 탐색 
		int flag = 0;
		for(int i=0;i<4;i++) {
			d = (d+3)%4; // 회전 
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr >=0 && nc >=0 && nr < N && nc < M) {
				if(map[nr][nc]==0) {
					//아직 청소하지 않았으면서 벽이 아닌 경우 
					flag = 1;
					clean(nr,nc,d);
					break;
				}
				

			}
			
		}
		
		// 네 방향 모두 청소되어있거나 벽인 경우 후진 -> 다시 탐색과정 시작 
		// 후진 할 때 뒤쪽이 벽인 경우 작동을 멈춘다 
		if(flag == 0) {
			int nd = (d+2)%4;
			int nr = r + dr[nd];
			int nc = c + dc[nd];
			if(nr >=0 && nc >=0 && nr < N && nc < M) {
				if(map[nr][nc]!=1) {
					//벽이 아닌경우 후진
					clean(nr,nc,d);  // 방향은 그대로 유지 
				}
			}
		}
		
		
		

		
	}
	
	

}
