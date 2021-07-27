import java.util.*;
import java.io.*;
public class boj1261 {
	// 1261 - 알고스팟
	static int[][] map;
	static int[][] dist;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}}; // 이동할 수 있는 방향 좌표 저장
	static int N;
	static int M;
	static class Node {
		int x;
		int y;
		int weight;
		
		public Node(int x, int y,int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // 가로 M
		N = Integer.parseInt(st.nextToken()); // 세로 N 
		
		map = new int[N+1][M+1];
		dist = new int[N+1][M+1];
		
		for(int i=0;i<N+1;i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		for(int i=1;i<N+1;i++) {
			String[] a = br.readLine().split("");
			for(int j=1;j<M+1;j++) {
				map[i][j] = Integer.parseInt(a[j-1]);
			}
		}
		
		dijkstra();
		
		System.out.println(dist[N][M]);
		
	}
	
	
	static void dijkstra() {
		PriorityQueue<Node> q = new PriorityQueue<Node>((o1,o2)->Integer.compare(o1.weight, o2.weight));
		q.add(new Node(1,1,0));
		dist[1][1]=0;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(dist[cur.x][cur.y]<cur.weight) continue;
			
			for(int i=0;i<4;i++) {
				int dx = cur.x + dir[i][0]; 
				int dy = cur.y + dir[i][1];
				
				if(dx>0 && dx<=N && dy>0 && dy<=M) { // 유효한 이동범위일 경우
					if(dist[dx][dy]>cur.weight+map[dx][dy]) {
						dist[dx][dy]=cur.weight+map[dx][dy];
						q.add(new Node(dx,dy,dist[dx][dy]));
					}
				}
				
			}
			
			
		}
		
	}

}
