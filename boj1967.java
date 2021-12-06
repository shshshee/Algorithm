import java.util.*;
import java.io.*;
public class boj1967 {
	// 1967 트리의 지름 
	static class Node{
		int end;
		int weight;
		
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}
	static ArrayList<Node>[] tree;
	static int ans; // 결과값
	static boolean[] visited; //dfs 시 방문 여부 저장
	static int s_idx = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i=1;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			tree[s].add(new Node(e,w));
			tree[e].add(new Node(s,w));
			
		}
		
		visited = new boolean[N+1];
		visited[1] = true;
		getMax(1,0);
		
		visited = new boolean[N+1];
		visited[s_idx] = true;
		getMax(s_idx,0);
		
		
		System.out.println(ans);
		
		
	}
	
	
	static void getMax(int s,int res) {
		
		if(res>ans) {
			ans = res;
			s_idx = s; 
		}
		
		for(Node n : tree[s]) {
			if(!visited[n.end]) {
				// 방문하지 않은 노드인 경우 
				visited[n.end] = true;
				getMax(n.end,res+n.weight);
			}
		}
		
	}

}
