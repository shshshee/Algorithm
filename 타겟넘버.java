import java.util.*;
import java.io.*;
class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;

        dfs(numbers,target,0,0);

        return answer;
    }


    static void dfs(int[] numbers,int target,int idx, int sum){
        if(numbers.length==idx){
            if(sum==target) answer++;
            return;
        }

        dfs(numbers,target,idx+1,sum+numbers[idx]);
        dfs(numbers,target,idx+1,sum-numbers[idx]);

    }
}
