import java.util.*;
import java.io.*;
public class boj16234 {
	static int n;
	static int L,C;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	
	static class spot{
		int x;
		int y;
		spot(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int day = 0; // 날짜 count
		while(true) {
			
			boolean flag = false;
			visited = new boolean[n][n];
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(!visited[i][j]) {
						if(move(i,j)){
							 flag = true; // 인구 이동이 한번이라도 일어났으면 true
						}
					}
				}
			}
			
			
			if(!flag) break; // 인구 이동이 한번도 일어나지 않았을 경우 return
			
			day++;
		}
		
		System.out.println(day);
		
	}

	// 탐색 시작 (bfs) 
	static boolean move(int r,int c) {
		
		boolean isMove = false;
		
		Queue<spot> q = new LinkedList<>(); // 이동할 좌표 저장하기 위한 큐 
		ArrayList<spot> movelist = new ArrayList<>(); // 인구이동이 일어날수있는 도시 list
		
		
		q.offer(new spot(r,c));
		movelist.add(new spot(r,c));
		
		int sum = map[r][c]; // 인구 총합을 저장하기 위한 num -> 초기값 저장
		
		while(!q.isEmpty()) {
			spot cur = q.poll();
			visited[cur.x][cur.y]=true;
			
			int num = map[cur.x][cur.y]; // 현재위치의 인구 수 
			
			// 현재 위치에서부터 탐색
			for(int i=0;i<4;i++) {
				int nx = cur.x + dir[i][0];
				int ny = cur.y + dir[i][1];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) continue; 
				
				// 현재 인구수 - 다음좌표 인구수 => 인구 수 차이 계산
				int diff = Math.abs(num-map[nx][ny]);
				
				if(diff>=L && diff<=C) { // 인구 이동이 가능한 지역이라면
					visited[nx][ny] = true;
					
					movelist.add(new spot(nx,ny)); // 가능지역 리스트에 좌표 넣기 
					q.add(new spot(nx,ny));
					sum += map[nx][ny]; 
				}

			}
		}
		
		// 인구 이동 , 분배
		if(movelist.size()>1) {
			
			//System.out.println("size:"+movelist.size());
			int result = sum/movelist.size(); // 총 인구 수 / 국가 수 => 평균 계산
			
			for(spot s : movelist) {
				map[s.x][s.y] = result; // 인구 이동이 일어난 좌표에 평균값 셋팅 
			}
			
			isMove = true; // 인구이동 여부 true 체크 
			
		}
		
		return isMove;
		
		
	}
}
 S