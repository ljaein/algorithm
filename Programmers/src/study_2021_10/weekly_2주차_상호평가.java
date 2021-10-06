package study_2021_10;

import java.util.*;
class weekly_2주차_상호평가 {
    public String solution(int[][] scores) {
        String answer = "";
        int N = scores.length;
        int[][] map = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[i][j] = scores[j][i];
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            int sum = 0;
            int me = map[i][i];
            int avg = 0;
            Arrays.sort(map[i]);
            for(int j=0;j<N;j++){
                sum += map[i][j];
            }
            if(map[i][0] == me && map[i][0]!=map[i][1]){ //유일한 최저점
                avg = (sum - me) / (N-1);
            }else if(map[i][N-1]==me && map[i][N-1]!=map[i][N-2]){ //유일한 최고점
                avg = (sum - me) / (N-1);
            }else{
                avg = sum / N;
            }
            if(avg>=90){
                sb.append("A");
            }else if(avg>=80 && avg<90){
                sb.append("B");
            }else if(avg>=70 && avg<80){
                sb.append("C");
            }else if(avg>=50 && avg<70){
                sb.append("D");
            }else {
                sb.append("F");
            }
        }
        answer = sb.toString();
        return answer;
    }
}