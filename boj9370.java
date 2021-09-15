import java.util.*;
import java.io.*;
public class boj9370 {
	// 미확인 도착지 
	static int[] dist;
	static boolean[] visited;
	static ArrayList<Node>[] graph;
	static ArrayList<Integer> answer;
	static int INF = 99900000;
	
	static class Node implements Comparable<Node>{
		int end;
		int cost;
		
		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());//교차로 
			int m = Integer.parseInt(st.nextToken());//도로 
			int t = Integer.parseInt(st.nextToken());//목적지 후보 갯수 
			
			graph = new ArrayList[n+1];
			visited = new boolean[n+1];
			dist = new int[n+1];
			answer = new ArrayList<>();
			Arrays.fill(dist, INF);
			
			for(int j=0;j<=n;j++) {
				graph[j] = new ArrayList<>();
			}
			
			int[] result = new int[t]; // 목적지 후보 저장할 배열 
			
			st = new StringTokenizer(br.readLine());			
			
			int s = Integer.parseInt(st.nextToken());//출발지 
			int g = Integer.parseInt(st.nextToken());//교차로
			int h = Integer.parseInt(st.nextToken());
			
			for(int j=0;j<m;j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()); // 출발지 
				int b = Integer.parseInt(st.nextToken()); // 도착지 
				int d = Integer.parseInt(st.nextToken()); // 거리
				
				if((a==g && b==h) || (b==g && a==h)) {
					//홀수
					graph[a].add(new Node(b,d*2-1));
					graph[b].add(new Node(a,d*2-1));
				}else {
					//짝수
					graph[a].add(new Node(b,d*2));
					graph[b].add(new Node(a,d*2));
				}
			}
			
			for(int j=0;j<t;j++) {
				result[j] = Integer.parseInt(br.readLine());
				//System.out.println(result[j]);
			}
			
			dijkstra(s);
			
			// 홀수일 경우 
			for(int r : result) {
				//System.out.println(r);
				if(dist[r]%2!=0) {
					answer.add(r);
				}
			}
			
			Collections.sort(answer);
			
			for(int ans : answer) {
				System.out.print(ans+" ");
			}
			//System.out.println();
			
			
			
		}
		
		
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0)); // start -> start = 0
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(dist[cur.end]<cur.cost) continue;
			
			for(Node next : graph[cur.end]) {
				if(dist[next.end]>dist[cur.end]+next.cost) {
					dist[next.end] = dist[cur.end] + next.cost;
					pq.offer(new Node(next.end,dist[next.end]));
				}
			}
			
			
		}
		
	}

}
