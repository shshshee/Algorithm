import java.util.*;
import java.io.*;

public class boj14891 {
	//톱니바퀴 문제 n극은 0 s극은 1
	
	static int[][] wheels = new int[4][8];
	static boolean[] visited; //톱니 방문체크
	static Queue<wheel> q = new LinkedList<wheel>();
	
	static class wheel {
		int num;
		int dir;
		
		wheel(int num, int dir) {
			this.num = num;
			this.dir = dir;
		}
	}
	
	
	// 큐에서 하나씩 뺀 후 톱니바퀴 회전하기
	static void run () {
		while(!q.isEmpty()) {
			wheel whl = q.poll();
			int num = whl.num; // 톱니바퀴 번호 
			int dir = whl.dir; //방향 
			check(num,dir);
			int arr[] = new int[8]; //톱니바퀴 회전을 위해 잠시 옮겨놓을 배열 생성 
			
			// 시계방향으로 회전할 떄
			if(dir == 1) {
				arr[0] = wheels[num][7];
				for(int i=0;i<7;i++) {
					arr[i+1] = wheels[num][i];
				}
			}else { //반시계방향일때
				arr[7] = wheels[num][0];
				for(int i=7;i>0;i--) {
					arr[i-1] = wheels[num][i];
				}
			}
			
			//원래 wheels 배열로 옮기는 작업 
			for(int i=0;i<8;i++) {
				wheels[num][i] = arr[i];
			}
			
			
		}
	}
	
	//회전할때 주변 톱니 큐에 넣기 , 방문한 것은 넣지 않는다. visit 확인
	static void check(int num, int dir) {
		
		int newdir = dir * (-1); // 반대방향으로 설정 
		
		if(num == 0) {
			if(wheels[num][2] != wheels[num+1][6] && !visited[num+1]) { //맞닿은 부분이 같지 않으면 회전가능 -> 큐에 넣기 
				int newnum = num + 1;
				visited[newnum] = true;
				q.add(new wheel(newnum, newdir));
			}
		} else if(num == 3) {
			if(wheels[num][6] != wheels[num-1][2] && !visited[num-1]) {
				int newnum = num - 1;
				visited[newnum] = true;
				q.add(new wheel(newnum,newdir));
			}
		} else {
			// 처음과 끝에 위치한 톱니가 아닐경우 양쪽 다 체크해야함 
			if(wheels[num][2] != wheels[num+1][6] && !visited[num+1]) {
				int newnum = num + 1;
				visited[newnum] = true;
				q.add(new wheel(newnum,newdir));
			}
			if(wheels[num][6] != wheels[num-1][2] && !visited[num-1] ) {
				int newnum = num -1;
				visited[newnum] = true;
				q.add(new wheel(newnum, newdir));
	
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 톱니바퀴 상태 배열 저장
		for(int i=0;i<4;i++) {
			String s = br.readLine();
			for(int j=0;j<8;j++) {
				wheels[i][j] = s.charAt(j)-'0'; // int형으로 변경 
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<K;i++) {
			visited = new boolean[4]; 
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			q.add(new wheel(num,dir));
			visited[num] = true;
			run(); // bfs 동작 
			
		}
		
		int score = 0; // 점수
		
		//점수계산 12시방향 기준 s극일 경우 점수 더하기 
		for(int i=0;i<4;i++) {
			if(i==0 && wheels[i][0] == 1) {
				score = score + 1;
			}
			else if(i==1 && wheels[i][0] == 1 ) {
				score = score + 2;
			}
			else if(i==2 && wheels[i][0] == 1 ) {
				score = score + 4;
			}
			else if(i==3 && wheels[i][0] == 1) {
				score = score + 8;
			}
		}
		
		System.out.println(score);
		
		
	}

}
