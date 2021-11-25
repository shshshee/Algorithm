import java.util.*;
import java.io.*;
public class boj1715 {
	// 카드 정렬하기 1715 
	static int N=0;
	static long ans=0;
	static PriorityQueue<Long> q = new PriorityQueue<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			q.add(Long.parseLong(br.readLine()));
		}

		while(q.size()>1) {
			long a = q.poll();
			long b = q.poll();
			ans += a + b;
			q.add(a+b);
		}
		
		
		System.out.println(ans);
		
	}

}
