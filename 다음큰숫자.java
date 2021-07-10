class Solution {
    public int solution(int n) {
        int answer = 0;
        answer = n+1;
        int cnt = 0; // 이진변환 갯수
        String tmp = Integer.toBinaryString(answer); // 이진변환

        String binary = Integer.toBinaryString(n);
        char[] arr = binary.toCharArray();

        for(int i=0;i<arr.length;i++){
            if(arr[i]=='1') cnt++; // 갯수 계산
        }

        while(true){
            // 1의 갯수가 같으면 break; 
            int nsize = 0;
            String b = Integer.toBinaryString(answer);
            char[] arr1 = b.toCharArray(); 
            for(int i=0;i<arr1.length;i++){
                if(arr1[i]=='1') nsize++;
            }

            if(cnt==nsize) break;

            answer++;

        }

        return answer;
    }
}