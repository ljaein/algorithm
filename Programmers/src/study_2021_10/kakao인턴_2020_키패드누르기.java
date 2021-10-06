package study_2021_10;

import java.util.*;
class kakao인턴_2020_키패드누르기 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        Point left = new Point(3,0);
        Point right = new Point(3,2);
        for(int i=0;i<numbers.length;i++){
            int num = numbers[i];
            if(num==1 || num==4||num==7){
                sb.append("L");
                calc(left,num);
            }else if(num==3 || num==6||num==9){
                sb.append("R");
                calc(right,num);
            }else{
                int curY = 0, curX = 0;
                if(num == 0){
                    curY = 3;
                    curX = 1;
                }else{
                    curY = (num-1)/3;
                    curX = (num-1)%3;
                }
                
                int lLen = Math.abs(curY-left.y) + Math.abs(curX-left.x);
                int rLen = Math.abs(curY-right.y) + Math.abs(curX-right.x);
                if(lLen<rLen){
                    sb.append("L");
                    calc(left,num);
                }else if(lLen>rLen){
                    sb.append("R");
                    calc(right,num);
                }else{
                    if(hand.equals("right")){
                        sb.append("R");
                        calc(right,num);
                    }else{
                        sb.append("L");
                        calc(left,num);
                    }
                }
            }
        }
        answer = sb.toString();
        return answer;
    }
    
    static void calc(Point p, int num){
        if(num == 0){
            p.y = 3;
            p.x = 1;
        }else{
            p.y = (num-1)/3;
            p.x = (num-1)%3;
        }
    }
    static class Point{
        int y, x;
        public Point(int y, int x){
            this.y=y;
            this.x=x;
            
        }
    }
}