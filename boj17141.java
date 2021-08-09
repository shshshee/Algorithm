import java.util.*;
import java.io.*;
public class boj17141 {
	// 연구소 2 
	static int N,M;
	static int[][] map;
	static int[][] copymap;
	static boolean[] visited;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static ArrayList<spot> list = new ArrayList<>();
	static Queue<spot> q = new LinkedList<>();
	static int min = Integer.MAX_VALUE;
	
	static class spot {
		int x;
		int y;
		int virus;
		
		spot(int x,int y, int virus){
			this.x=x;
			this.y=y;
			this.virus=virus;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		copymap = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					list.add(new spot(i,j,0));
				}
			}
		}
		
		visited = new boolean[list.size()];
		dfs(0,0);
		
		if(min==Integer.MAX_VALUE) {
			System.out.println("-1");
		}else {
			System.out.println(min);
		}
		
	}
	
	static void dfs(int idx,int depth) {
		if(depth==M) {
			int time = spread();
			if(isSpread()) {
				min = Math.min(min, time);
			}
			return;
		}
		
		for(int i=idx;i<list.size();i++) {
			if(!visited[i]) {
				visited[i]=true;
				dfs(i+1,depth+1);
				visited[i]=false;	
			}
		}
	}
	
	// 바이러스 확산 - return 시간초
	static int spread() {
		
		copymap(); // bfs가 진행될 때 마다 배열 복사를 진행한다.
		int time = 0;
		
		
		// 선택된 M개의 바이러스 큐에 넣기
		for(int i=0;i<visited.length;i++) {
			if(visited[i]) {
				spot s = list.get(i);
				copymap[s.x][s.y]=1;
				q.add(s); 
			}
		}
		
		while(!q.isEmpty()) {
			spot now = q.poll();
			time = Math.max(time,now.virus);
			
			for(int i=0;i<4;i++) {
				int dx = now.x + dir[i][0];
				int dy = now.y + dir[i][1];
				
				if(dx>=0 && dy>=0 && dx < N && dy < N) {
					if(copymap[dx][dy]==0 || copymap[dx][dy]==2) {
						// 바이러스가 퍼질 수 있는 곳이라면 -> 해당 배열 값을 1로 변경 후 큐에 넣어주기
						copymap[dx][dy]=1;
						q.offer(new spot(dx,dy,now.virus+1));
						
					}
				}
				
			}
			
		}
		
		
		return time;
		

	}
	
	
	// 모두 확산되었는지 확인 -> 0인 칸이 존재한다면 return false 를 반환해준다.
	static boolean isSpread() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(copymap[i][j]==0) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	// 배열 복사 
	static void copymap() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				copymap[i][j]=map[i][j];
			}
		}
	}

}
