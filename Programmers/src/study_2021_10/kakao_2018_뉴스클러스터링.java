package study_2021_10;

import java.util.*;
class kakao_2018_뉴스클러스터링 {
    public int solution(String str1, String str2) {
        int answer = 0;
        double res = 0;
        double min = 0;
        double max = 0;
        HashMap<String,Integer> map1 = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();
        
        for(int i=0;i<str1.length()-1;i++){
            char a = str1.charAt(i);
            char b = str1.charAt(i+1);
            if(!check(a) || !check(b)){
                continue;
            }
            String s = str1.substring(i,i+2);
            s = s.toUpperCase();
            if(map1.containsKey(s))
                map1.put(s,map1.get(s)+1);
            else{
                map1.put(s,1);
            }
        }
        
        for(int i=0;i<str2.length()-1;i++){
            char a = str2.charAt(i);
            char b = str2.charAt(i+1);
            if(!check(a) || !check(b)){
                continue;
            }
            String s = str2.substring(i,i+2);
            s = s.toUpperCase();
            if(map2.containsKey(s))
                map2.put(s,map2.get(s)+1);
            else{
                map2.put(s,1);
            }
        }
        
        for(String key : map1.keySet()){
            if(map2.containsKey(key)){
                if(map1.get(key)==map2.get(key)){
                    min +=map1.get(key);
                    max +=map1.get(key);
                }else{
                    min += Math.min(map1.get(key),map2.get(key));
                    max += Math.max(map1.get(key),map2.get(key));
                }
                map2.remove(key);
            }else{
                max += map1.get(key);
            }
        }
        System.out.println();
        for(String key : map2.keySet()){
            max += map2.get(key);
        }
        res = ((min/max) * 65536);
        answer = (int)res;
        if(min==0 && max ==0)
            answer = 65536;
        return answer;
    }
    
    static boolean check(char c){
        if((c>='a'&&c<='z')||(c>='A'&&c<='Z'))
            return true;
        else
            return false;
    }
}