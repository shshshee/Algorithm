import java.util.*;
import java.io.*;

public class boj5585 {
	// 5585번 거스름돈 greedy 예제
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int money = 1000-n;
		int count = 0;
		
		if(money/500>0) {
			count += money/500;
			money = money%500;
		}
		if(money/100>0) {
			count += money/100;
			money = money%100;
		}
		if(money/50>0) {
			count += money/50;
			money = money%50;
		}
		if(money/10>0) {
			count += money/10;
			money = money%10;
		}
		if(money/5>0) {
			count += money/5;
			money = money%5;
		}
		
		
		System.out.println(count+money);
		
	}
		
}

