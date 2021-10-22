import java.util.*;
import java.io.*;
public class boj5014 {
	// 스타트링크 -> 최소값 구하기
	static int F,S,G,U,D;
	static int[] arr;
	static String result; // 결과 저장 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken()); // 제일 높은 층 
		S = Integer.parseInt(st.nextToken()); // 현재 위치 = 시작점
		G = Integer.parseInt(st.nextToken()); // 도착  
		U = Integer.parseInt(st.nextToken()); // 위로 
		D = Integer.parseInt(st.nextToken()); // 아래로 
		arr = new int[F+1]; 
		
		bfs();
		
		System.out.println(result);
		
	}
	
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(S); 
		arr[S] = 1; // 시작층 1 
		
		while(!q.isEmpty()) {
			
			int now = q.poll();
			
			if(now==G){ // 목적지와 같으면 
				result = String.valueOf(arr[now]-1);
				return;
			}
			
			//up
			if(now+U<=F) {
				if(arr[now+U] == 0) {
					// 방문하지 않은 층인 경우 
					arr[now+U] = arr[now] + 1;
					q.add(now+U);
				}
			}
			
			//down
			if(now-D>=1) {
				if(arr[now-D]==0) {
					// 방문하지 않은 층인 경우 
					arr[now-D] = arr[now] + 1;
					q.add(now-D);
				}
			}
			
			
			
		}
		
		result = "use the stairs";
		
		
	}
	


}
