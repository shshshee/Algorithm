import java.util.*;
import java.io.*;
public class boj11060 {
	// 점프점프 
	static int N;
	static int[] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] d = new int[N]; // 점프 횟수를 저장하기 위한 배열
		for(int i=0;i<N;i++) {
			d[i] = -1;
		}
		
		d[0] = 0; // 처음 좌표 값을 0으로 
		for(int i=0;i<N;i++) {
			if(d[i]==-1) continue;
			for(int j=1;j<=map[i];j++) { // 점프해서 이동 
				if(i+j<N) {
					if(d[i+j] == -1 || d[i+j] > d[i] + 1 ) {
						d[i+j] = d[i] + 1; // 횟수 1 추가
					}
				}
			}
			
		}
		
		System.out.println(d[N-1]);
		
		
		
		
	}
	


}
