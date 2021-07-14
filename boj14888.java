import java.util.*;
import java.io.*;
public class boj14888 {
	//백준 14888 연산자 끼워넣기 
	//static char[] operator = {'+','-','*','/'};
	
	public static int max = Integer.MIN_VALUE; // 최대
	public static int min = Integer.MAX_VALUE; // 최소
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N]; //숫자 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		// 덧셈, 뺄셈, 곱셈, 나눗셈 
		st = new StringTokenizer(br.readLine());
		int[] operator = new int[4];
		for(int i=0;i<4;i++) {
			operator[i]=Integer.parseInt(st.nextToken());
		}
		
		dfs(arr,N,operator,1,arr[0]); // 전체 탐색
		
		System.out.println(max);
		System.out.println(min);
		
	}
	
	//idx 늘려가면서 num에 계산결과 누적시키기
	public static void dfs(int[] arr, int N, int[] operator, int idx, int num) {
		if(idx==N) {
			max=Math.max(max, num);
			min=Math.min(min, num);
			return;
		}
		
		for(int i=0;i<4;i++) {
			if(operator[i]>0) {
				operator[i]--;
				
				switch(i) {
					case 0: dfs(arr,N,operator,idx+1,num+arr[idx]); break;
					case 1: dfs(arr,N,operator,idx+1,num-arr[idx]);	break;
					case 2: dfs(arr,N,operator,idx+1,num*arr[idx]); break;
					case 3: dfs(arr,N,operator,idx+1,num/arr[idx]); break;
				}
				
				
				operator[i]++;
			}
		}
	}
	
	

}
