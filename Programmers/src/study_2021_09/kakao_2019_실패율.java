package study_2021_09;

import java.util.*;
class kakao_2019_실패율 {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int len = stages.length;
        int[] sum = new int[N+1];
        int[] cnt = new int[N+1];
        for(int i=0;i<len;i++){
            cnt[stages[i]-1]++;
        }
        sum[N] = cnt[N];
        for(int i=N-1;i>=0;i--){
            sum[i] = cnt[i]+sum[i+1];
        }
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            if(sum[i] == 0){
                pq.add(new Point(i+1, 0));
            }else
                pq.add(new Point(i+1, (double)cnt[i]/sum[i]));
        }
        int idx = 0;
        while(!pq.isEmpty()){
            answer[idx++] = pq.poll().stage;
        }
        return answer;
    }
    
    static class Point implements Comparable<Point>{
        int stage;
        double fail;
        public Point(int stage, double fail){
            this.stage = stage;
            this.fail = fail;
        }
        public int compareTo(Point p){
            if(this.fail<p.fail){
                return 1;
            }else if(this.fail == p.fail){
                return this.stage - p.stage;
            }else{
                return -1;
            }
        }
    }
}