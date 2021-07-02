import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {

        int answer = 0;

        ArrayList<Character> list = new ArrayList<>();
        // 스킬 순서 list에 넣기
        for(int i=0;i<skill.length();i++){
            list.add(skill.charAt(i));
        }

        // 스킬 비교
        int count = 0;
        for(int i=0;i<skill_trees.length;i++){
            String stree = skill_trees[i]; //i번째 스킬 가져오기
            int size = stree.length();
            int beforeIdx = -1;
            count = 0;
            for(int j=0;j<size;j++){ // 스킬 글자 하나씩 비교
                if(!list.contains(stree.charAt(j))){
                    count++;
                    continue;
                }else{ // 해당 스킬 있으면 index를 찾아서 beforeidx에 값 넣어주기
                    int nowIdx = list.indexOf(stree.charAt(j));
                    if(beforeIdx+1==nowIdx){
                        count++;
                        beforeIdx=nowIdx; // 이전 인덱스 값에 갱신
                    }else{
                        break;
                    }
                }
            }
            if(count==size) answer++;

        }


        return answer;
    }
}