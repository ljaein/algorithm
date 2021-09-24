package study_2021_09;

import java.util.*;
class kakao_2019_오픈채팅방 {
    public String[] solution(String[] record) {
        String[] answer;
        List<String[]> list = new LinkedList<>();
        // List<String> nameList =new LinkedList<>();
        // List<String> mentList =new LinkedList<>();
        
        HashMap<String,String> map = new HashMap<>();
        for(int i=0;i<record.length;i++){
            String[] rec = record[i].split(" ");
            if(rec[0].equals("Enter")){
                list.add(rec);
                // nameList.add(rec[1]);
                // mentList.add("님이 들어왔습니다.");
                map.put(rec[1],rec[2]);
            }else if(rec[0].equals("Leave")){
                list.add(rec);
                // nameList.add(rec[1]);
                // mentList.add("님이 나갔습니다.");
            }else{
                map.put(rec[1],rec[2]);
            }
        }
        StringBuffer sb = null;
        answer = new String[list.size()];
        int idx = 0;
        for(String[] s : list){
            if(s[0].equals("Enter")){
                answer[idx++] = map.get(s[1])+"님이 들어왔습니다.";
            }else{
                answer[idx++] = map.get(s[1])+"님이 나갔습니다.";
            }
        }
        // for(int i=0;i<answer.length;i++){
        //     sb = new StringBuffer();
        //     // String[] temp = list.get(i).split(",");
        //     // String uid = temp[0];
        //     // String word = temp[1];
        //     answer[i] = sb.append(map.get(nameList.get(i))).append(mentList.get(i)).toString();
        // }
        return answer;
    }
}