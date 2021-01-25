import java.util.*;
import java.io.*;
public class boj2579 {
	//백준 2579 계단오르기 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // n입력받기 
		int[] arr = new int[n+1];
		int[] score = new int[n+1]; // 최댓값 저장 
		
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
		}
		
		score[1]=arr[1];
		
		if(n>=2) {
			score[2]=arr[1] + arr[2];
		}
		
		for(int i=3;i<=n;i++) {
			score[i] = Math.max(score[i-2], arr[i-1]+score[i-3]) + arr[i]; 
		}
		
		System.out.println(score[n]);
		
		
		
	}

}
