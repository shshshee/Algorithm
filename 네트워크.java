class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean visited[] = new boolean[n+1]; // 방문 check
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(computers,visited,i);
                answer++; // 네트워크 갯수 증가
            }
        }


        return answer;
    }

    //dfs
    public void dfs(int[][] computers, boolean[] visited, int n){
        visited[n]=true; 
        for(int i=0;i<computers.length;i++){
            if(computers[n][i]==1&&!visited[i]){
                dfs(computers,visited,i);
            }
        }

    }
}