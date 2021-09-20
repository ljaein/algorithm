package study_2021_09;

import java.util.*;
class kakao_2021_순위검색 {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        String[] lang = {"java","python","cpp","-"};
        String[] sw = {"backend","frontend","-"};
        String[] man = {"junior","senior","-"};
        String[] food = {"pizza","chicken","-"};
        HashMap<String, List<Integer>> map = new HashMap<>();
        for(int i = 0;i<4;i++){
           for(int j=0;j<3;j++){
               for(int k=0;k<3;k++){
                   for(int l=0;l<3;l++){
                       StringBuilder sb = new StringBuilder();
                       sb.append(lang[i]).append(sw[j]).append(man[k]).append(food[l]);
                       map.put(sb.toString(), new ArrayList<>());
                   }
               }
           }             
        }
        for(int i=0;i<info.length;i++){
            String[][] arr = new String[4][2];
            String[] info_arr = info[i].split(" ");
            for(int j=0;j<4;j++){
                arr[j][0] = info_arr[j];
                arr[j][1] = "-";
            }
            int sco = Integer.parseInt(info_arr[4]);
            for(int a=0;a<2;a++){
                for(int b=0;b<2;b++){
                    for(int c=0;c<2;c++){
                        for(int d=0;d<2;d++){
                            StringBuilder w = new StringBuilder();
                            String word = w.append(arr[0][a]).append(arr[1][b]).append(arr[2][c]).append(arr[3][d]).toString();
                            map.get(word).add(sco);
                            
                        }
                    }
                }
            }
        }
        List<String> list = new ArrayList<>(map.keySet());
        for(int i=0; i<list.size(); i++) {
        	List<Integer> scoreList = map.get(list.get(i));
        	Collections.sort(scoreList);
        }
        
        for(int i=0;i<query.length;i++){
            StringBuilder sb = new StringBuilder();
            String[] temp = query[i].split(" and ");
            String[] temp2 = temp[3].split(" ");
            String needs = sb.append(temp[0]).append(temp[1]).append(temp[2]).append(temp2[0]).toString();
            int cut = Integer.parseInt(temp2[1]);
            int cnt = search(map.get(needs),cut);
            answer[i] = cnt;
        }
        return answer;
    }
    
    static int search(List<Integer> list, int cut){
        int start = 0;
        int end = list.size()-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(list.get(mid)<cut)
                start = mid + 1;
            else{
                end = mid-1;
            }
        }
        return list.size()-start;
    }
    
}