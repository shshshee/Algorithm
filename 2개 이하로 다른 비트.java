class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int i=0;i<numbers.length;i++){
            long n = numbers[i];

            if(n%2==0){ //짝수
                answer[i]=n+1;
            }else{ //홀수일 때
                String a ="0"+Long.toBinaryString(n);
                StringBuilder result = new StringBuilder(a); // stringbuilder로 변경 
                int lastidx = result.lastIndexOf("0"); // 가장 마지막에 오는 0찾기 
                int nextidx = result.indexOf("1",lastidx);// 그 다음에 오는 1찾기 

                //0->1 , 1->0 변경 
                result.setCharAt(lastidx,'1');
                result.setCharAt(nextidx,'0');

                //string->long형 변경 
                answer[i]=Long.parseLong(result.toString(),2); // 2진수 -> 10진수 변환

            }

        }

        return answer;
    }
}
