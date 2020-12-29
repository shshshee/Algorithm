import java.util.*;
import java.io.*;

public class boj14499 {
	// 이동할때마다 주사위 상단의 수를 출력하기 
	static int[][] map; // 지도 
	static int N,M; // 지도 크기 
	static int x,y; // 
	static int K;
	static Queue<Integer> move = new LinkedList<>(); // 이동좌표 저장 
	static int[][] dir  = {{0,1},{0,-1},{-1,0},{1,0}}; // 1.동 2.서 3.북  4.남  순서 
	static int[] dice  = new int[6]; // 이동 시 윗면에 쓰여있는 수 저장 
	
	static void run() {
		while(!move.isEmpty()) {
			int q = move.poll();
			int nx = x + dir[q-1][0];
			int ny = y + dir[q-1][1];
			
			if( nx < N && ny < M && nx >= 0 && ny >= 0) {
				if(q == 1) {
					//동 
					int temp = dice[5];
					dice[5] = dice[1];
					dice[1] = dice[4];
					dice[4] = dice[3];
					dice[3] = temp;
					
				
					
				} else if( q == 2 ) {
					//서 
					int temp = dice[5];
					dice[5] = dice[3];
					dice[3] = dice[4];
					dice[4] = dice[1];
					dice[1] = temp;
					
					
					
				} else if( q == 3 ) {
					//북 
					int temp = dice[3];
					dice[3] = dice[0];
					dice[0] = dice[1];
					dice[1] = dice[2];
					dice[2] = temp;
					
					
				} else if( q == 4 ) {
					//남 
					
					int temp = dice[3];
					dice[3] = dice[2];
					dice[2] = dice[1];
					dice[1] = dice[0];
					dice[0] = temp;
					
				}
				
				check(nx,ny);
				
				//좌표이동 
				x = nx;
				y = ny;
				
				//출력 
				System.out.println(dice[1]);
				
			}
			
		}
	}
	
	static void check(int x, int y) {
		if(map[x][y] == 0) {
			map[x][y] = dice[3];
		} else if (map[x][y] != 0) {
			dice[3] = map[x][y];
			map[x][y] = 0;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//가로세로 
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		//주사위 좌표 
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		//주사위 이동횟수
		K = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) {
			int n = Integer.parseInt(st.nextToken());
			move.add(n); // 이동좌표
		}
		
		run(); // 함수 실행 
		
	}

}
