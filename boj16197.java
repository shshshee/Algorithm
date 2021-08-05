import java.util.*;
import java.io.*;
public class boj16197 {
	// 두 동전 - dfs
	static int result=Integer.MAX_VALUE;
	static int N,M;
	static char[][] map;
	static int[][] dir= {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean[] isdrop = new boolean[2];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		int r1,c1,r2,c2;
		r1=c1=r2=c2=-1;
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=str.charAt(j);
				if(map[i][j]=='o') { // 동전일 경우
					if(r1 == -1) {
						// 동전 위치 저장
						r1 = i; 
						c1 = j;
					}else {
						r2 = i;
						c2 = j;
					}
				}
			}
		}
		

		dfs(1,r1,c1,r2,c2);
	
		if(result==Integer.MAX_VALUE) {
			System.out.println("-1");
		}else {
			System.out.println(result);
		}
		
	}
	
	static void dfs(int depth,int r1,int c1, int r2, int c2) {
		
		if(depth>10) {
			//10번보다 많이 눌러야 한다면
			return;
		}
		
		for(int i=0;i<4;i++) {
			isdrop[0]=isdrop[1]=false;
			// 두 동전은 동시에 움직인다. 
			int dr1 = r1 + dir[i][0];
			int dc1 = c1 + dir[i][1];
			int dr2 = r2 + dir[i][0];
			int dc2 = c2 + dir[i][1];
			
			if(dr1 < 0 || dc1 < 0 || dr1 >= N || dc1 >= M) {
				isdrop[0]=true;
			}
			
			if(dr2 < 0 || dc2 < 0 || dr2 >= N || dc2 >= M) {
				isdrop[1]=true;
			}
			
			if(isdrop[0] && isdrop[1]) continue; // 둘 다 떨어진 경우
			
			if(isdrop[0] || isdrop[1]) { // 하나만 떨어진 경우
				result = Math.min(result, depth);
				return;
			}
			
			if(!isdrop[0] && map[dr1][dc1]=='#') { // 다음 위치가 벽일 경우 -> 이동 x 
				dr1 = r1;
				dc1 = c1;
			}
			
			if(!isdrop[1] && map[dr2][dc2]=='#') {
				dr2 = r2;
				dc2 = c2;
			}
			
			dfs(depth+1,dr1,dc1,dr2,dc2);
			
		}
		

		
	}

}
