import java.util.*;
import java.io.*;
public class boj1504 {
	// 특정한 최단 경로
	static int N;
	static int M;
	static ArrayList<Node>[] list;
	static int[] dist;
	static int INF = 200000000;
	
	static class Node {
		int end;
		int cost;
		
		public Node(int end,int cost) {
			this.end = end;
			this.cost = cost;
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dist = new int[N+1];
		list = new ArrayList[N+1];
		
		for(int i=0;i<N+1;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			// 양방향 길이 존재함
			list[u].add(new Node(v,w));
			list[v].add(new Node(u,w));
			
		}
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int ans1 = 0;
		ans1 += dijkstra(1,a);
		ans1 += dijkstra(a,b);
		ans1 += dijkstra(b,N);
		
		int ans2 = 0;
		ans2 += dijkstra(1,b);
		ans2 += dijkstra(b,a);
		ans2 += dijkstra(a,N);
		
		int result = Math.min(ans1, ans2);
		if(result>=INF) result = -1;
		
		System.out.println(result);
		
		

	}
	
	static int dijkstra(int start, int end) {
		
		PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost, o2.cost));
				
		Arrays.fill(dist,INF);
		
		q.offer(new Node(start,0));
		dist[start]=0;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(dist[cur.end]<cur.cost) continue;
			
			for(Node next : list[cur.end]) {
				if(dist[next.end]>dist[cur.end]+next.cost) {
					dist[next.end]=dist[cur.end]+next.cost;
					q.offer(new Node(next.end,dist[next.end]));
				}
			}
			
			
		}
		
		return dist[end];
		
		
	}

}
