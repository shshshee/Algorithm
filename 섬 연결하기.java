import java.util.*;
class Solution {
    static int[] parents; //부모노드 저장할 배열 선언 
    public int solution(int n, int[][] costs) {
        int answer = 0;

        Arrays.sort(costs,(int[] o1,int[] o2)->o1[2]-o2[2]); // 가중치 기준으로 정렬 : 오름차순 

        parents = new int[n];
        for(int i=0;i<n;i++){
            parents[i] = i; 
        }

        for(int[] cost : costs){
            // 각 부모노드 찾기 
            int p1 = findParent(cost[0]); 
            int p2 = findParent(cost[1]);
            if(p1!=p2){ // 부모노드가 같지 않을 경우 연결하기 
                parents[p2] = p1;  
                answer += cost[2];
            }
        }


        return answer;
    }

    //부모 찾기
    private int findParent(int node){
        if(parents[node]==node) return node;
        return parents[node] = findParent(parents[node]);
    }
}