import java.util.*;
import java.io.*;

public class Main {
	// 7576. 토마토 - 며칠이 지나면 토마토들이 모두 익는지 ? bfs 문제 
	
	static int N,M;
	static int[][] arr; //토마토 넣을 배열
	static Queue<tomato> queue = new LinkedList<tomato>(); 
	static int[][] move = {{0,1},{0,-1},{1,0},{-1,0}}; //이동 좌표 (상,하,좌,우)
	static int count;
	
	static class tomato {
		int x;
		int y;
		int counts;
		
		tomato(int x,int y, int counts) {
			this.x = x;
			this.y = y;
			this.counts = counts;
		}
	}
	
	//bfs
	static void bfs() {
		while(!queue.isEmpty()) {
			tomato t = queue.poll();
			count = t.counts;
			//System.out.print(count);
			
			for(int i=0;i<move.length;i++) {
				int nx = t.x + move[i][0];
				int ny = t.y + move[i][1];
				
				if(nx >= 0 && ny >= 0 && nx < M && ny < N ) {
					if(arr[nx][ny] == 0) {
						arr[nx][ny] = 1;
						queue.add(new tomato(nx,ny,count+1));
					}
				}
				
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//System.out.print(N +""+M);
		
		arr = new int[M][N];
		//boolean[][] visited = new boolean[N][M];
		
		// 전체 토마토 입력받기
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 익어있는 토마토 == 1 인 경우 큐에 넣기 
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j] == 1) {
					queue.add(new tomato(i,j,0));
				}
			}
		}
		
		bfs(); // bfs 호출 
		
		// 안익은 토마토 있는지 최종 확인 
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]==0) {
					count = -1;
				}
			}
		}
		
		System.out.println(count);
		
		
	}

}
