import java.util.*;
class Solution {
    // 정렬기준 1. 재생시간 긴 음악제목 반환 , 2. 같을 경우 먼저 입력된 음악 제목
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxTime = 0;
        m = replaceSharp(m); //멜로디 문자열 치환 

        for(int i=0;i<musicinfos.length;i++){
            String str = musicinfos[i];
            String[] info = str.split(",");
            int min = getTime(info[0],info[1]); // 시간 계산
            String music = replaceSharp(info[3]);
            if(findmusic(m,min,music)){
                // 조건에 일치하는 음악일 경우 
                if(min>maxTime){
                    maxTime = min;
                    answer = info[2];
                }
            }
        }

        return answer;
    }

    // 시간 계산
    static int getTime(String s, String e){

        String[] start = s.split(":");
        String[] end = e.split(":"); 

        //시간계산 
        int hour = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
        int min = Integer.parseInt(end[1]) - Integer.parseInt(start[1]) + (hour*60);

        return min;
    }

    // 음악 찾기
    static boolean findmusic(String m,int min, String music){
        boolean result = false;

        // 문자 다 이어서 -> m 포함되는지 확인 
        music = makemusic(music,min);

        if(music.contains(m)){
            //포함하는경우 true
            result = true;
        }

        return result;

    }

    //악보 만들기
    static String makemusic(String music,int min){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<min;i++){
            sb.append(music.charAt(i%music.length()));
        }
        //만들어진 악보 출력
        System.out.println(sb.toString());

        return sb.toString();
    }

    //문자열 치환
    static String replaceSharp(String m){
        m = m.replaceAll("C#","c");
        m = m.replaceAll("D#","d");
        m = m.replaceAll("F#","f");
        m = m.replaceAll("G#","g");
        m = m.replaceAll("A#","a");
        return m;
    }
}