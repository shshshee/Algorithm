import java.util.*;
import java.io.*;
public class boj10773 {
	// 제로 
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		
		int result = 0;
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num==0) {
				stack.pop();
			}else {
				stack.add(num);
			}
		}
		
		while(!stack.isEmpty()) {
			result += stack.pop();
		}
		
		System.out.println(result);
		
	}

}
