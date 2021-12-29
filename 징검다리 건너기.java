class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int right = 0;
        int left = 0; 
        int mid = 0;
        
        // 최대값으로 설정 
        for(int i=0;i<stones.length;i++){
            right = Math.max(stones[i],right);
        }
        
        while(right>=left){
            mid = (right+left)/2; // 중간값 지정 
            
            if(cross(mid,k,stones)){ // 건널 수 있는 경우 -> 늘리기 
                left = mid+1;
                answer = Math.max(answer,mid);
            }else{ // 건널 수 없는 경우 -> 줄이기 
                right = mid-1;
            }
            
        }
        
        return answer;
    }
    
    // 건널 수 있는지 체크 
    public static boolean cross(int mid,int k,int[] stones){
        int cnt = 0;
        
        // 연속 k개인지 체크 
        for(int i=0;i<stones.length;i++){
            
            if(stones[i]-mid<0){ //0보다 같거나 작을 경우 
                cnt++;
            }else{ // 다시 초기화 
                cnt = 0;
            }
            
            if(cnt>=k) return false;
        }
        
        return true;
    
    }
}