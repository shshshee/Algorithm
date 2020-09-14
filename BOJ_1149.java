import java.util.*;


public class Main {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] arr = new int[N][3];
		
		//케이스 입력받기
		for(int i=0;i<N;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			arr[i][2] = sc.nextInt();
		}
		
		
		for(int i=1;i<N;i++) {
			arr[i][0] += Math.min(arr[i-1][1], arr[i-1][2]);
			arr[i][1] += Math.min(arr[i-1][0], arr[i-1][2]);
			arr[i][2] += Math.min(arr[i-1][1], arr[i-1][0]);
		}
				
		
		System.out.println(Math.min(Math.min(arr[N-1][0],arr[N-1][1]),arr[N-1][2]));
	}


}