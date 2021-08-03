import java.util.*;
import java.io.*;
public class boj1922 {
	// 네트워크 연결 
	static int N; // 컴퓨터 수 
	static int M; // 연결할 수 있는 선의 수 
	static int[] parent;
	static PriorityQueue<Node> pq;
	static int answer;
	static class Node {
		int s;
		int e;
		int cost;
		
		Node(int s,int e,int cost){
			this.s=s;
			this.e=e;
			this.cost=cost;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost,o2.cost));
		
		parent = new int[N+1];
		for(int i=1;i<N+1;i++) {
			parent[i]=i;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			pq.offer(new Node(s,e,cost));
		}
		
		answer = 0;
		while(!pq.isEmpty()) {
			
			Node cur = pq.poll();
			
			int s = find(cur.s);
			int e = find(cur.e);
			if(s!=e) { 
				union(s,e);
				answer+=cur.cost;
			}
			
			
		}
		
		System.out.println(answer);
		
	}
	
	//상위 노드 검색
	public static int find(int e) {
		if(parent[e]==e) {
			// 최상위노드일 경우 
			return e;
		}else {
			return parent[e] = find(parent[e]);
		}
	}
	
	public static void union(int s, int e) {
		// 상위노드 검색
		s = find(s); 
		e = find(e);
		
		if(s!=e) {
			parent[e] = s;
		}
		
	}

}
