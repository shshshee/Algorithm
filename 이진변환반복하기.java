import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        ArrayList<Character> list = new ArrayList<>();

        int cnt = 0; // 이진변환 횟수 
        int zero = 0; // 제거된 0의 갯수

        for(int i=0;i<s.length();i++){
            list.add(s.charAt(i));
        }

        while(true){

            if(list.size()==1&&list.get(0)=='1') break;

            while(list.remove((Character)'0')){
                zero++;
            }

            System.out.println(list.toString());

            int len = list.size(); //리스트 사이즈 구하기 
            list.clear();

            String a = Integer.toBinaryString(len);
            for(int i=0;i<a.length();i++){
                list.add(a.charAt(i));
            }

            cnt++;

        }

        answer[0]=cnt;
        answer[1]=zero;

        return answer;
    }
}
