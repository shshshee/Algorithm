import java.util.*;
class Solution {
    static char[] sign = {'*','+','-'};
    static long max = Long.MIN_VALUE;
    static boolean[] visited = new boolean[3];
    static char[] tmp = new char[3];
    static ArrayList<Long> num = new ArrayList<>(); // 숫자 저장
    static ArrayList<Character> operator = new ArrayList<>(); //연산자 저장   
    
    public long solution(String expression) {
        
        long answer = 0;
        String n ="";
        //문자열 분리 후 각각 ArrayList에 넣기
        for(int i=0;i<expression.length();i++){
            char c = expression.charAt(i);
            if(Character.isDigit(c)){
                //숫자일 경우 
                n+=c;
            }else{
                num.add(Long.parseLong(n));
                operator.add(c);
                n="";
            }
            
        }
        
        num.add(Long.parseLong(n));
        
        dfs(0);
        
        return max;
    }
    
    static void dfs(int cnt){
        if(cnt==3){
            max = Math.max(max,getResult());
            return;
        }
        
        for(int i=0;i<3;i++){
            if(!visited[i]){
                visited[i]=true;
                tmp[cnt]=sign[i];
                dfs(cnt+1);
                visited[i]=false;
            }
        }
    }
    
    static long getResult(){
        ArrayList<Long> numCopy = new ArrayList<>(num);
        ArrayList<Character> opCopy = new ArrayList<>(operator);

        for(int i=0;i<tmp.length;i++){
            // 우선순위 연산자부터 꺼내 계산 
            char c = tmp[i];
            for(int j=0;j<opCopy.size();j++){
                if(c==opCopy.get(j)){ //현재 우선순위에 해당하는 연산자와 동일하다면 계산하기
                    Long a = numCopy.get(j);
                    Long b = numCopy.get(j+1);
                    // 계산 후 해당 인덱스의 값을 제거 및 계산결과 추가   
                    numCopy.remove(j+1);
                    numCopy.remove(j);
                    opCopy.remove(j);
                    numCopy.add(j,calculate(a,b,c)); // 계산결과 다시 리스트에 넣기
                    j--;
                }
            }
        }
        return Math.abs(numCopy.get(0));
    }
    
    //계산
    static long calculate(long a,long b,char c) {
        long result = 0;
        switch(c){
            case '+':
                result=a+b;
                break;
            case '-':
                result=a-b;
                break;
            case '*':
                result=a*b;
                break;
        }
        
        return result;
    }
}