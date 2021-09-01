import java.util.*;
import java.io.*;
public class boj20056 {
	// 20056 마법사 상어와 파이어볼 
	
	static class fireball {
		int r; // 위치 
		int c;
		int m; // 질량
		int s; // 속력 
		int d; // 방향 
		
		public fireball(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	
	static ArrayList<fireball>[][] map;
	static ArrayList<fireball>[][] copy; // 이동 시 사용할 배열
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	static int N;
	static int result;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); 
		
		map = new ArrayList[N][N]; 
			
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			fireball f = new fireball(r,c,m,s,d);
			map[r][c].add(f);
		}
		
		for(int i=0;i<K;i++) {
			// K 번 만큼 움직이기 
			move();
			sum();
		}
		
		getResult();
		
		System.out.println(result); // 질량의합 출력
	}
	
	// 움직이기
	public static void move() {
		
		copy = new ArrayList[N][N];
		
		// 옮길 배열 초기화 해주기 
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				copy[i][j] = new ArrayList<>();
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j].size()>0) {
					for(fireball cur : map[i][j]) {

						// 이동 
						int r = cur.r + dy[cur.d]*cur.s % N;
						int c = cur.c + dx[cur.d]*cur.s % N;
						
						r = (r+N)%N;
						c = (c+N)%N;
						
						copy[r][c].add(new fireball(r,c,cur.m,cur.s,cur.d));
						
	
					}
					
					map[i][j].clear();
				}
			}
		}
		
		
	}
	
	// 겹쳐있는 파이어볼 check 후 합치기 -> 나누기 
	public static void sum() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(copy[i][j].size()>1) {
					// 2개 이상의 파이어볼이 겹쳐있을경우 
					boolean isEven = true; 
					boolean isOdd = true;
					
					int total_s = 0; // 속력의 총 합 
					int total_m = 0; // 질량의 총 합 
					
					int count = copy[i][j].size();
					
					for(fireball cur : copy[i][j]) {
						total_s += cur.s;
						total_m += cur.m;
						
						// 모두 짝수 or 홀수 -> 0,2,4,6
						if(cur.d%2 == 0) {
							isOdd = false;
						}else {
							isEven = false;
						}
						
						
					}
					
					total_s = total_s/count;
					total_m = total_m/5;
					
					copy[i][j].clear(); // 겹친 파이어볼 모두 제거 
					
					if(total_m==0) continue; // 합한 질량 0일 경우 저장 x 
					
					if(isOdd || isEven) { 
						//모두 홀수이거나 모두 짝수일 경우 -> 0,2,4,6
						for(int k=0;k<4;k++) {
							int dir[] = {0,2,4,6};
							map[i][j].add(new fireball(i,j,total_m,total_s,dir[k]));
						}
						
					}else {
						// 1,3,5,7 
						for(int k=0;k<4;k++) {
							int dir[] = {1,3,5,7};
							map[i][j].add(new fireball(i,j,total_m,total_s,dir[k]));
						}
					}
					
					
				}else if(copy[i][j].size()==1) {
					// 하나만 있는 경우 다시 map 으로 옮겨주기 
					fireball cur = copy[i][j].get(0);
					map[i][j].add(new fireball(i,j,cur.m,cur.s,cur.d));
					
				}
			}
		}
	}
	
	// 질량 합하기 
	public static void getResult() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j].size()>0) {
					for( fireball cur : map[i][j]) {
						result += cur.m;
					}
				}
			}
		}
		
	}

}
