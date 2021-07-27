import java.util.*;
import java.io.*;
public class boj1916 {
	// boj1916 최소비용 구하기 
	static ArrayList<Node>[] list;
	static int[] dist; // 거리 저장 배열
	
	static class Node{
		int end;
		int weight;
		
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 도시의 개수
		int M = Integer.parseInt(br.readLine()); // 버스의 개수 
		
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE); // 최대값으로 채워넣기
		
		list = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			list[i]=new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken()); // 시작
			int v = Integer.parseInt(st.nextToken()); // 도착
			int w = Integer.parseInt(st.nextToken()); // 거리
			
			list[u].add(new Node(v,w)); // 노드 연결
			
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()); //출발점 
		int end = Integer.parseInt(st.nextToken()); //도착지점
		
		dijkstra(start);
		
		System.out.println(dist[end]);
		
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<Node>((o1,o2)->Integer.compare(o1.weight, o2.weight)); // 우선순위 큐 생성 
		q.offer(new Node(start,0)); 
		dist[start]=0;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(dist[cur.end]<cur.weight) continue;
			
			// 선택된 주변노드 탐색
			for(int i=0;i<list[cur.end].size();i++) {
				Node next = list[cur.end].get(i);
				if(dist[next.end]>cur.weight+next.weight) {
					dist[next.end] = cur.weight+next.weight;
					q.offer(new Node(next.end,dist[next.end]));
				}
			}
			
		}

	}

}
