import java.util.*;
class Solution {
    static boolean[] visited;
    static int maxValue = 999;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        visited = new boolean[words.length];
        find(words,begin,target,0,0);
        
        if(maxValue==999) maxValue = 0;
        
        return maxValue;
    }
    
    // dfs 이용
    static void find(String[] words,String begin, String target, int idx , int cnt){
        if(begin.equals(target)){
            maxValue=Math.min(maxValue,cnt);
            return;
        }
               
        for(int i=0;i<words.length;i++){
            if(!visited[i]){
                String word = words[i];
                int diff=0;
                for(int j=0;j<word.length();j++){
                    if(word.charAt(j)!=begin.charAt(j)){
                        // 다른 경우 갯수 카운트 
                        diff++;
                    }
                }

                if(diff==1){ // 글자 하나만 다른 경우

                    visited[i] = true;
                    find(words,words[i],target,i,cnt+1);
                    visited[i] = false;

                }   
                
            }
            
        }
    }
}