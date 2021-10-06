import java.util.*;
import java.io.*;
public class boj11279 {
	// 11279 최대힙 
	// x가 자연수일 때 - x를 추가하는 연산 
	// x가 0이면 가장 큰 값을 출력하고 그 값을 배열에서 제거
	// 배열이 비어있는데 가장 큰 값을 출력하라고 한다면 0을 출력하면 된다. 
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o2-o1); // 내림차순 정렬 
		
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			
				
			if(num==0){ // 0일 경우
				if(pq.isEmpty()) {
					sb.append(0).append('\n');
				}else {
					int max = pq.poll();
					sb.append(max).append('\n');	
				}
					
			}else {
				pq.add(num);
			}
			
			
		}
		
		System.out.println(sb.toString());
		
		
	}

}
