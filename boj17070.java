import java.util.*;
import java.io.*;
public class boj17070 {
	// 파이프 옮기기 1 // 벽 1 , 빈칸 0 
	static int N;
	static int[][] arr;
	static int[][] dir = {{0,1},{1,0},{1,1}}; // 방향 정보 저장 // 가로 0, 세로 1, 대각선 2
	static int result; // 결과값 count
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		result = 0;
		
		StringTokenizer st;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 초기 방향 가로
		dfs(0,1,0);
		
		System.out.println(result);
		
	}
	
	
	// dfs
	static void dfs(int nx, int ny, int nd) {
		if(nx==N-1 && ny==N-1) {
			result++;
			return;
		}
		
		if(nd==0) { // 가로 - 0
			if(ny+1 < N && arr[nx][ny+1] != 1 ) {
				dfs(nx,ny+1,0);
			}
		}else if(nd==1) { // 세로 - 1
			if(nx+1 < N && arr[nx+1][ny] != 1 ) {
				dfs(nx+1,ny,1);
			}
		}else { // 대각선 - 0,1
			if(ny+1 < N && arr[nx][ny+1] != 1 ) {
				dfs(nx,ny+1,0);
			}
			if(nx+1 < N && arr[nx+1][ny] != 1 ) {
				dfs(nx+1,ny,1);
			}
		}
		
		if(isMove(nx,ny)) {
			dfs(nx+1,ny+1,2);
		}
		
	}
	
	// 대각선 이동 가능한지 ? 
	static boolean isMove(int nx, int ny) {
		
		for(int i=0;i<3;i++) {
			int x = nx + dir[i][0];
			int y = ny + dir[i][1];
			if(x<0 || y<0 || x>=N || y>=N || arr[x][y]==1) {
				return false;
			}
		}
		
		return true;
		
	}
	
	
	

}
