import java.io.*;
import java.util.*;

public class bojbs {
	// 10816 숫자카드 2 
	// 시작 인덱스와 끝점 인덱스를 구하기 위한 함수
	public static int lowindex(int[] narr, int item) {
		int low = 0;
		int high = (narr.length)-1;
		
		while(low<high) {
			int mid = (low+high)/2;
			int guess = narr[mid];
			if(guess>=item) {
				high = mid;
			}else {
				low = mid + 1;
			}
		}
		
		return high;
		
	}
	
	public static int highindex(int[] narr, int item) {
		int low = 0;
		int high = (narr.length)-1;
		
		while(low<high) {
			int mid = (low+high)/2;
			int guess = narr[mid];
			if(guess>item) {
				high = mid;
			}else {
				low = mid + 1;
			}
		}
		if( narr[high] == item ) high++;
		
		return high;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] narr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			narr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(narr); // 정렬 
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int num = Integer.parseInt(st.nextToken());
			bw.append(highindex(narr,num)-lowindex(narr,num)+" ");
		}
		
		bw.flush();
		bw.close();
		
		
	}

}
