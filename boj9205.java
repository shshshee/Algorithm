import java.util.*;
import java.io.*;
public class Main {
	// 9205 맥주 마시면서 걸어가기 
	static class point{
		int x;
		int y;
		point(int x, int y){
			this.x = x;
			this.y = y;
		}
	
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			ArrayList<point> list = new ArrayList<>();
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n+2][n+2];
			
			for(int j=0;j<n+2;j++) {
				for(int k=0;k<n+2;k++) {
					arr[j][k] = 9999999;
				}
			}
			
			for(int j=0;j<n+2;j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new point(x,y));
			}
			
			for(int j=0;j<n+2;j++) {
				for(int k=0;k<n+2;k++) {
					if(j==k) continue;
					
					point v = list.get(j);
					point w = list.get(k);
					
					int dist = Math.abs(v.x-w.x) + Math.abs(v.y-w.y);
					
					if(dist <= 1000) {
						arr[j][k] = 1;
					}
					
				}
			}
			
			floyd(arr,n+2);
			
			if(arr[0][n+1]>=9999999) {
				System.out.println("sad");
			}else {
				System.out.println("happy");
			}
			
		}
		
		
	}
	
	static void floyd(int[][] arr, int n) {
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(arr[i][j]>arr[i][k]+arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}
	}

}
