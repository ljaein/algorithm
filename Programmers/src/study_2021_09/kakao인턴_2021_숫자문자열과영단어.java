package study_2021_09;

import java.util.*;
class kakao인턴_2021_숫자문자열과영단어 {
    public int solution(String s) {
        int answer = 0;
        String[] word = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        String[] num = {"0","1","2","3","4","5","6","7","8","9"};
        for(int i=0;i<10;i++){
            s = s.replaceAll(word[i],num[i]);
        }
        answer = Integer.parseInt(s);
        return answer;
    }
}