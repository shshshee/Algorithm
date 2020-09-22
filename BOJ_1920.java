import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// 1920 수 찾기 
	
	public static int search(int num, int[] a) {
		int low = 0;
		int high = (a.length)-1;
		
		while(low<=high) {
			int mid = (low+high)/2;
			int guess = a[mid];
			if(guess == num) {
				return 1;
			}
			else if(num<guess) {
				high = mid - 1;
			}
			else{
				low = mid + 1;
			}
			
		}
		
		return 0;
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine()); // m 입력 
		
		Arrays.sort(a);
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int num = Integer.parseInt(st.nextToken());
			bw.append(search(num,a)+" ");
				
		}
		
		bw.flush();
		bw.close();
		
		
		
	}

}
