import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int arr[] = new int[2];
        int wid, height = 0; 
        
        for(int i=1;i<=yellow;i++){
            if(yellow%i == 0){
                wid = (yellow/i)+2;
                height = i + 2;
                if((wid * height) - yellow == brown){
                    arr[0] = wid;
                    arr[1] = height;
                    break;
                }
            }
        }
        
        return arr;
    }
}