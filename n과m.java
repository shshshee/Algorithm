import java.io.*;
import java.util.*;

public class nm {
	static int N;
	static int M;
	static boolean[] visited; // 방문체크배열

	// 1부터 n 까지 중에 m개를 고른 수열
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); // 한줄 불러오기

		//n과 m 입력받기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];

		dfs(0, "");

	}

	static void dfs(int counts, String ans) {
		// 고른 수열의 갯수가 M개를 만족한다면 해당 수열을 출력 후 return
		if(counts == M) { 
			  System.out.println(ans.substring(1));
			  return; 
		  }
		 
		
		for(int i = 1; i<=N ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(counts+1, ans + " "+ i);
				visited[i] = false; 
			}
		}
		
		
	}

}
