package study_2021_09;

import java.util.*;
class kakao_2021_신규아이디추천 {
    public String solution(String new_id) {
        String answer = "";
        //1단계
        new_id = new_id.toLowerCase();
        //2단계
        StringBuilder sb = new StringBuilder();
        char[] c_step2 = new_id.toCharArray();
        for(char c : c_step2){
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                
                sb.append(c);
            }
        }
        new_id = sb.toString();
        //3단계
        new_id = new_id.replace("..",".");
        while (new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }
        //4단계
        if(new_id.startsWith("."))
            new_id = new_id.substring(1,new_id.length());
        if(new_id.endsWith("."))
            new_id = new_id.substring(0,new_id.length()-1);
        //5단계
        if(new_id.equals(""))
            new_id = "a";
        //6단계
        if(new_id.length() >=16){
            new_id = new_id.substring(0,15);
            if(new_id.endsWith("."))
                new_id = new_id.substring(0,14);
        }
        //7단계
        if(new_id.length()<=2){
            StringBuilder sb2 = new StringBuilder(new_id);
            char lastc = new_id.charAt(new_id.length()-1);
            while(sb2.length()!=3){
                sb2.append(lastc);
            }
            new_id = sb2.toString();
        }
            
        answer = new_id;
        return answer;
    }
}