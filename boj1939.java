import java.util.*;
import java.io.*;
public class boj1939 {
	// 중량제한 
	static int N; // 섬 갯수 
	static int M; // 줄 갯수 
	static int start, end; // 섬의 출발지 도착지 
	static ArrayList<ArrayList<node>> list = new ArrayList<>();
	static boolean[] visited;
	static class node{
		int end, cost;
		node(int end, int cost){
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
		
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<>());
		}
		
		int max =  0;
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			// 양방향 그래프 
			list.get(s).add(new node(e,v));
			list.get(e).add(new node(s,v));
			
			max = Math.max(max, v); // 가중치 최대값 
			
		}
		
		int left = 0;
		int right = max; // right를 가중치의 최대값으로 지정해준다. 
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken()); // 시작 
		end = Integer.parseInt(st.nextToken()); // 도착 
		
		while(left<=right) {
			int mid = (left+right)/2; // 최대 중량 기준을 mid로 둔다. 
			visited = new boolean[N+1];
			
			if(bfs(start,end,mid)) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
			
		}
		
		System.out.println(right);
		
		
	}
	
	// bfs 
	static boolean bfs(int start, int end, int mid) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start); // 시작 지점 큐에 넣기 
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(now == end) return true;
			
			for(node next : list.get(now)) {
				if(!visited[next.end] && next.cost >= mid) {
					visited[next.end] = true;
					q.add(next.end);
				}
				
			}
		}
		
		return false;
		
	}
	
	

}
