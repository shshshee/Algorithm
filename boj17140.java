import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class boj17140 {
	// 17140 이차원 배열과 연산 
	// 1. 등장횟수 커지는 순 , 2. 숫자 커지는 순 
	static int[][] arr;
	static int[][] map;
	static int result;
	static class number implements Comparable<number>{
		int num;
		int cnt;
		
		number(int num,int cnt){
			this.num = num;
			this.cnt = cnt;
		}
		
		@Override 
		public int compareTo(number n) {
			if(n.cnt < this.cnt) {
				return 1;
			} else if (this.cnt < n.cnt) {
				return -1;
			} else {
				if(n.num < this.num) {
					return 1;
				}else {
					return -1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[3][3];
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken()); // k가 되기 위한 연산의 최소 시간 출력 
		
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int i;
		for(i=0;i<=100;i++) {
//			System.out.println(i);
//			for(int j=0;j<arr.length;j++) {
//				for(int l=0;l<arr[j].length;l++) {
//					System.out.print(arr[j][l]);
//				}
//				System.out.println();
//			}
			
			if(arr.length >= r && arr[0].length >= c ) {
				if(arr[r-1][c-1]==k) {
					// k가 되었다면 종료
					break;
				}
			}
			
			if(arr.length >= arr[0].length) {
				// 행의갯수 >= 열의 갯수
				r();
			}else {
				c();
			}
		
		}
		
		if(i>100) {
			System.out.println("-1");
		}else {
			System.out.println(i);
		}
		
		
	}
	
	// R연산 - 행의갯수 >= 열의갯수
	static void r() {
		
		map = new int[101][101];
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			int[] temp = new int[101];
			ArrayList<number> list = new ArrayList<>(); // 한 행 저장할 리스트 만들기 
			
			for(int j=0;j<arr[0].length;j++) {
				if(arr[i][j]!=0) {
					// 0이 아닐 경우
					temp[arr[i][j]]++;
				}
			}
			
			for(int j=1;j<temp.length;j++) {
				// 각 숫자 카운팅 결과 리스트에 넣기
				if(temp[j] != 0) {
					list.add(new number(j,temp[j]));
				}
			}
			
			Collections.sort(list); // 리스트 정렬 
			
			int idx = 0;
			for(int j=0;j<list.size();j++) {
				number n  = list.get(j);
				map[i][idx++] = n.num;
				map[i][idx++] = n.cnt;	
				max = Math.max(max, idx);
//				System.out.println("R"+idx);
			}
			
//			for(int j=0;j<map.length;j++) {
//				for(int k=0;k<map[j].length;k++) {
//					System.out.print(map[j][j]);
//				}
//				System.out.println();
//			}
		}
		
		if(max>100) {
			max = 100;
		}
		
		arr = new int[arr.length][max]; // 새 배열 생성
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j] = map[i][j]; // 배열에 다시 옮기기
			}
		}
	}
	
	// C연산 - 행의갯수 < 열의갯수
	static void c() {
		
		map = new int[101][101];
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<arr[0].length;i++) {
			int[] temp = new int[101];
			ArrayList<number> list = new ArrayList<>();
			
			for(int j=0;j<arr.length;j++) {
				if(arr[j][i] != 0) {
					temp[arr[j][i]]++;
				}
			}
			
			for(int j=1;j<temp.length;j++) {
				if(temp[j] != 0) {
					list.add(new number(j,temp[j]));
				}
			}
			
			Collections.sort(list);
			
			int idx = 0;
			for(int j=0;j<list.size();j++) {
				number n = list.get(j);
				map[idx++][i] = n.num;
				map[idx++][i] = n.cnt;
//				System.out.println("c"+idx);
				max = Math.max(idx, max);
			}
								
		}
		
		// 최대 100 으로 설정 
		if(max>100) {
			max = 100;
		}
		
		arr = new int[max][arr[0].length];
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j] = map[i][j];
			}
		}

	}

}
