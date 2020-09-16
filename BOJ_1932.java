import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] arr = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<i+1;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i=N-2;i>=0;i--) {
			for(int j=0;j<=i;j++) {
				arr[i][j] += Math.max(arr[i+1][j], arr[i+1][j+1]);
			}
		}
		
		System.out.println(arr[0][0]);
			
		
	}

}
