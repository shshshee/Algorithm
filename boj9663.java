import java.util.*;
import java.io.*;
public class boj9663 {
	// 9663 n-queen -> queen n개를 서로 공격할 수 없도록 놓기 
	static int N;
	static int[] map;
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); 
		
		map = new int[N];
		result = 0;
		nqueen(0);
		
		System.out.println(result);
		
	}
	
	// dfs 
	static void nqueen(int depth) {
		if(depth==N) {
			result++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			map[depth] = i;
			if(isValid(depth)) {
				nqueen(depth+1);
			}

			 
		}
	}
	
	
	// n queen 가능한지 탐색 
	static boolean isValid(int col) {
		
		for(int i=0;i<col;i++) {
			if(map[col]==map[i]) return false;
			// 대각선 
			else if(Math.abs(col-i)==Math.abs(map[col]-map[i])) return false;

		}
		
		return true;
		
		
	}

}
