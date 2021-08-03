import java.util.*;
import java.io.*;
public class boj1197 {
	// 최소 스패닝 트리
	static int	v,e;
	static int[] parent; // 부모노드
	static PriorityQueue<Node> pq;
	static int answer;
	static class Node {
		int s;
		int e;
		int w;
		
		Node(int s, int e, int w) {
			this.s=s;
			this.e=e;
			this.w=w;
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		pq = new PriorityQueue<Node>((o1,o2)->Integer.compare(o1.w,o2.w));
		
		parent = new int[v+1];
		for(int i=1;i<v+1;i++) {
			parent[i] = i; // 부모 노드 초기화 
		}
		
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			pq.offer(new Node(a,b,w));
		}
		
		answer=0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();

			
			// 부모노드 탐색
			int p1= find(cur.s);
			int p2= find(cur.e);
			
			if(p1!=p2) { // 사이클이 생기지 않을 경우
				union(cur.s,cur.e);
				answer += cur.w;
			}
			
		}
		
		System.out.println(answer);
		
		
	}
	
	// 상위노드 검색 
	public static int find(int e) {
		if(parent[e] == e) {
			return e;
		} else {
			return parent[e] = find(parent[e]);
		}
	}
	
	
	// union
	public static void union(int x, int y) {
		// 상위노드 검색
		int xroot = find(x);
		int yroot = find(y);
		
		if(xroot != yroot) {
			// 상위 노드가 같지 않을 경우
			parent[yroot] = xroot;
		}
	}


}
