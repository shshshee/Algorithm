import java.util.*;
import java.io.*;
public class boj11057 {
	//boj 11057 오르막 수 
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int result = 0;
		
		int arr[][] = new int[n+1][10];
		
		// 초기 값 1 대입해주기 
		for(int i=0;i<10;i++) {
			arr[1][i] = 1;
		}
		
		
		for(int i=2; i<=n;i++) {
			for(int j=0;j<10;j++) {
				for(int k=j;k<10;k++) {
					arr[i][j] += arr[i-1][k];
					arr[i][j] %= 10007;
				}
			}
		}
		
		for(int i=0;i<10;i++) {
			result += arr[n][i];
		}
		
		System.out.println(result%10007);
		
	}

}
