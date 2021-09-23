import java.util.*;
import java.io.*;
public class boj5671 {
	// 5671 호텔 방 번호 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while((str = br.readLine()) != null) {
			String[] s = str.split(" ");
			
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			
			int cnt = 0;
			
			for(int i=N;i<=M;i++) {
				String num = String.valueOf(i);
				boolean[] check = new boolean[10];
				boolean flag = false;
				
				for(int j=0;j<num.length();j++) {
					int n = num.charAt(j)-'0';
					if(!check[n]) {
						check[n] = true;
					}else {
						flag = true;
					}
				}
				
				if(!flag) {
					cnt++;// 겹치지않는경우 
				}
			}
			
			System.out.println(cnt);
			
		}
		
	}

}
