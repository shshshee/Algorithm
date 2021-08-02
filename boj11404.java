import java.util.*;
import java.io.*;
public class boj11404 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 도시 개수 
		int m = Integer.parseInt(br.readLine()); // 버스 개수
		
		int[][] dist = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i!=j && dist[i][j]==0) dist[i][j] = 9999999; // 출발, 도착 지역이 같은 경우를 제외하고 최대값으로 설정 
			}
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
				
			dist[x-1][y-1] = Math.min(dist[x-1][y-1], w);
				
		}
		
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(dist[i][j]>dist[i][k]+dist[k][j]) {
						dist[i][j]=dist[i][k]+dist[k][j];
					}
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(dist[i][j]==9999999) dist[i][j] = 0;
				System.out.print(dist[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
	}

}
