import java.util.*;
import java.io.*;
public class boj4485 {
	// 4485 녹색 옷 입은 애가 젤다지 ? 
	static int[][] map; 
	static int[][] dis;
	static int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
	static ArrayList<Integer> result = new ArrayList<>();
	static int N;
	
	static class Node {
		int x;
		int y;
		int cost;
		
		public Node(int x,int y,int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int idx = 1;
		
		while(true) {
			
			N = Integer.parseInt(br.readLine());
			
			if(N==0) break;
			
			map = new int[N][N];
			dis = new int[N][N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<N;i++) {
				Arrays.fill(dis[i],Integer.MAX_VALUE);
			}
			
			int minCost = getMinCost(map[0][0]);
			result.add(minCost);
			
		}
		
		for(int i=1;i<result.size()+1;i++) {
			System.out.println("Problem "+i+": "+result.get(i-1));
		}
		
		
		
	}
	
	static int getMinCost(int start) {
		PriorityQueue<Node> q = new PriorityQueue<Node>((o1,o2)->Integer.compare(o1.cost,o2.cost));
		q.add(new Node(0,0,start));
		dis[0][0]=start;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(dis[cur.x][cur.y]<cur.cost) continue;
			
			for(int i=0;i<4;i++) {
				int dx = cur.x + dir[i][0];
				int dy = cur.y + dir[i][1];
				
				
				if(dx>=0 && dx<N && dy>=0 && dy<N) {
					if(dis[dx][dy]>map[dx][dy]+cur.cost) {
						dis[dx][dy]=map[dx][dy]+cur.cost;
						q.add(new Node(dx,dy,dis[dx][dy]));
					}
				}
				
			}
		}
		
		return dis[N-1][N-1];
		
		
	}

}
