
import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;

        int sum = 0;

        Arrays.sort(d); // 정렬 
        int cnt = d.length;

        while(sum>=0){
            for(int i=0;i<cnt;i++){
                sum += d[i];
            }   
            if(sum<budget || sum == budget){
                break;
            }
            else{
                cnt--;
                sum = 0;
            }
        }

        return cnt;
    }
}
