import java.util.*;
class Solution {
    static int[][] dir ={{1,0},{0,1},{-1,0},{0,-1}};
    static String[][] map = new String[5][5];
    static boolean[][] visited;
    static class seat {
        int x;
        int y;
        seat (int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        Arrays.fill(answer,1);
        
        // 5개 대기실 반복 
        for(int t=0;t<5;t++){
                
            // string 분할 -> 각각 배열에 넣어주기 
            for(int i=0;i<5;i++){
                String r = places[t][i];
                map[i] = r.split("");
            }
            
            // 좌석 찾으면 bfs 실행 
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    if(map[i][j].equals("P")){
                        boolean flag = bfs(i,j);
                        if(!flag){
                            //한명이라도 거리두기를 시행하지 않고 있다면 
                            // 해당 배열에 0 대입 후 break -> 바로 다음 대기실 탐색 시작
                            answer[t]=0;
                            break;
                        }
                    }
                }
            }
        
        }

        return answer;
    }
    
    //bfs 
    static boolean bfs(int pr,int pc){
            Queue<seat> q = new LinkedList<>(); // 큐 생성
            visited = new boolean[5][5]; // p주변 탐색 배열 초기화 
            visited[pr][pc]=true; // 방문체크 
            q.offer(new seat(pr,pc));
        
            while(!q.isEmpty()){
                
                seat s = q.poll();
                
                for(int i=0;i<4;i++){
                    int x = s.x+dir[i][0];
                    int y = s.y+dir[i][1];
                
                    if(x<0 || x>=5 || y<0 || y>=5) continue;
                    
                    int dist = Math.abs(pr-x) + Math.abs(pc-y);
                    // 주변 좌석 탐색
                    if(!visited[x][y] && dist <= 2){
                        visited[x][y]=true;
                        if(map[x][y].charAt(0)=='P'){
                            // 한명이라도 거리두기를 지키지 않고 있다면
                            return false;
                        }else if(map[x][y].charAt(0)=='O'){
                            q.offer(new seat(x,y));
                        } 
                    }
                
                }
            }
        
            return true;
    }
    
}