import java.util.*;
import java.io.*;
public class Main {
	//색종이 2563
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		boolean[][] visited = new boolean[100][100];
		int result = 0;
		
		for(int i=0;i<n;i++) {
			 st = new StringTokenizer(br.readLine());
			 int x = Integer.parseInt(st.nextToken());
			 int y = Integer.parseInt(st.nextToken());
			 
			 for(int k=x;k<x+10;k++) {
				 for(int j=y;j<y+10;j++) {
					 if(!visited[k][j]) {
						 visited[k][j]=true;
						 result++;
					 }
				 }
			 }
			 
		}
		
		System.out.println(result);
		
	}

}
