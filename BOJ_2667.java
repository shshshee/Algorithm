import java.util.*;
import java.io.*;

//출력 : 단재 갯수 , 각각의 집 갯수
public class Main { 
	
	static int[][] house; //단지배치 
	static boolean[][] visited; //방문체크
	static int N;
	static int[][] move = {{0,1},{0,-1},{1,0},{-1,0}}; //이동 좌표 (상,하,좌,우)
	static ArrayList<Integer> list;
	static int counts; // 갯수 counts
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		house = new int[N][N]; // N 입력
		visited = new boolean[N][N];
		
		//입력받기
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				house[i][j] = Integer.parseInt(str.charAt(j)+"");
			}
		}
		
		list = new ArrayList<>();
		
		
		//처음 좌표 찾기
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j] && house[i][j] == 1) {
					visited[i][j] = true;
					counts = 0;
					dfs(i,j);
					list.add(counts);
				}
			}
		}
		
		System.out.println(list.size()); //단지수 출력 
		Collections.sort(list); // 정렬 
		
		//리스트 출력
		for(int num : list) {
			System.out.println(num); // 각 단지안에 집 갯수
		}
		
	}
	
	//상하좌우 탐색
	static void dfs(int x, int y) {
		counts ++ ;
		visited[x][y] = true; // 방문 체크
			
		for(int i=0;i<move.length;i++) {
			
			int nx = x + move[i][0];
			int ny = y + move[i][1];
			
			if(nx >= 0 && ny >= 0 && nx < N && ny < N && house[nx][ny] == 1 && !visited[nx][ny]){
				dfs(nx,ny); 
			}
		}

	}
	
	

}
