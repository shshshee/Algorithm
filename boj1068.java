import java.util.*;
import java.io.*;
public class boj1068 {
	// 트리 
	static boolean[] visited;
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		result = 0;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N]; // 노드의 부모 저장 
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int node = Integer.parseInt(br.readLine()); // 지울 노드 
		tree(node,arr); // 노드 지우기 
		
		visited = new boolean[N]; // 리프노드 체크 시 사용 
		
		for(int i=0;i<N;i++) {
			if(arr[i]==-1) {
				cntNode(i,arr); // root 노드부터 탐색
			}
		}
		
		System.out.println(result);
		
	}	
	
	// 리프노드 탐색 - dfs
	static void cntNode(int root, int[] arr) {
		boolean isLeaf = true;
		visited[root] = true;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=-2 && arr[i]==root) {
				 // root의 자식노드일 경우
				cntNode(i,arr);
				isLeaf = false;
			}
		}
		
		if(isLeaf) result++;
	}
	
	// 트리 삭제
	static void tree(int n, int[] arr) {
		
		arr[n] = -2;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==n) {
				tree(i,arr);
			}
		}
		
	}

}
