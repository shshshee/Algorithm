import java.util.*;
import java.io.*;
public class boj14889 {
	// 스타트와 링크
	static int[][] arr; // 능력치 
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); 
		arr = new int[N][N];
		visited = new boolean[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);
		
		System.out.println(min); // 최소값 출력
		
	}
	
	// 최소값 구하기 위한 메소드
	static void getMin() {
		int[] start = new int[N/2]; //start 값
		int[] link = new int[N/2]; //link 값
		int s_idx=0;
		int l_idx=0;
		for(int i=0;i<N;i++) {
			if(visited[i]) {
				start[s_idx++] = i;
			}else {
				link[l_idx++]=i;
			}
		}
		
		// start, link 각각 점수 계산 
		int s_score = getScore(start);
		int l_score = getScore(link);
		
		int min_val = Math.abs(s_score-l_score); // start, link 차이 -> 절대값 계산 
		min = Math.min(min, min_val);		
		
	}
	
	
	// 점수 계산 
	static int getScore(int[] score) {
		
		int result = 0;
		
		for(int i=0;i<score.length-1;i++) {
			for(int j=i+1;j<score.length;j++) {
				result+=arr[score[i]][score[j]]+arr[score[j]][score[i]];
			}
		}
		
		return result;
		
	}
	
	// 2명 고르기
	static void dfs(int idx, int count) {
		if(count==N/2) {
			getMin();
			return;
		}
		
		for(int i=idx;i<N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				dfs(i,count+1);
				visited[i]=false;
			}
		}
		
	}

}
