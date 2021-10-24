import java.util.*;
import java.io.*;
public class boj6087 {
	// 6087 레이저통신 두 C를 연결하기 위해 설치해야 하는 거울의 최소값 구하기
	static int W;
	static int H;
	static char[][] map;
	static int[][] visited;
	static int[][] d = {{1,0},{0,1},{-1,0},{0,-1}};
	static ArrayList<node> cList = new ArrayList<>(); // C의 위치를 저장할 리스트
	static int answer = Integer.MAX_VALUE;
	static class node {
		int x;
		int y;
		int dir;
		int mirror;
		public node(int x,int y, int dir, int mirror) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.mirror = mirror;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new char[H][W]; 
		visited = new int[H][W];
		
		for(int i=0;i<H;i++) {
			String[] s = br.readLine().split("");
			for(int j=0;j<W;j++) {
				visited[i][j] = Integer.MAX_VALUE; // 최대값으로 초기화 
				
				char val = s[j].charAt(0);
				map[i][j] = val;
				
				if(val == 'C') {
					cList.add(new node(i,j,-1,0));
				}
			}
		}
		
		bfs();		
		System.out.println(answer);
		
	}
	
	static void bfs() {
		Queue<node> q = new LinkedList<>();
		
		node c1 = cList.get(0);
		node c2 = cList.get(1);
		
		q.add(c1);
		visited[c1.x][c1.y] = 0;
		
		while(!q.isEmpty()) {
			node n = q.poll();
			
			int x = n.x;
			int y = n.y;
			int dir = n.dir; // 방향 
			int mirror = n.mirror; // 거울 갯수
			
			// 도착 지점일 경우 -> 도착 좌표에 저장된 거울 갯수가 최소라는 보장이 없기에 계속 탐색
			if(x == c2.x && y == c2.y) {
				answer = Math.min(answer, mirror);
				continue;
			}
			
			for(int i=0;i<4;i++) {
				int nx = x + d[i][0]; // 다음 좌표
				int ny = y + d[i][1];
				int nd = i; // 다음 방향 
				
				// 범위를 벗어나거나 다음 좌표값이 벽인 경우 
				if( nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == '*' ) continue;
				
				// 처음 시작이 아니면서 방향이 바뀐 경우 -> 거울 설치하기 
				int tmp = mirror;
				if( dir != -1 && dir != nd ) {
					tmp++;
				}
				
				// 새로 구해진 거울 갯수가 더 큰 경우
				if (visited[nx][ny]<tmp) {
					continue;
				}
				
				visited[nx][ny] = tmp;
				q.add(new node(nx,ny,nd,tmp)); 
				
			}
			
		}
		
		
	}
	

}
