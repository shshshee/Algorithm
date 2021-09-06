import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        //오름차순 정렬 
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1]-o2[1];
            }
        });


        int min = Integer.MIN_VALUE;
        for(int[] route : routes){
            if(min < route[0]){
                answer++;
                min = route[1];
            }
        }


        return answer;
    }
}