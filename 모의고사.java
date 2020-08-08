import java.util.*;

class Solution {
    public int[] solution(int[] answers) {

        int size = answers.length; // 정답 배열 길이 
        int[][] student = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };

        int[] result = new int[3];

        //int index = 0; // 학생 번호 index 

        for(int j=0;j<3;j++){
            int count = 0; // 맞은갯수 count
            for(int i=0;i<size;i++){ 
                int stsize = student[j].length;
                if(i<stsize && answers[i] == student[j][i]){
                    count++;
                }
                else if(stsize<=i && answers[i]==student[j][i%stsize]){
                    count++;
                }
            }
            result[j] = count;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        int maxvalue = Math.max(Math.max(result[0],result[1]),result[2]);
        if(maxvalue == result[0]) list.add(1);
        if(maxvalue == result[1]) list.add(2);
        if(maxvalue == result[2]) list.add(3);

        int[] answer = new int[list.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }


        return answer;
    }
}