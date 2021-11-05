import java.util.*;
import java.io.*;
public class boj12886 {
	// 돌 그룹 12886
	static int[] group;
	static class stone{
		int a;
		int b;
		int c;
		
		public stone(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		group = new int[3];
		
		group[0] = Integer.parseInt(st.nextToken());
		group[1] = Integer.parseInt(st.nextToken());
		group[2] = Integer.parseInt(st.nextToken());
		
		
		System.out.println(bfs(group));
		
		
		
	}
	
	static int bfs(int[] group) {
		
		if((group[0]+group[1]+group[2])%3 != 0) {
			return 0;
		}
		
		Queue<stone> q = new LinkedList<>(); // 큐 생성 
		boolean[][] visited = new boolean[2000][2000];
		
		q.add(new stone(group[0],group[1],group[2]));
		
		while(!q.isEmpty()) {
		
			stone s = q.poll();
			
			int a = s.a;
			int b = s.b;
			int c = s.c;
			
			// 돌의 갯수가 셋으로 나눠졌다면 
			if(a == b && b == c) {
				return 1;
			}
			
			if(a != b) {
				int na = a > b ? a - b : a * 2;
				int nb = a > b ? b * 2 : b - a;
				
				if(!visited[na][nb]) {
					visited[na][nb] = true;
					q.add(new stone(na,nb,c));
				}
			}
			
			if(a != c) {
				int na = a > c ? a - c : a * 2;
				int nc = a > c ? c * 2 : c - a;
				
				if(!visited[na][nc]) {
					visited[na][nc] = true;
					q.add(new stone(na,b,nc));
				}
			}
			
			if(b != c) {
				int nb = b > c ? b - c : b * 2;
				int nc = b > c ? c * 2 : c - b;
				
				if(!visited[nb][nc]) {
					visited[nb][nc] = true;
					q.add(new stone(a,nb,nc));
				}
			}
			
			
		}
		
		return 0;
		
		
	}

}
