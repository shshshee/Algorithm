import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        //System.out.println(board.length);
        Stack<Integer> s = new Stack<>();
        int num = 0;
        for(int i=0;i<moves.length;i++){
            int x = moves[i];
            for(int j=0;j<board.length;j++){
                if(board[j][x-1] > 0){
                    if(num == board[j][x-1]){
                        System.out.print(num);
                        System.out.print(board[j][x-1]);
                        s.pop();
                        if(!s.isEmpty()){
                            num = s.peek();
                        }else{
                            num = 0;   
                        }
                        answer+=2;
                    }else{
                        s.push(board[j][x-1]);
                        num = board[j][x-1];
                    }
                    board[j][x-1]=0;
                    break;
                }
            }
        }
        
        return answer;
    }
}