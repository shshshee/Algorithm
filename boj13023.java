import java.util.*;
import java.io.*;
public class boj13023 {
	// ABCDE 
	static int N;
	static int M;
	static ArrayList<ArrayList<Integer>> friend;
	static boolean[] visited;
	static boolean result;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		friend = new ArrayList<ArrayList<Integer>>(); // 그래프 
		result = false;
		
		for(int i=0;i<N;i++) { // 갯수만큼 리스트 생성 
			friend.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			friend.get(a).add(b); // 리스트 연결 
			friend.get(b).add(a);
		}
		
		for(int i=0;i<N;i++) {
			visited = new boolean[N];
			dfs(i,0);
			if(result) {
				break;
			}
		}
		
		if(result) {
			System.out.println("1");	
		}else {
			System.out.println("0");
		}
		
		
	}
	
	// dfs 관계 여부 평가
	public static void dfs(int idx, int depth) {
		
		if(depth == 4) {
			result = true;
			return;
		}
		
		visited[idx] = true;
		for(int node : friend.get(idx)) {
			if(!visited[node]) {
				visited[node] = true;
				dfs(node,depth+1);
				if(result) {
					return;
				}
				visited[node] = false;
			}
		}
		
		
	}

}
