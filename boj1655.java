import java.util.*;
import java.io.*;
public class boj1655 {
	// 1655 가운데를 말해요 
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2)->o2-o1); // 최대
		
		int n = Integer.parseInt(br.readLine());
		
		
		//1. maxheap에 추가 후 minheap에 추가하면서 두개의 길이를 지속적으로 맞춰줌 
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(i%2==0) maxHeap.add(num);
			else minHeap.add(num);
			
			if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
				if(maxHeap.peek() > minHeap.peek()) {
					minHeap.add(maxHeap.poll());
					maxHeap.add(minHeap.poll());
				}
			}
			
			sb.append(maxHeap.peek()).append("\n");
			
		}
		
		System.out.println(sb.toString());
		
		
	}

}
