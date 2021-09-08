import java.util.*;
import java.io.*;
public class boj20055 {
	//컨베이어 벨트 위의 로봇 
	static int N;
	static int K;
	static int result; //단계 
	static int[] belt;
	static boolean[] robot;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken())*2;
		K = Integer.parseInt(st.nextToken());
		
		result = 0;
		
		belt = new int[N];
		robot = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		
		while(true) {
			result++;
			rotate();
			moveRobot();
			if(zeroCheck()) break;
		}
		
		System.out.println(result);
		
		
	}
	
	//회전 
	static void rotate() {
		//로봇 , 컨베이어벨트 함께 회전 
		int tmp = belt[N-1];
		
		for(int i=N-2;i>=0;i--) {
			belt[i+1] = belt[i];
		}
		
		belt[0] = tmp;
		
		for(int i=N/2-2;i>=0;i--) {
			robot[i+1]=robot[i];
		}
	
		robot[0] = false; // 회전 후 올리는 위치에는 false 셋팅 
		if(robot[N/2-1]) {
			robot[N/2-1] = false; //내리는 위치 로봇 내리기 
		}
		
	}
	
	//로봇 이동하기 
	static void moveRobot() {
		int last = (N/2)-1;
		
		for(int i=last-1;i>=0;i--) {
			if(robot[i]) {
				if(belt[i+1]>0 && !robot[i+1]) {
					//이동할 수 있는 칸이라면 ? 
					belt[i+1]--;
					robot[i+1]=true;
					robot[i]=false;
				}	
			}
		}
		
		if(robot[last]) {
			robot[last] = false;
		}
		
		// 올리는 위치의 내구도가 0이 아니라면 올리는 위치에 로봇 올리기 
		if(belt[0]>0 && !robot[0]) {
			robot[0] = true;
			belt[0]--;
		}
		
		
	}
	
	//내구성 0 체크
	static boolean zeroCheck() {
		int cnt = 0;
		boolean flag = false;
		
		for(int i=0;i<N;i++) {
			if(belt[i]==0) {
				cnt ++;
			}
		}
		
		if(cnt>=K) {
			flag = true;
		}
		
		return flag;
		
		
	}
	
	
	
	

}
