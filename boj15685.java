import java.util.*;
import java.io.*;
public class boj15685 {
	// 15685 드래곤 커브
	static int[][] dir = {{0,1},{-1,0},{0,-1},{1,0}}; // 상하죄우
	static int N;
	static boolean[][] map = new boolean[101][101];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()); //방향
			int g = Integer.parseInt(st.nextToken()); //세대 
			
			draw(y,x,getDirection(d,g)); // 방향 구하기
			
		}
		
		
		int result = checkdragon();
		System.out.println(result);		
		
	}
	
	// 방향 구하기 -> 이전세대 기반 ? 
	static List<Integer> getDirection(int d,int g) {
		List<Integer> list = new ArrayList<>();
		list.add(d);
		
		while(g-- > 0) {
			for(int i=list.size()-1;i>=0;i--) {
				list.add((list.get(i)+1)%4);
			}
		}
		
		return list;
	}
		

	
	//드래곤커브 그리기 
	static void draw(int x,int y, List<Integer> list) {
		map[x][y]=true;
		
		for(int now : list) {
			x += dir[now][0];
			y += dir[now][1];
			
			map[x][y] = true;
		}
	}
	
	// 사각형 체크하기
	static int checkdragon() {
		int cnt = 0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) {
					cnt++;
				}
			}
		}
		return cnt;
	}

}
