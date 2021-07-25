import java.util.*;
import java.io.*;
public class boj2580 {
	//2580 스도쿠
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<int[]> loclist = new ArrayList<int[]>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[9][9];
		visited = new boolean[9][9];
		
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==0) {
					loclist.add(new int[] {i,j});
				}
			}
		}
		
		sdoku(0);
		

	}
	
	// 가로, 세로, 3x3 블럭 안에서의 규칙을 만족해야 함
	static void sdoku(int idx) {
		//비어있는 모든 좌표를 순회한 경우 -> 출력 후 return
		if(idx==loclist.size()) {
			//출력
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		// 비어있는 좌표 위치 꺼내기
		int[] loc = loclist.get(idx);
		int x = loc[0];
		int y = loc[1];
		
		for(int i=1;i<=9;i++) {
			if(checkValid(x,y,i)) { // 해당 value 값이 들어갈 수 있는지 체크
				map[x][y]=i; // value값이 유효하다면 값이 비어있는 위치에 value값 세팅
				sdoku(idx+1);
				map[x][y]=0;
			}
			
		}	
		
	}
	
	// 값이 유효한지 체크
	static boolean checkValid(int x,int y, int value) {
		//가로
		for(int i=0;i<9;i++) {
			if(map[x][i]==value) {
				return false;
			}
		}
		
		//세로 
		for(int i=0;i<9;i++) {
			if(map[i][y]==value) {
				return false;
			}
		}
		
		//블럭
		int dx = x/3 * 3 ; //블럭의 시작 좌표 x 
		int dy = y/3 * 3 ; //블럭의 시작 좌표 y 
		for(int i=dx;i<dx+3;i++) {
			for(int j=dy;j<dy+3;j++) {
				if(map[i][j]==value) {
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	

}
