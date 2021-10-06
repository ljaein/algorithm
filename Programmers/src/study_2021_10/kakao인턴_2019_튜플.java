package study_2021_10;

import java.util.*;
class kakao인턴_2019_튜플 {
    public int[] solution(String s) {
        int[] answer;
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Point> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='{'||c=='}')
                continue;
            else if(c==','){
                int num = Integer.parseInt(sb.toString());
                if(map.containsKey(num)){
                    map.put(num,map.get(num)+1);
                }else{
                    map.put(num,1);
                }
                sb.setLength(0);
            }else{
                sb.append(c+"");
            }
        }
        int num = Integer.parseInt(sb.toString());
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        for(int key : map.keySet()){
            pq.add(new Point(key, map.get(key)));
        }
        answer = new int[pq.size()];
        int idx = 0;
        while(!pq.isEmpty()){
            answer[idx] = pq.poll().num;
            idx++;
        }
        return answer;
    }
    
    static class Point implements Comparable<Point>{
        int num, cnt;
        public Point(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
        public int compareTo(Point p){
            return p.cnt-this.cnt;
        }
    }
}