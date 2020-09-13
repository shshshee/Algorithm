import java.util.*;

public class Main {

	static int arr[] ;
	
	public static int dp(int N) {
		
		if(N <= 2) {
			return arr[N] = N;
		}
		else if(arr[N]!=0) {
			return arr[N];
		}
		else {
			return arr[N] = dp(N-1) + dp(N-2);
		}
	}
	
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // n 입력받기
		arr = new int[N+1];
		
		System.out.println(dp(N)%15746);
		
	}
}