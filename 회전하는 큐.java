import java.util.*;
import java.io.*;
public class boj1021 {
	// 1021 회전하는 큐
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); //뽑아내고자 하는 수
		int count = 0;
		
		int[] arr = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		LinkedList<Integer> dq = new LinkedList<>();
		
		for(int i=1;i<=N;i++) {
			dq.add(i);
		}
		
		
		for(int i=0;i<M;i++) {
			
			int idx = dq.indexOf(arr[i]);
			
			if(idx<=dq.size()/2) {
				while(arr[i]!=dq.getFirst()) {
					dq.addLast(dq.removeFirst());
					count++;
				}
			}else {
				while(arr[i]!=dq.getFirst()) {
					dq.addFirst(dq.removeLast());
					count++;
				}
			}
			
			dq.removeFirst();
			
		}
		
		System.out.println(count);
		
		
	}

}
