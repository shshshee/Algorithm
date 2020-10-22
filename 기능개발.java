import java.util.*;
import java.math.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue q = new LinkedList(); 
        ArrayList<Integer> list = new ArrayList<>();

        int length = progresses.length; // 작업 갯수

        for(int i=0;i<length;i++){
            double num =(double)(100-progresses[i])/speeds[i];
            int n = (int)Math.ceil(num);
            q.offer(n);
            progresses[i]= n;
        }

        int count = 0;
        int index = 0;
        int n = progresses[index];

        while(index<length){
            if(n<(int)q.peek()){
                list.add(count);
                n = progresses[index];
                count = 0;
            }else{
                q.poll();
                count++;
                index++;
                if(q.isEmpty()){
                    list.add(count);
                    break;
                }
            }
        }

        int[] answer = new int[list.size()];
        int i=0;
        for(int num:list){
            answer[i++]=num;
        }

        return answer;
    }
}
