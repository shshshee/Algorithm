import java.util.*;
class Solution {
    
    static ArrayList<String> list = new ArrayList<String>();
    static HashMap<String,String> map = new HashMap<>();
    static String[][] stateArr;
    
    public String[] solution(String[] record) {
        String[] answer;
        StringBuilder sb;
        
        stateArr = new String[record.length][2];
        
        for(int i=0;i<record.length;i++){
            String str = record[i];
            String[] tmp = str.split(" ");
            stateArr[i][0] = tmp[0];
            stateArr[i][1] = tmp[1];
            if(!tmp[0].equals("Leave")){
                map.put(tmp[1],tmp[2]);
            }
        }
            
        for(int i=0;i<stateArr.length;i++){

            String state = stateArr[i][0];
            String id = stateArr[i][1];
            
            if(!state.equals("Change")){ 
                sb = new StringBuilder();
                sb.append("").append(map.get(id)).append("님이 ");
                if(state.equals("Enter")){
                    sb.append("들어왔습니다.");
                }else if(state.equals("Leave")){
                    sb.append("나갔습니다.");
            }
                list.add(sb.toString());   
            }

        }
        
        answer = new String[list.size()]; // 리스트 크기만큼 배열 생성
        
        int idx = 0;
        for(String a : list){
            answer[idx++] = a;
        }
        
        
        return answer;       
    }
    
}