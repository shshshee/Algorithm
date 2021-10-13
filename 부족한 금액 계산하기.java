class Solution {
    // 놀이기구를 n번 이용한다면 원래 이용료의 N배를 받기로 함
    public long solution(int price, int money, int count) {
        long answer = -1;

        long total = 0;
        for(int i=1;i<=count;i++){
            total += price * i;
        }

        answer = total - money;
        if(answer<0) answer = 0;

        return answer;
    }
}