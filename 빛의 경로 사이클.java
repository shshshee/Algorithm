import java.util.*;
class Solution {
    static boolean[][][] visited;
    static int r;
    static int c;
    static int[] dr = { -1, 0, 1, 0 }, dc = { 0, -1, 0, 1 }; // 하, 좌, 상, 우 
    public int[] solution(String[] grid) {
        int[] answer = {};

        ArrayList<Integer> list = new ArrayList<>();
        r = grid.length;
        c = grid[0].length();
        visited = new boolean[r][c][4]; // 상,하,좌,우 순서

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                for(int d=0;d<4;d++){
                    if(!visited[i][j][d]){
                        int len = getRoute(grid,i,j,d); 
                        list.add(len);   
                    }
                }
            }
        }

        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }

    // 사이클 갯수 구하기 (d:나가는 방향, i,j:현재 좌표)
    static int getRoute(String[] grid,int i,int j,int d){
        int result = 0;

        while(true){
            // 이미 방문한 곳이라면
            if(visited[i][j][d]) break;

            visited[i][j][d] = true; // 방문 체크 
            result++; // 사이클 길이 증가

            //방향 전환 
            if(grid[i].charAt(j)=='L'){
                //현재 들어온 방향 기준 -> 왼 (하->우, 상-좌 , 좌-하, 우-상)
                if(d==0){
                    d=3;
                }else{
                    d-=1;
                }
            }else if(grid[i].charAt(j)=='R'){
                //오 (하-좌, 상-우, 우-하, 좌-상)
                if(d==3){
                    d=0;
                }else{
                    d+=1;
                }
            }

            i = (i+dr[d]+r)%r;
            j = (j+dc[d]+c)%c;
        }

        return result;
    }
}
