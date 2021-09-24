package study_2021_09;

import java.util.*;
class kakao인턴_2021_표편집 {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        char[] names = new char[n];
        for(int i=0;i<n;i++)
            names[i] = 'O';
        int cur = k;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<cmd.length;i++){
            String cmds = cmd[i];
            if(cmds.charAt(0)=='D'){
                int down = Integer.parseInt(cmds.substring(2));
                int cnt = 0;
                while(cnt!=down){
                    cur++;
                    if(names[cur]=='X')
                        continue;
                    cnt++;
                }
            }else if(cmds.charAt(0)=='U'){
                int up = Integer.parseInt(cmds.substring(2));
                int cnt = 0;
                while(cnt!=up){
                    cur--;
                    if(names[cur]=='X')
                        continue;
                    cnt++;
                }
            }else if(cmds.charAt(0)=='C'){
                names[cur] = 'X';
                stack.add(cur);
                int d = 1 ;
                while(true){
                    if(cur == n-1){
                        d = -1;
                    }
                    cur += d;
                    if(names[cur]=='X')
                        continue;
                    else
                        break;
                }
            }else if(cmds.charAt(0) =='Z'){
                int del = stack.pop();
                names[del]='O';
            }
        }
        answer = String.valueOf(names);
        return answer;
    }
}

class kakao인턴_2021_표편집2 {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        Stack<Node> stack = new Stack<>();
        Node[] list = new Node[n];
        for(int i=0;i<n;i++){
            list[i]=new Node();
        }
        for(int i=1;i<n;i++){
            list[i-1].next = list[i];
            list[i].prev = list[i-1];
        }
        
        Node cur = list[k];
        for(int i=0;i<cmd.length;i++){
            char order = cmd[i].charAt(0);
            if(order == 'U'){
                int cnt = Integer.parseInt(cmd[i].substring(2));
                for(int j=0;j<cnt;j++){
                    cur = cur.prev;
                }
            }else if(order =='D'){
                int cnt = Integer.parseInt(cmd[i].substring(2));
                for(int j=0;j<cnt;j++){
                    cur = cur.next;
                }
            }else if(order == 'C'){
                cur.is = false;
                stack.add(cur);
                Node up = cur.prev;
                Node down = cur.next;
                if(up != null){
                    up.next = down;
                }
                if(down != null){
                    down.prev = up;
                    cur = down;
                }else{
                    cur = up;
                }
            }else if(order =='Z'){
                Node getDel = stack.pop();
                getDel.is = true;
                Node up = getDel.prev;
                Node down = getDel.next;
                if(up != null){
                    up.next = getDel;
                }
                if(down != null){
                    down.prev = getDel;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            if(list[i].is)
                sb.append("O");
            else
                sb.append("X");
        }
        answer = sb.toString();
        return answer;
    }
    
    static class Node{
        Node prev;
        Node next;
        boolean is = true;
    }
}