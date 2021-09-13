import java.util.*;
class Solution {
    static boolean[] visited;
    static ArrayList<String> list;
    static String route = "";
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length];
        
        visited = new boolean[tickets.length];
        list = new ArrayList<>();
        
        for(int i=0;i<tickets.length;i++){
            if(tickets[i][0].equals("ICN")){
                visited[i] = true;
                String next = tickets[i][1];
                dfs(next,"ICN"+" "+next,tickets, 1);
                visited[i] = false;
            }
        }
        
        Collections.sort(list);
        answer = list.get(0).split(" ");
        
        return answer;
    }
    
    static void dfs(String start, String route , String[][] tickets, int cnt){
        if(cnt == tickets.length){
            list.add(route);
            return;
        }
        
        for(int i=0;i<tickets.length;i++){
            String s = tickets[i][0]; // 시작지점 
            String e = tickets[i][1]; // 도착지점
            if(s.equals(start) && !visited[i]){ // 출발지 같으면
                visited[i] = true;
                route += " " + e;
                dfs(e,route,tickets,cnt+1);
                visited[i] = false;
                route = route.substring(0,route.length() - 4);
            }
        }
    }
}