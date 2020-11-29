import java.util.*;
import java.io.*;

public class boj1012 {
	// 유기농 배추 문제 dfs 
	static int counts; // 지렁이 수 
	static int[][] cabbage; // 배추밭
	static boolean[][] check; //방문체크
	static int N,M,K; // 각각 가로, 세로, 배추갯수 
	static int test; //테스트 케이스 갯수
	static ArrayList<Integer> list; // 배추 지렁이 수를 저장하기 위한 리스트
	static int[][] move = {{0,1},{0,-1},{1,0},{-1,0}}; //이동 좌표 (상,하,좌,우)
	
	static void dfs(int x, int y) {
		check[x][y] = true; // 방문표시로 변경 
		for(int i=0;i<move.length;i++) {
			//이동좌표 설정 
			int nx = x + move[i][0];
			int ny = y + move[i][1];
			if( nx >= 0 && nx < M && ny >= 0 && ny < N && !check[nx][ny] && cabbage[nx][ny] == 1 ) {
				dfs(nx,ny);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		test = Integer.parseInt(st.nextToken()); // 테스트 케이스 입력받기
		list = new ArrayList<>(); // 리스트 생성
		
		for(int i=0;i<test;i++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 가로 
			M = Integer.parseInt(st.nextToken()); // 세로
			K = Integer.parseInt(st.nextToken()); // 심은 배추의 수 
			
			cabbage = new int[M][N]; // 배추밭 이차원배열 초기화
			check = new boolean [M][N]; 
		
			// 배추 심기 (좌표입력)
			for(int j=0;j<K;j++) {
				st = new StringTokenizer(br.readLine());
				int nx = Integer.parseInt(st.nextToken());
				int ny = Integer.parseInt(st.nextToken());
				cabbage[ny][nx] = 1; // 배추가 심어져잇는 해당 배열 인덱스 값 1로 변경 
			}
			
			//처음 배추 심어져있는곳 찾기 
			for(int j=0;j<M;j++) {
				for(int k=0;k<N;k++) {
					if(cabbage[j][k] != 0 && !check[j][k]) {
						//배추가 심어져있고 방문하지 않은 곳이라면 
						dfs(j,k);
						counts ++;
					}
				}
			}
			
			list.add(counts);
			counts = 0;
			
		}
		
		for(int num : list) {
			System.out.println(num);
		}

	}

}
