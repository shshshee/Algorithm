import java.util.*;
import java.io.*;
public class boj11657 {
	// 타임머신 -> 음수의 가중치가 존재하므로 벨만포드 알고리즘 이용 ( 다익스트라 성립 X ) 
	static int N,M;
	static ArrayList<node>[] graph;
	static long[] dist;
	static int INF = Integer.MAX_VALUE;
	
	static class node{
		int end;
		int c;
		
		node(int end,int c){
			this.end=end;
			this.c=c;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		dist = new long[N+1];
		
		Arrays.fill(dist, INF);
		
		for(int i=0;i<N+1;i++) {
			graph[i] = new ArrayList<>();
		}
		
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[u].add(new node(v,w));
		}
		
		boolean result = BellmanFord();
		
		// 최대값을 가지는 노드는 -1 출력
		if(result) {
			System.out.println("-1");
		}else {
			for(int i=2;i<dist.length;i++) {
				if(dist[i]==INF) {
					System.out.println("-1");
				}else {
					System.out.println(dist[i]);
				}
			}
		}
		
		
	}
	
	static boolean BellmanFord(){
		dist[1]=0; // 시작점 - 시작점 거리 0 셋팅 
	
		boolean update = false;
		
		for(int i=1;i<N;i++) { // n-1번 반복
			update = false;
			for(int j=1;j<=N;j++) {
				for(int k=0;k<graph[j].size();k++) {
					node next = graph[j].get(k);
					if(dist[j]==INF) break;
					if(dist[next.end]>dist[j]+next.c) {
						dist[next.end]=dist[j]+next.c;
						update = true;
					}
				}
			}
			
			if(!update) {
				break;
			}
			
		}
		
		// 음의 사이클이 존재하는지 확인
		if(update) {
			for(int i=1;i<=N;i++) {
				for(node n : graph[i]) {
					if(dist[i]==INF) {
						break;
					}
					
					if(dist[n.end]>dist[i]+n.c) {
						return true;
					}
				}
			}
		}
		
		return false;
		
	}

}
