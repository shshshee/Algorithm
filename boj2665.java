import java.util.*;
import java.io.*;
public class boj2665 {
	// 2665 미로만들기 
	static int n; 
	static int[][] map;
	static int[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int INF = Integer.MAX_VALUE;
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n]; 
		visited = new int[n][n]; // 지나온 검은방의 갯수를 카운트할 배열
		
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<n;j++) {
				map[i][j] = str.charAt(j)-'0';
				visited[i][j] = INF;
			}
		}
		
		int result = bfs();
		System.out.println(result);
		
		
	}
	
	static int bfs() {
		
		Queue<point> q = new LinkedList<>();
		q.add(new point(0,0));
		visited[0][0] = 0;
		
		while(!q.isEmpty()) {
			point now = q.poll();
			for(int i=0;i<4;i++) {
				int next_x = now.x + dx[i];
				int next_y = now.y + dy[i];
				
				if(next_x < 0 || next_x >= n || next_y < 0 || next_y >= n) continue;
				
				// 더 작은 값으로 갱신 가능한 경우 
				if(visited[next_x][next_y]>visited[now.x][now.y]) {
					if(map[next_x][next_y]==1) {
						// 흰방인 경우 
						visited[next_x][next_y] = visited[now.x][now.y];
						
					}else {
						// 검은방인 경우 
						visited[next_x][next_y] = visited[now.x][now.y]+1;
					}	
					
					q.add(new point(next_x,next_y));
					
				}

			}
			
		}
		
		return visited[n-1][n-1];
		
		
	}
	
	static class point {
		int x;
		int y;
		
		point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	

}
