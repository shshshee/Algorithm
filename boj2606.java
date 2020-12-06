import java.util.*;
import java.io.*;
public class boj2606 {
	// 2606 바이러스 문제 - 1번 컴퓨터에 바이러스가 걸렸을 때 1번 컴퓨터를 통해 바이러스가 걸리게되는 컴퓨터수 

	static int N,M; // 컴퓨터 갯수 , 연결된 컴퓨터 쌍의 수 
	static int[][] computer; // 컴퓨터 배열 
	static boolean[] visited; // 방문여부체크 
	static Queue<Integer> q = new LinkedList<Integer>(); // 큐 생성
	static int count; // 최종 갯수 
	
	static void bfs(int num) {
		count = 0; 
		q.add(num);
		visited[num] = true; // 방문체크 
		while(!q.isEmpty()){
			int virus = q.poll();
			for(int i=0;i<N+1;i++) {
				if(computer[virus][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
					count ++ ; 
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		computer = new int[N+1][N+1];
		visited = new boolean[N+1]; 
		
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int nx = Integer.parseInt(st.nextToken());
			int ny = Integer.parseInt(st.nextToken());
			computer[nx][ny] = computer[ny][nx] = 1; // 연결표시 (무방향그래프)
		}
		
		bfs(1); // 1부터 시작 
		System.out.println(count);
		
	}

}
