import java.util.*;
import java.io.*;
public class boj21608 {
	// 21608 상어 초등학교 
	static int n;
	static int[][] arr;
	static int[][] emptySeat; // 빈자리 체크 
	static int[][] countflist; // 자리 주변 친구 count
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Map<Integer, student> list = new HashMap<>(); // 이미 자리배치 된 사람을 저장하기 위한 list
	
	static class student{
		int x;
		int y;
		int[] numlist;
		public student(int x, int y, int[] numlist) {
			this.x = x;
			this.y = y;
			this.numlist = numlist;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		emptySeat = new int[n][n];
		
		// 주변에 빈 좌석 얼마나 있는지 셋팅
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int cnt = 4;
				if(i==0 || i==n-1) cnt--;
				if(j==0 || j==n-1) cnt--;
				emptySeat[i][j] = cnt;
			}
		}
		
		
		for(int i=0;i<n*n;i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int f1 = Integer.parseInt(st.nextToken());
			int f2 = Integer.parseInt(st.nextToken());
			int f3 = Integer.parseInt(st.nextToken());
			int f4 = Integer.parseInt(st.nextToken());
			
			findseat(s, new int[] {f1,f2,f3,f4});
			
		}
		
		
		int resultScore = 0;
		//학생 만족도 구하기 
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int num = arr[i][j]; // 해당 자리에 앉아있는 상어 
				student s = list.get(num); // 상어 정보 꺼내오기
				int cnt = getfriendNum(s.x,s.y,s.numlist);
				
				if(cnt==0) {
					resultScore += 0;
				}else if(cnt==1) {
					resultScore += 1;
				}else if(cnt==2) {
					resultScore += 10;
				}else if(cnt==3) {
					resultScore += 100;
				}else if(cnt==4) {
					resultScore += 1000;
				}
				
			}
		}
		
		System.out.println(resultScore);
		
		
	}
	
	// 상어 자리 배치 func 
	// 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다. 
	static void findseat(int snum, int[] flist) {
		
		countflist = new int[n][n]; // 
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]==0) {
				//비어있는 칸인 경우
				int cnt = getfriendNum(i,j,flist);
				countflist[i][j] = cnt; // 해당 자리 주변에 몇명 있는지
				//System.out.println("snum:"+snum+" "+i+","+j+","+cnt);
				}
			}
		}
		
		int maxCntFlist = -1; // 주변 친구 수 재일 많은애
		int maxCntEmpty = -1; // 비어있는칸 max
		//자리배치할 자리좌표 
		int seatX = -1;
		int seatY = -1;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j] != 0) continue; //이미 자리배치가 된 곳은 건너뛴다.
				
				if(countflist[i][j]>maxCntFlist) {
					maxCntFlist = countflist[i][j]; // 최대값 set 
					maxCntEmpty = emptySeat[i][j];
					seatX = i;
					seatY = j;
				}else if(countflist[i][j] == maxCntFlist && maxCntEmpty < emptySeat[i][j]) { //주변 친구수 같음 && 
					maxCntEmpty = emptySeat[i][j];
					seatX = i;
					seatY = j;
				}
			}
		}
		
		arr[seatX][seatY] = snum; // 자리 배치 
		list.put(snum,new student(seatX,seatY,flist)); // 자리 배치 후 정보 map에 set
		
		// 빈좌석 count set
		for(int i=0;i<4;i++) {
			int nearX = seatX + dx[i];
			int nearY = seatY + dy[i];
			if(nearX >=0 && nearY >=0 && nearX < n && nearY < n) {
				emptySeat[nearX][nearY]--; // 주변 빈 좌석 -1
			}
		}
		
		
				
	}
	
	// 주변에 친구 몇명 있는지 
	static int getfriendNum(int x, int y, int[] flist) {
		int cnt = 0;
		for(int i=0;i<4;i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			if(nextX >= 0 && nextY >= 0 && nextX<n && nextY<n) {
				for(int f : flist) {
					if(arr[nextX][nextY] == f) {
						cnt ++;
					}
				}
			}
		}
		
		return cnt;
	}

}
