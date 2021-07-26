import java.util.*;
import java.io.*;

public class boj1753 {
	// boj1753 최단경로 - 다익스트라 
	static class Node {
		int end, weight;
		
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken()); //정점 개수
		int E = Integer.parseInt(st.nextToken()); //간선 개수
		
		int K = Integer.parseInt(br.readLine()); // 시작노드 
		
		ArrayList<Node>[] list = new ArrayList[V+1];
		for(int i=1;i<V+1;i++) {
			list[i] = new ArrayList<>();
		}
		
		int[] d = new int[V+1]; // 노드 간 거리를 저장하기 위한 배열
		
		for(int i=0;i<V+1;i++) {
			d[i] = Integer.MAX_VALUE; // 거리 배열을 최대값으로 초기화
		}
		
		boolean[] visited = new boolean[V+1]; // 방문 체크
		
		
		d[K]=0; //시작노드의 거리는 0으로 초기화
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Node(v,w));
			
			
		}
		

		for(int i=0;i<V-1;i++) {
			int min = Integer.MAX_VALUE;
			int idx = -1;
			for(int j=1;j<V+1;j++) {
				if(!visited[j]&&d[j]<min) {
					min = d[j];
					idx = j;
				}
			}
			visited[idx]=true;
			
			for(Node next : list[idx]) {
				if(!visited[next.end] && d[idx]+next.weight<d[next.end]) {
					d[next.end]=d[idx]+next.weight;
				}
			}
		}
		
		for(int i=1;i<V+1;i++) {
			if(d[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(d[i]);
			}
		}
	
		
		
	}
	

}
