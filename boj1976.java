import java.util.*;
import java.io.*;
public class boj1976 {
	// 1976 여행 가자 - union find 
	static int n;
	static int m;
	static int[] city;
	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		city = new int[m];
		parent = new int[n+1];

		// 부모노드 저장하기 -> 현재는 아직 연결된 것이 없으므로 자기 자신을 부모로 설정한다. 
		for(int i=1;i<=n;i++) {
			parent[i] = i;
		}
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				int value = Integer.parseInt(st.nextToken());
				if(value == 1) {
					union(i,j); //연결 노드 합치기 
					
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {			
			// 지나가야할 도시 배열에 추가하기 
			city[i] = Integer.parseInt(st.nextToken());
			
		}
		
		String answer = "YES";
		int start = find(city[0]); 
		for(int i=0;i<m;i++) {
			if(start!=find(city[i])) {
				answer = "NO";
			}
		}
		
		System.out.println(answer);
		
		
		
	}
	
	
	// 연결 노드 합치기 
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x!=y) {
			if(x<y) {
				parent[y]=x; 
			}else {
				parent[x]=y;
			}
			
		}
	}
	
	
	
	// 부모노드 찾기 위한 함수 
	static int find(int node) {
		if(parent[node] == node) {
			return node;
		} else {
			return parent[node] = find(parent[node]);
		}
	}
}
