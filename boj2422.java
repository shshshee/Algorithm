import java.util.*;
import java.io.*;
public class boj2422 {
	//boj2422 한윤정이 이탈리아에 가서 아이스크림을 사먹는데 -> 조합 사용 
	static boolean[][] arr;
	static boolean[] visited;
	static int[] select = new int[3];
	static int result;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new boolean[n][n];
		visited = new boolean[n];
		result = 0;
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			arr[k-1][j-1]=arr[j-1][k-1]=true;
		}
		
		dfs(0,0,n);
		System.out.println(result);
	}
	
	public static void dfs(int idx, int count, int n) {
		if(count==3) { // 3개의 조합이 이루어 졌을 경우
			if(isvalid()) {
				result++;
			}
			return;
		}
		
		for(int i=idx;i<n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				select[count]=i;
				dfs(i,count+1,n);
				visited[i]=false;
			}
		}
	}
	
	public static boolean isvalid() {
		for(int i=0;i<2;i++) {
			for(int j=i+1;j<3;j++) {
				if(arr[select[i]][select[j]]) {
					return false;
				}
			}
		}
		return true;
	}

}
