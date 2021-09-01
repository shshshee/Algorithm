import java.util.*;
class Solution {
    static ArrayList<String> list = new ArrayList<>(); // 결과 저장하기 위한
    static HashMap<String,Integer> map;
    static boolean[] checked;
    static char[] menu;

    public String[] solution(String[] orders, int[] course) {
        String[] answer;

        for(int i=0;i<orders.length;i++){
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr); // 오름차순 정렬 
            orders[i] = String.valueOf(arr); // 오름차순 정렬 후 해당 값 다시 수정
        }

        // 조합 구하기
        for(int i=0;i<course.length;i++){
            int num = course[i];
            int max = -1;
            map = new HashMap<>();
            menu = new char[num];

            for(int j=0;j<orders.length;j++){
                String order = orders[j];
                checked = new boolean[order.length()];
                if(num<=order.length()){
                    dfs(num,order,0,0);   
                }
            }

            for(Map.Entry<String,Integer> entry : map.entrySet()){
                max = Math.max(entry.getValue(),max);
            }

            for(Map.Entry<String,Integer> entry : map.entrySet()){
                int count = entry.getValue();
                if(max == count && count > 1){
                    // 횟수가 2 이상이며 최댓값일 경우 
                    list.add(entry.getKey());
                }
            }

        }

        Collections.sort(list);

        answer = new String[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }


        return answer;
    }

    // 조합 구하기 
    public static void dfs(int num, String order ,int idx, int cnt) {

        if(cnt == num){
            // 조합 map에 넣기 
            String combi = String.valueOf(menu);
            map.put(combi,map.getOrDefault(combi,0)+1);
            return;
        }

        for(int i=idx;i<order.length();i++){
            if(!checked[i]){
                checked[i] = true;
                menu[cnt] = order.charAt(i);
                dfs(num,order,i,cnt+1);
                checked[i] = false;
            }
        }


    }

}