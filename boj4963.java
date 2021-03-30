import java.io.*;
import java.util.*;

public class boj4963 {
	
	static int[][] map;
	static boolean[][] visited; //방문 체크 
	static Queue<land> q = new LinkedList<>();
	static int w,h;
	static int[][] dir = {{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
	static int num; // 섬 갯수
	
	//land 클래스 생성
	static class land {
		int x,y;
		
		public land(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 4963 섬의 개수
		// 가로 세로 대각선 이동 가능 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 섬 갯수 추가.. 
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) break;
			
			map = new int[h][w]; // 배열 초기화 
			visited = new boolean[h][w]; // 방문 배열 초기화 
			num = 0; // count 초기화
			
			// 값 넣기
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			};
			
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						q.offer(new land(i,j));
						check(i,j);
					}
				}
			};
				
			sb.append(num).append("\n");
		}
		
		System.out.println(sb);
		
	}

	public static void check(int x,int y) {
		
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			land tmp = q.poll();
			
			int dx,dy;
			for(int i=0;i<dir.length;i++) {
				dx = tmp.x + dir[i][0];
				dy = tmp.y + dir[i][1];
				if ( dx >= 0 && dx < h && dy >= 0 && dy < w && map[dx][dy] == 1 && !visited[dx][dy]) {
					q.offer(new land(dx,dy));
					visited[dx][dy] = true;
				}
			}
						
		}
		num ++;
		
	}
}
