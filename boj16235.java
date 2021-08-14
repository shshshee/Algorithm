import java.util.*;
import java.io.*;
public class boj16235 {
	static int[][] map;
	static int[][] A; //양분 저장을 위한 배열 A 
	static int N,M,K;
	static int[] dy = {-1,-1,-1,0,0,1,1,1};
	static int[] dx = {-1,0,1,-1,1,-1,0,1};
	static PriorityQueue<tree> pq; // 나이 어린 나무부터 물 공급
	static Queue<tree> dieTree = new LinkedList<>(); // 죽은 나무 저장할 큐 생성
	static Queue<tree> growTree = new LinkedList<>(); // 나이 먹은 트리 저장
	
	static class tree{
		int x;
		int y;
		int year;
		
		tree(int x,int y,int year){
			this.x=x;
			this.y=y;
			this.year=year;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1.year, o2.year)); // 나무 저장할 우선순위 큐 생성 -> 어린 나이 나무부터 물 주기 위해
		map = new int[N+1][N+1];
		A = new int[N+1][N+1];
		for(int i=1;i<N+1;i++) {
			Arrays.fill(map[i], 5);
		}
		
		
		// A 배열 입력받기 (양분) 
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<N+1;j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 나무 위치 입력받기
		for(int i=1;i<M+1;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			
			pq.offer(new tree(x,y,year));
			
		}
		
		//k년동안 반복
		for(int i=0;i<K;i++) {
			spring();
			summer();
			autumn();
			winter();
		}
		
		// 살아있는 나무 갯수 -> 큐의 사이즈 
		System.out.println(pq.size());
		
	}
	
	//봄 -> 양분먹기 , 죽기 
	static void spring() {
		
		while(!pq.isEmpty()) {
			tree t = pq.poll();
			if(map[t.x][t.y]>=t.year) {
				// 양분을 먹을수 있는 경우 -> 나이 +1 해서 다시 set
				map[t.x][t.y]-=t.year;
				growTree.offer(new tree(t.x,t.y,t.year+1));
			}else {
				// 양분을 먹을 수 없는 경우 -> 번식하기 위해 그대로 넣어둠
				dieTree.offer(t);
			}
		}
	}
	
	//여름 -> 죽은나무/2 해당 칸에 양분으로 추가 
	static void summer() {
		
		while(!dieTree.isEmpty()) {
			tree t = dieTree.poll();
			int food = t.year/2; // 나이 
			map[t.x][t.y] += food; // 양분추가
		}
		
	}
	
	//가을 -> 5배수일때 번식 
	static void autumn() {
		// 돌면서 5의 배수 검사 후 -> 주변 번식 
		Queue<tree> tmp = new LinkedList<>();
		
		for(tree t : growTree) {
			if(t.year%5==0) { // 5로 나누어 떨어진다면 ? 
				tmp.offer(new tree(t.x,t.y,t.year)); // 옮기기
			}
		}
		
		while(!tmp.isEmpty()) {
			tree t = tmp.poll();
			for(int i=0;i<8;i++) {
				int x = t.x + dx[i];
				int y = t.y + dy[i];
				
				if(x>0 && x<N+1 && y>0 && y<N+1 ) { // 번식 가능 범위라면 ? 
					growTree.offer(new tree(x,y,1)); // 나이 1살로 번식하기
				}
				
			}
		}
		
		pq.addAll(growTree);
		growTree.clear();
		
		
	}
	
	//겨울 -> A 배열에 저장된 양분 추가
	static void winter() {
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<N+1;j++) {
				map[i][j] += A[i][j];
			}
		}
	}
	
	

}
