import java.util.*;
import java.io.*;
public class boj1759 {
	// 1759 암호 만들기 -> 정렬 후 조합으로 구성하기
	// 최소 한개의 모음과 두개의 자음 
	static int L;
	static int C;
	static boolean[] visited;
	static Character[] arr;
	static Character[] password; //패스워드 조합을 저장하기 위한 배열
	static Character[] vowel = {
			'a','e','i','o','u'
	};
	
 	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		visited = new boolean[C];
		arr = new Character[C];
		password = new Character[L];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			arr[i]=st.nextToken().charAt(0);
		}
		
		
		//정렬
		Arrays.sort(arr);
		
		dfs(0,0);
		
	}

	public static void dfs(int idx, int count) {
		if(count==L) {
			if(checkPwd()) {
				for(char a : password) {
					System.out.print(a);
				}
				System.out.println();
			}
			return;
		}
		
		
		for(int i=idx;i<C;i++) {
			if(!visited[i]) {
				visited[i]=true;
				password[count]=arr[i];
				dfs(i,count+1);
				visited[i]=false;
			}
		}
		
	}
	
	//최소 한개의 모음과 두개의 자음 체크
	public static boolean checkPwd() {
		
		int c = 0; // 자음 2개 이상
		int v = 0; // 모음 1개 이상 
		
		for(int i=0;i<password.length;i++) {
			for(int j=0;j<vowel.length;j++) {
				if(vowel[j]==password[i]) {
					v++; // 모음 count
				}
			}
		}
		
		c = password.length-v; 
		
		if(c<2||v<1) return false;
		
		return true;
	}
}
