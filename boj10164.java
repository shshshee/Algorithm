import java.util.*;
import java.io.*;
public class boj10164 {
	// 격자상의 경로
	static int N,M,O;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		O = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		
		if(O==0) {
			System.out.println(dp(N,M));
		}else {
			int i = (O/M)+(O%M>0?1:0);
			int j = O-(i-1)*M;
			int k = N-i+1;
			int l = M-j+1;
			System.out.println(dp(i,j)*dp(k,l));
		}
		
		
	}
	
	static int dp(int x, int y) {
		
		for(int i=1;i<=x;i++) {
			for(int j=1;j<=y;j++) {
				if(i==1 || j==1) {
					map[i][j]=1;
				}else {
					map[i][j]=map[i-1][j]+map[i][j-1];
				}
			}
		}
		
		return map[x][y];
	}
	

}
