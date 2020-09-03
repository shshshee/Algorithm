import java.util.*;

public class Main {
	// 9095 1,2,3 더하기
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		
		int t = sc.nextInt(); 
		for(int i=1;i<=t;i++) {
			int num = sc.nextInt(); 
			list.add(ans(num));
		}
		
		for(Integer num : list) {
			System.out.println(num);
		}
		
	}
	
	public static int ans(int num) {
		
		int sum = 0;
		
		if(num <= 1)
			return 1;
		if(num == 2)
			return 2;
		
		for(int i=1;i<=3;i++) {
			sum += ans(num-i);
		}

		return sum;

	}

}
