import java.util.*;
import java.io.*;
public class boj17135 {
	// 캐슬디펜스 - 궁수의 공격으로 제거할 수 있는 적의 최대 수 
	static int[][] map;
	static int[][] copy;
	static int N,M,D;
	static class spot{
		int x;
		int y;
		public spot(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int result;
	static ArrayList<Integer> arrow = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		copy = new int[N][M];
		result = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				copy[i][j] = map[i][j];
				
			}
		}
		
		
		// 궁수 조합 -> 적 공격 -> 적 이동 
		combi(0,0);
		
		System.out.println(result);
		
		
	}
	
	// 궁수 배치 조합 
	static void combi(int cnt,int start) {
		if(cnt==3) {
			init(); // 배열 초기화 
			int ans = attack();
			result = Math.max(result,ans);
			//System.out.print(result);
			return;
		}
		
		for(int i=start;i<M;i++) {
				arrow.add(i);
				combi(cnt+1,i+1);
				arrow.remove(arrow.size()-1);
		}
		
	}
	
	// 공격
	static int attack() {
		ArrayList<spot> enemy = new ArrayList<>(); // 공격가능한 적을 넣기위한 list 
		int turn = 0;
		int cnt = 0;
		
		while(turn<N){ // N턴까지 게임 진행 
			for(int i=0;i<arrow.size();i++) {
				int loc = arrow.get(i); // 현재 궁수 위치좌표 
				int minD = D; // 최단거리 
				int x = N;
				int y = M;
				
				// 탐색 
				for(int r=0;r<N;r++) {
					for(int c=0;c<M;c++) {
						if(map[r][c]==1) {
							int dist = getDist(r,N,c,loc);
							if(dist==minD) {
								if(c<y) { // 거리는 일치하지만 더 왼쪽에 있는 경우 
									x = r;
									y = c;
								}
							}else if(dist<minD) { // 현재 구해진 최단 거리보다 작을 경우 -> 갱신 
								minD = dist;
								x = r;
								y = c;
							}
						}
					}
				}
				
				if(x<N && y<M) {
					// 값이 갱신된 경우 -> 적이 있는 경우에만 리스트에 추가한다
					enemy.add(new spot(x,y)); // 리스트에 적 추가하기 
				}
			}
			
			// 1. 공격 
			for(int i=0;i<enemy.size();i++) {
				spot e = enemy.get(i);
				if(map[e.x][e.y]==1) {
					map[e.x][e.y]=0;
					cnt++;
				}
			}
			
			// 2. 적 리스트 초기화 
			enemy.clear();
			
			// 3. 배열 이동 
			for(int i=N-1;i>=1;i--) {
				for(int j=0;j<M;j++) {
					map[i][j] = map[i-1][j];
				}
			}
			
			for(int i=0;i<M;i++) {
				map[0][i] = 0;
			}
			
//			System.out.println();
//			
//			for(int i=0;i<N;i++) {
//				for(int j=0;j<M;j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//				
//			}
			
			turn++;
		}
		
		return cnt;
		
	}
	
	// 거리 구하기 
	static int getDist(int r1, int r2, int c1, int c2) {
		return Math.abs(r1-r2) + Math.abs(c1-c2);
	}
	
	// 배열 초기화 
	static void init() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = copy[i][j];
			}
		}
	}

}
