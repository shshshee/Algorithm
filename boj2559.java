import java.util.*;
import java.io.*;
public class boj2559 {
	// 후보 추천하기 
	static class student implements Comparable<student> {
		int num;
		int count; // 추천 수 카운트 
		int seq; // 들어온 순서
		
		public student(int num, int count, int seq) {
			this.num = num;
			this.count = count;
			this.seq = seq;
		}
		
		@Override
		public int compareTo(student o2) {
			if(this.count == o2.count) {
				// 추천 수가 같을 경우 
				return this.seq-o2.seq; // 먼저 들어온 순
			}
		
			return this.count - o2.count; // 추천 수 낮은 순 
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 사진 틀 갯수 
		int M = Integer.parseInt(br.readLine()); // 학생 추천 횟수
		ArrayList<student> list = new ArrayList<>();
		boolean[] visited = new boolean[101]; // 방문 체크 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int snum = Integer.parseInt(st.nextToken());
			
			if(visited[snum]) {
				// 이미 후보에 올라가있는 경우 -> 횟수만 증가시켜줌 
				for(int j=0;j<list.size();j++) {
					student s = list.get(j);
					if(s.num == snum) {
						// 횟수 증가시켜 다시 넣어줌 
						list.set(j, new student(s.num,s.count+1,s.seq));
					}
				}
				continue;
			}
			
			if(list.size()==N && !visited[snum]) {
				// 사진 틀이 꽉찬 경우 -> 삭제 후 방문체크 해제 
				Collections.sort(list);
				student s = list.remove(0); 
				visited[s.num] = false; 
			}
			
			visited[snum] = true;
			list.add(new student(snum,1,i));
			
		}
		
		int[] result = new int[list.size()];
		for(int i=0;i<list.size();i++) {
			result[i] = list.get(i).num;
		}
		
		Arrays.sort(result);
		
		for(int ans : result) {
			System.out.print(ans+" ");
		}
		
		
		
	}

}
