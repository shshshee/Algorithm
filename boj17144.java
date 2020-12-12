import java.util.*;
import java.io.*;

public class boj17144 {
	
	static int R,C,T; //행, 열, 초 
	static int[][] room;
	static Queue<dust> q = new LinkedList<dust>();// 먼지들을 넣을 큐 
	static int sum; // 먼지 양
	static int[][] move = {{0,1},{0,-1},{1,0},{-1,0}}; //이동 좌표 (상,하,좌,우)
	static int[] cleaner = new int[2]; //공기청정기 좌표 저장 
	
	static class dust {
		int x;
		int y;
		int amount;
		
		dust (int x, int y, int amount){
			this.x = x;
			this.y = y;
			this.amount = amount;
		}
	}

	//확산
	static void spread() {
		while(!q.isEmpty()) {
			
			dust dst = q.poll(); // 큐에서 빼기 
			int amount = dst.amount/5; //확산되는 양 계산
			
			int cnt = 0; // 확산횟수 
			
			for(int i=0;i<4;i++) {
				//좌표이동 
				int nx = dst.x + move[i][0];
				int ny = dst.y + move[i][1];
				
				if(nx >= 0 && ny >= 0 && nx < R && ny < C && room[nx][ny] != -1) {
					room[nx][ny] += amount; // 상하죄우 확산
					cnt++; //확산 후 count
				}
				
			}
			
			// 확산 후 남은 미세먼지의 양 
			room[dst.x][dst.y] -= (amount * cnt);
			
		}
	}
	
	//순환
	static void run() {
		
		int top = cleaner[0];
		int down = cleaner[1];
		
		//공기청정기 위 반시계방항 순환 
		// 위 -> 아래 공기청정기 위치하기 전까지 
		for(int i=top-1;i>0;i--) {
			room[i][0] = room[i-1][0];
		}
		
		// 오 -> 왼 
		for(int i=1;i<C;i++) {
			room[0][i-1] = room[0][i];
		}
		
		//아래 -> 위 
		for(int i=1;i<top+1;i++) {
			room[i-1][C-1] = room[i][C-1];
		}
		
		//왼 -> 오 
		for(int i=C-1;i>1;i--) {
			room[top][i] = room[top][i-1]; 
		}
		
		//공기청정기 정화된 부분의 미세먼지 값 0으로 초기화 
		room[top][1] = 0;
		
		//공기청정기 아래 시계방향으로 순환 
		for(int i=down+1;i<R-1;i++) {
			room[i][0] = room[i+1][0];
		}
		
		//오른쪽 왼쪽 
		for(int i=0;i<C-1;i++) {
			room[R-1][i] = room[R-1][i+1];
		}
		
		//위 아래 
		for(int i=R-1;i>down;i--) {
			room[i][C-1] = room[i-1][C-1];
		}
		
		//왼쪽 오른
		for(int i=C-1;i>1;i--) {
			room[down][i] = room[down][i-1];
		}
		
		//공기청정기 정화된 부분의 미세먼지 값 0으로 초기화 
		room[down][1] = 0;
		
	}
	
	//큐저장
	static void queue() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(room[i][j] > 0) {
					q.offer(new dust(i,j,room[i][j]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		room = new int[R][C];
		
		int index = 0;
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if(room[i][j] == -1) {
					cleaner[index++] = i; // 공기청정기의 좌표 항상 1열에 저장되어 있기 때문에 i에대한 정보만 넣어
				}
			}
		}
		
		// t초 동안 반복 
		for(int i=0;i<T;i++) {
			queue();
			spread();
			run();
		}
		
		sum = 0;
		
		//마지막 미세먼지 양 count 
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(room[i][j] != -1) {
					sum +=  room[i][j]; 
				}
			}
		}
		
		System.out.println(sum);
		
		
		
	}

}
E
