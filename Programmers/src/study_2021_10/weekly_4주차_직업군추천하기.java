package study_2021_10;

import java.util.*;
class weekly_4주차_직업군추천하기 {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        String[] job = {"SI","CONTENTS","HARDWARE","PORTAL","GAME"};
        int[] score = new int[5];
        HashMap<String,Integer>[] map = new HashMap[5];
        for(int i=0;i<5;i++)
            map[i] = new HashMap<>();
        for(int i=0;i<5;i++){
            String[] str = table[i].split(" ");
            for(int j=1;j<=5;j++){
                map[i].put(str[j],6-j);
            }
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<languages.length;j++){
                String lang = languages[j];
                if(map[i].containsKey(lang)){
                    score[i] += map[i].get(lang) * preference[j];
                }
            }
        }
        PriorityQueue<Info> pq = new PriorityQueue<>();
        for(int i=0;i<score.length;i++){
            pq.add(new Info(score[i],job[i]));
        }
        answer = pq.poll().job;
        return answer;
    }
    
    static class Info implements Comparable<Info>{
        int score;
        String job;
        public Info(int score, String job){
            this.score = score;
            this.job = job;
        }
        public int compareTo(Info i){
            if(this.score < i.score){
                return 1;
            }else if(this.score == i.score){
                if(this.job.compareTo(i.job)>0)
                    return 1;
                else
                    return -1;
            }else{
                return -1;
            }
        }
    }
}