import java.util.*;
import java.io.*;
public class boj14500 {
	// 테트로미노
	static int[][] map;
	static boolean[][] visited;
	static int max = Integer.MIN_VALUE; // 최대값
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M]; // 해당 위치 방문 check
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		// 전체 맵을 돌며 조합 구하기
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				dfs(i,j,0,0); // ㅗ,ㅜ,ㅏ,ㅓ를 제외한 모든 조합을 dfs로 구현 
				otherShape(i,j); // dfs로 구현되지 못하는 ㅗ,ㅜ,ㅏ,ㅓ 모양의 조합 구하기
			}
		}
		
		System.out.println(max);
		
		
	}
	
	// dfs로 구할 수 없는 도형 구현 -> 
	public static void otherShape(int x, int y) {
		int cnt = 0; 
		int sum = map[x][y]; // 정사각형 4개 도형의 합 
		int min = Integer.MAX_VALUE;
		
		for(int i=0;i<4;i++) {
			//상하죄우 이동 
			int dx = x + dir[i][0];
			int dy = y + dir[i][1];
			
			
			if(isValid(dx,dy)) {
				// 이동 위치가 유효한 범위일 경우 
				sum += map[dx][dy]; //이동한 위치의 숫자를 더해준다
				min = Math.min(min, map[dx][dy]);
				cnt++;
				
			}
			
		}
		
		if(cnt<3) { 
			//상하좌우로 붙여진 블록이 3개 미만일 경우, return
			return;
		}else if(cnt==4) {
			//상하좌우로 붙여진 블록이 4개일 경우 하나를 빼주어야 ㅗ,ㅜ,ㅏ,ㅓ 모양을 만족하게 됨 
			sum = sum - min;
		}
		
		max = Math.max(sum, max);
		
	}
	
	
	//dfs
	public static void dfs(int x, int y,int idx, int value) {
		if(idx==4) {
			max = Math.max(value, max);
			return;
		}
		
		for(int i=0;i<4;i++) {
			
			int dx = x + dir[i][0];
			int dy = y + dir[i][1];
			
			if(isValid(dx,dy) && !visited[dx][dy]) {
				visited[dx][dy]=true;
				dfs(dx,dy,idx+1,value+map[dx][dy]);
				visited[dx][dy]=false;
			}
		}

	}
	
	
	//유효 범위 check 함수
	public static boolean isValid(int dx, int dy) {
		
		if(dx<0 || dy<0 || dx >= N || dy >= M) return false;
		
		return true;
	}
	

}
