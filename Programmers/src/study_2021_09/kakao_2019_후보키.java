package study_2021_09;

import java.util.*;
class kakao_2019_후보키 {
    static int row, tuple, answer;
    static String[][] map;
    static List<Integer> list = new LinkedList<>();
    public int solution(String[][] relation) {
        answer = 0;
        map = relation;
        row = relation.length;
        tuple = relation[0].length;
        for(int i=1;i<=tuple;i++){
            int[] sel = new int[i];
            
            Combi(0,i,0,sel);
        }
        return answer;
    }
    
    public void Combi(int start, int M, int cnt, int[] sel){
        if(cnt==M){
            int bit = 0;
            for(int i=0;i<M;i++){
                bit = bit | (1<<sel[i]);
            }
            boolean flag = false;
            for(int getBit : list){
                if((getBit & bit) == getBit){ //안돼
                    flag = true;
                    break;
                }
            }
            if(!flag)
                check(sel);
            return;
        }
        for(int i=start;i<tuple;i++){
            sel[cnt] = i;
            Combi(i+1,M,cnt+1,sel);
        }
    }
    
    public void check(int[] sel){
        HashSet<String> hs = new HashSet<>();
        for(int i=0;i<row;i++){
            int ori = hs.size();
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<sel.length;j++){
                sb.append(map[i][sel[j]]);
            }
            hs.add(sb.toString());
            if(ori==hs.size()){
                return;
            }
        }
        int bit = 0;
        for(int i=0;i<sel.length;i++){
            bit = bit | (1<<sel[i]);
        }
        list.add(bit);
        answer++;
        
    }
}