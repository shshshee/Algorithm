import java.util.*;
import java.io.*;
public class boj15686 {
	// 15686 치킨 배달 -> 치킨집을 M개 골랐을때 치킨거리의 최솟값 
	static int N,M;
	static int[][] map;
	static int[] tmp; // 인덱스 저장 
	static int min = Integer.MAX_VALUE;
	static ArrayList<house> hlist = new ArrayList<>();
	static ArrayList<house> clist = new ArrayList<>();
	static boolean[] visited;
	static class house {
		int x;
		int y;
		house(int x,int y){
			this.x=x;
			this.y=y;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 지도 크기 
		M = Integer.parseInt(st.nextToken()); // 치킨집 
		
		map = new int[N][N];
		tmp = new int[M]; // 치킨집 인덱스 저장 
	
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					hlist.add(new house(i,j));
				}else if(map[i][j]==2) {
					clist.add(new house(i,j));
				}
			}
		}
		
		visited = new boolean[clist.size()];
		dfs(0,0);
		
		System.out.println(min);
		
		
	}

	static void dfs(int idx,int cnt) {
		
		if(cnt==M) {
			min = Math.min(min, getdist());
			return;
		}
		
		for(int i=idx;i<clist.size();i++) {
			if(!visited[i]) {
				visited[i]=true;
				tmp[cnt]=i;
				dfs(i,cnt+1);
				visited[i]=false;
			}
		}

	}
	
	static int getdist() {
		// 마을의 치킨거리 구하기
		int dist = 0;

		for(house h : hlist) {
			dist += calc(h.x,h.y);
		}
		
		return dist;
	}
	
	// 해당 집의 치킨거리 
	static int calc(int r, int c) {
		
		int result = Integer.MAX_VALUE;
		
		for(int i=0;i<tmp.length;i++) {
			int idx = tmp[i];
			house ck = clist.get(idx);
			int dist = Math.abs(r-ck.x) + Math.abs(c-ck.y);
			result = Math.min(dist, result);
			
		}
		
		return result;
	}
	
}
