import java.util.*;
import java.io.*;
public class Main {
	// 사다리 조작
	static int N,M,H;
	static int[][] arr;
	static int result = 0;
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로선 갯수
		M = Integer.parseInt(st.nextToken()); //입력 (가로선 갯수) 
		H = Integer.parseInt(st.nextToken()); // 가로 줄 갯수
		
		arr = new int[H+1][N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // 가로줄 번호 
			int y = Integer.parseInt(st.nextToken()); // y ~ y+1 사이를 잇는다. 
			arr[x][y]=1;
			arr[x][y+1]=2;
		}
		
		for(int i=0;i<=3;i++) {
			result = i;
			dfs(1,0);
			if(flag) break;
		}

		if(flag) {
			System.out.println(result);
		}else {
			System.out.println("-1");
		}
		
	}
	
	// 가로선 추가 (백트래킹) 
	static void dfs(int idx, int depth) {
		
		if(flag) return;
		
		if(depth==result) {
			if(run()) {
				flag = true;
			}
			return;
		}
		
		for(int i=idx;i<=H;i++) {
			for(int j=1;j<N;j++) {
				if(arr[i][j]==0 && arr[i][j+1]==0) {
					arr[i][j]=1;
					arr[i][j+1]=2;
					dfs(i,depth+1);
					arr[i][j]=arr[i][j+1]=0;
				}
			}
		}
	}
	
	
	// 사다리 타기
	static boolean run() {
		for(int i=1;i<=N;i++) {
			int x=i; int y=1;
			for(int j=1;j<=H;j++) {
				if(arr[y][x]==1) {
					// 오른쪽으로 이동
					x++;
				}else if(arr[y][x]==2) {
					// 왼쪽으로 이동 
					x--;
				}
				y++;
			}
			
			if(x!=i) return false; // 시작점과 끝점이 하나라도 같지 않을 경우 false 리턴
			
		}
		
		return true; 
	}

}
