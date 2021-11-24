import java.util.*;
import java.io.*;
public class boj7682 {
	// 틱택토 7682
	// x -> o -> x -> o 
	static char[][] map;
	static int x; // x 갯수 저장 
	static int o; // o 갯수 저장 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String s = br.readLine();
			map = new char[3][3];
			
			x=0;
			o=0;
			
			if(s.equals("end")) break;
			
			for(int i=0;i<9;i++) {
				map[i/3][i%3] = s.charAt(i);
			}
			
			if(isValid()) {
				sb.append("valid").append("\n");
			}else {
				sb.append("invalid").append("\n");
			}
			
		}
		
		System.out.println(sb.toString());
		

	}
	
	public static boolean isValid() {
		
		count();
		
		if(x+o == 9) {
			if(x-1 != o || bingo('O')) {
				return false;
			}
			return true;
		}else {
			// 가로 세로 대각선 판별 -> 유효한지 ?
			if(x==o) { // o이 이겨야함 
				boolean xans = bingo('X');
				boolean oans = bingo('O');
				if(oans && !xans) {
					return true;
				}else {
					return false;
				}
			}
			
			else if(x-1 == o) { // x가 이기거나 둘다 져야함
				boolean xans = bingo('X');
				boolean oans = bingo('O');
				if(!oans && xans) {
					return true;
				}else {
					return false;
				}
			}
			
			return false;
			
		}
			
		
	}
	
	public static boolean bingo(char c) {
		
		for(int i=0;i<3;i++) {
			if(map[i][0] == c && map[i][1] == c && map[i][2] == c) {
				return true;
			}
		}
		
		for(int i=0;i<3;i++) {
			if(map[0][i] == c && map[1][i] == c && map[2][i] == c) {
				return true;
			}
		}
		
		if(map[0][0]==c && map[1][1]==c && map[2][2]==c) {
			return true;
		}
		if(map[0][2]==c && map[1][1]==c && map[2][0]==c) {
			return true;
		}
		
		return false;
		
	}
	
	public static void count() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(map[i][j]=='X') x++;
				else if(map[i][j]=='O') o++;
			}
		}
	}
	

}
