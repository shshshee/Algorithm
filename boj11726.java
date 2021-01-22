import java.util.*;
import java.io.*;
public class boj11726 {
	// 2xn 타일링 
	//2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
	// 출력 ) 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
	
	static int dp(int tiles[], int n) {
		tiles[0] = 1;
		tiles[1] = 1;
		
		for(int i=2;i<=n;i++) {
			int num = tiles[i-1] + tiles[i-2];
            tiles[i] = num % 10007;
		}
		
		return tiles[n];
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // n 입력받기
		int tiles[] = new int[1001]; // 타일 가지수 저장하기 위한 배열 생성 
		
		System.out.println(dp(tiles,n));
		
		
	}

}

