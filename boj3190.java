import java.util.*;
import java.io.*;
public class boj3190 {
	// 3190 뱀 
	static int N; // 지도 크기
	static int K; // 사과 갯수 
	static int[][] map; 
	static int L; 
	static int[][] dir;
	static int count=0;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static Deque<snake> q = new LinkedList<>(); // 큐 생성
	
	static class snake {
		int x;
		int y;
		snake(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 크기
		K = Integer.parseInt(br.readLine()); // 사과 
		
		map = new int[N+1][N+1];
		
		// 사과 배치 
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 2;
		}
		
		L = Integer.parseInt(br.readLine());
		dir = new int[L][2]; // 방향 정보 저장 
		
		for(int i=0;i<L;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // 초
			char c = st.nextToken().charAt(0);
			
			if(c=='D') { 
				dir[i][0] = x;
				dir[i][1] = 1; // 오른쪽일 경우 1 
			}else { 
				dir[i][0] = x;
				dir[i][1] = -1; // 왼쪽일 경우 0 
			}
			
		}
		
		q.offer(new snake(1,1));
		map[1][1]=1;
		start(1,1,0);
		
		System.out.println(count);

	}
	
	static void start(int x1, int y1, int d) {
		// x1, y1 은 머리위치 
		int idx=0;

		while(true) {
					
			count++;
			
			// 이동
			int nextX = x1 + dx[d];
			int nextY = y1 + dy[d];
			
			if(checkBreak(nextX,nextY)) break; // 부딪혔으면 break 해준다
			
			q.addFirst(new snake(nextX,nextY));
			// 이동할 수 있을 경우 몸통 값 셋팅
			if(map[nextX][nextY]==2) { // 머리가 닿는 부분에 사과가 있다면 (이동 시)  
				map[nextX][nextY]=1;
			} else if(map[nextX][nextY]==0) { // 꼬리 제거 
				map[nextX][nextY]=1;
				map[q.peekLast().x][q.peekLast().y]=0;
				q.pollLast();
			} else {
				break; // 자기 자신과 부딪힐경우 
			}
			
			
			x1 = nextX;
			y1 = nextY;
			
			if(idx < L && count==dir[idx][0]) { // 방향 전환 시간 
				if(dir[idx][1]==1) { // 오른쪽 turn
					d = (d+1) % 4;
				}else { // 왼쪽 turn 
					d = (d+3) % 4;
				}
				idx++;
			}
			
			
		}
		

	}
	
	
	// 닿았는지 체크하는 함수 ?? 
	static boolean checkBreak(int x, int y) {
		if(x<1 || x > N || y<1 || y > N ) {
			// 보드를 넘어갔을 때
			return true;
		}
		
		return false;
	}
	
	
	

}
