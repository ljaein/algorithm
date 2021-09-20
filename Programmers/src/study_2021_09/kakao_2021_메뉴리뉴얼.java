package study_2021_09;

import java.util.*;
class kakao_2021_메뉴리뉴얼 {
    static HashMap<String, Integer> map;
    static PriorityQueue<Point> pq;
    static int cnt;
    public String[] solution(String[] orders, int[] course) {
        String[] answer ;
        List<String> list = new LinkedList<>();
        for(int i=0;i<course.length;i++){
            map = new HashMap<>();
            pq = new PriorityQueue<>();
            for(int j=0;j<orders.length;j++){
                if(orders[j].length()<course[i])
                    continue;
                int[] sel = new int[course[i]];
                char[] c =orders[j].toCharArray();
                Arrays.sort(c);
                Combi(0,0,c,sel);                
            }
            for(String key : map.keySet()){
                
                if(map.get(key)>=2){
                    pq.add(new Point(key,map.get(key)));
                    // System.out.println(key+" "+map.get(key));
                }
            }
            int psize = pq.size();
            if(psize!=0){
                Point now = pq.poll();
                list.add(now.s);
                cnt++;
                while(pq.size()!=0){
                    Point next = pq.poll();
                    if(now.n == next.n){
                        list.add(next.s);
                        cnt++;
                        now = next;
                    }
                
                }
            }
            
           
        }
        answer = new String[cnt];
             for(int i=0;i<cnt;i++){
                 answer[i] = list.get(i);
             }
        Arrays.sort(answer);
        return answer;
    }
    
    public static void Combi(int start, int cnt, char[] c, int[] sel){
        if(cnt == sel.length){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<sel.length;i++){
                sb.append(c[sel[i]]);
            }
            String skey = sb.toString();
            //System.out.println(skey);
            if(map.containsKey(skey)){
                map.put(skey, map.get(skey)+1);
            }else{
                map.put(skey,1);
            }
            return;   
        }
        for(int i=start;i<c.length;i++){
            sel[cnt] = i;
            Combi(i+1, cnt+1, c, sel);
        }
    }
    
    static class Point implements Comparable<Point>{
        String s;
        int n;
        public Point(String s, int n){
            this.s = s;
            this.n=n;
        }
        public int compareTo(Point p){
            return p.n-this.n;
        }
    }
}