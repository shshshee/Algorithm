import java.util.*;
import java.io.*;
public class boj4803 {
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int idx = 0;
		
		while(true) {
			idx++;
			
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			if(n==0 && m==0) break;
			
			graph = new ArrayList<>();
			for(int i=0;i<=n;i++) {
				graph.add(new ArrayList<>());
			}
			
			visited=new boolean[n+1];
			
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int v = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				graph.get(v).add(e);
				graph.get(e).add(v);
			}
			
			int result = 0;
			for(int i=1;i<=n;i++) {
				if(!visited[i]) {
					result+= isTree(i);
				}
			}
			
			if(result==0) {
				sb.append("Case "+idx+": No trees.");
			}else if(result == 1) {
				sb.append("Case "+idx+": There is one tree.");
			}else {
				sb.append("Case "+idx+": A forest of "+result+" trees.");
			}
			
			sb.append("\n");
			
			
		}
		
		System.out.print(sb);
		br.close();
		
	}
	
	// 트리인지 판별하기 위한 함수
	static int isTree(int i) {
		Queue<Integer> q = new LinkedList<>();
		int node = 0; 
		int edge = 0;
		
		q.offer(i);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			node++;
			visited[cur] = true;
			
			for(int j=0;j<graph.get(cur).size();j++) {
				int next = graph.get(cur).get(j);
				edge++;
				if(!visited[next]) {
					q.offer(next);
				}
			}
			
		}
		
		return (edge/2)+1 == node ? 1 : 0;
		
	}

}
