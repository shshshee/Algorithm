import java.util.*;
import java.io.*;

public class boj10026 {
	// 10026 적록색약 
	
	static char[][] arr; 
	static boolean[][] visited; 
	static int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}}; // 상하죄우
	static int N;
	
	static Stack<color> stack = new Stack<>(); // dfs 스택 생성
	
	static int count = 0;
	static int result1 = 0; // 적록색약 x 
	static int result2 = 0; // 적록색약 o 
	
	static class color {
		int x,y;
		
		public color(int x,int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void dfs(){
		//적록색약 x 
		while(!stack.isEmpty()) {
			color a = stack.pop();
			int x = a.x;
			int y = a.y;
			visited[x][y] = true;
			for(int i=0;i<dir.length;i++) {
				int dx = x + dir[i][0];
				int dy = y + dir[i][1];
				// 유효한 인덱스 위치이면서 방문하지 않은 곳일 경우 
				if(dx>=0 &&dx<N &&dy>=0 &&dy<N && !visited[dx][dy]) {
					if(arr[dx][dy]==arr[x][y]) { // 같은 색일 경우 
						stack.push(new color(dx,dy));
					}
				}
			}
		}
		count ++;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
 		
		N = Integer.parseInt(st.nextToken());
		
		arr = new char[N][N]; // 배열 
		visited = new boolean[N][N]; // 방문 check 
		
		//배열 넣기
		for(int i=0;i<N;i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		
		// 방문 검사 1
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					stack.push(new color(i,j));
					dfs();
				}
			}
		}
		
		result1 = count;
		count = 0;
		
		//방문배열 초기화 
		visited = new boolean[N][N];
		
		//적록색약 o arr 배열 재설정 
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]=='G') {
					arr[i][j]='R';
				}
			}
		}

		
		// 방문 검사 1
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					stack.push(new color(i,j));
					dfs();
				}
			}
		}
		
		result2 = count;
		
		
		System.out.print(result1+" "+result2);
				
		
	} 

}
