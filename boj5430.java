import java.util.*;
import java.io.*;
public class boj5430 {
	// 5430 AC 
	// 입력받은 배열 문자열 쪼개서 덱에 넣어주기
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // testcase 갯수
		
		for(int i=0;i<T;i++) {
			String p = br.readLine(); // 수행할 함수 p
			int n = Integer.parseInt(br.readLine()); // 배열 크기
			
			String input = br.readLine();
			String[] arr = input.substring(1,input.length()-1).split(",");
			
			Deque<Integer> deque = new ArrayDeque<>();
			
			for(int j=0;j<arr.length;j++) {
				if(!arr[j].equals("")) {
					// 공백이 아닌경우
					deque.add(Integer.parseInt(arr[j])); // 입력받은 배열 모두 deque에 넣어주기	
				}
			}
			
			AC(deque,n,p);
			
		}
		
		System.out.println(sb.toString());
		
		
	}
	
	// AC 실행
	static void AC(Deque<Integer> deque, int n, String func) {
		
		boolean flag = true; // false 일 경우 역방향
		boolean error = false;
		
		for(int i=0;i<func.length();i++) {
			
			char s = func.charAt(i);
			
				if(s=='R') {
					// 뒤집기
					if(flag) {
						flag = false;
					}else {
						flag = true;
					}
					
				}else if(s=='D') {
					// 맨 앞 원소 삭제하기
					if(!deque.isEmpty()) {
						if(flag) {
							deque.removeFirst();
						}else {
							//역방향일 경우
							deque.removeLast();
						}	
					}else {
						// 에러 난 경우
						error = true;
					}
				}	
		}
		
		makeArr(deque,flag,error);
		
	}
	
	// 배열 만들어주기 
	static void makeArr(Deque<Integer> deque, boolean flag, boolean error) {
		// flag가 false 이면 뒤집기 
		if(error) {
			sb.append("error").append('\n');
		}else {
			sb.append('[');
			while(!deque.isEmpty()) {
				int num = 0;
				if(flag) {
					num = deque.pollFirst();
				}else {
					num = deque.pollLast();
				}
					
				if(deque.size()>0) {
					sb.append(num).append(',');
				}else {
					sb.append(num);
				}
			}
			sb.append(']').append('\n');	
			
			
		}
	}
	
	
	

}
