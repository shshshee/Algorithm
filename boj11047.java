import java.util.*;
import java.io.*;
public class Main {
	//boj 11047번 동전0 - greedy
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 동전 
		int K = Integer.parseInt(st.nextToken()); // 필요한 금액 
		int result=0;
		
		int[] coin = new int[N];
		
		for(int i=0;i<N;i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
	
		for(int i=N-1;i>=0;i--) {
			
			if(K==0) break;

			if(coin[i]<=K) {
				result+=K/coin[i];
				K=K%coin[i];
			}
		}
		
		
		
		System.out.println(result);
		
	}

}
