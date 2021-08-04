import java.util.*;
import java.io.*;
public class boj1647 {
	// 도시 분할 계획
	static class town {
		int s;
		int e;
		int cost;
		
		town(int s, int e, int cost){
			this.s=s;
			this.e=e;
			this.cost=cost;
		}
		
	}
	
	static int N; // 도시 갯수 
	static int M; // 길 갯수 
	static PriorityQueue<town> pq;
	static int[] parents;
	static int result;
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parents = new int[N+1];
		pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost, o2.cost));
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			pq.offer(new town(s,e,cost));
		}
		
		for(int i=1;i<N+1;i++) {
			parents[i]=i; // 배열 초기화
		}
		
		
		while(!pq.isEmpty()) {
			town cur = pq.poll();
			int x = find(cur.s);
			int y = find(cur.e);
			int cost = cur.cost;
			
			if(x!=y) {
				union(x,y);
				max = Math.max(max, cost);
				result += cost;
			}
			
		}
		
		
		System.out.println(result-max);
		
	}
	
	// 상위노드 검색
	static int find(int e) {
		if(e==parents[e]) {
			return e;
		}else {
			return parents[e]=find(parents[e]);
		}
	}
	
	static void union(int x, int y) {
		
		x = find(x);
		y = find(y);
		
		if(x!=y) {
			parents[y]=x;
		}
		
	}
	
}
