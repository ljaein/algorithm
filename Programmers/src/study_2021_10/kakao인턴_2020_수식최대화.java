package study_2021_10;

import java.util.*;

class kakao인턴_2020_수식최대화 {
    static String[] sel;
    static boolean[] visit;
    static long answer;
    static String[] operator = {"*","+","-"};
    static List<Long> num = new LinkedList<>();
    static List<String> oper = new LinkedList<>();
    public long solution(String expression) {
        answer = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<expression.length();i++){
            char c = expression.charAt(i);
            if(c=='*' || c=='+' || c=='-'){
                oper.add(c+"");
                num.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
            }else{
                sb.append(c);
            }
        }
        num.add(Long.parseLong(sb.toString()));
        sel = new String[3];
        visit = new boolean[3];
        Perm(0);
        return answer;
    }
    
    static void Perm(int cnt){
        if(cnt==3){
            solve();
            return;
        }
        for(int i=0;i<3;i++){
            if(!visit[i]){
                sel[cnt] = operator[i];
                visit[i] = true;
                Perm(cnt+1);
                visit[i] = false;
            }
        }
    }
    
    static void solve(){
        List<Long> curNum = new LinkedList<>();
        curNum.addAll(num);
        List<String> curOper = new LinkedList<>();
        curOper.addAll(oper);
        for(int i=0;i<3;i++){
            String order = sel[i];
            for(int j=0;j<curOper.size();j++){
                String noper = curOper.get(j);
                if(noper.equals(order)){
                    long num1 = curNum.get(j);
                    long num2 = curNum.get(j+1);
                    long res = calc(num1,num2,noper);
                    
                    curNum.remove(j+1);
                    curNum.remove(j);
                    curOper.remove(j);
                    curNum.add(j,res);
                    j--;
                }
                
            }
        }
        answer = Math.max(answer,  Math.abs(curNum.get(0)));
    }
    static long calc(long num1, long num2, String o) {
		long res = 0;
        if(o.equals("+"))
			res = num1 + num2;
		else if(o.equals("-"))
			res = num1 - num2;
		else
			res = num1 * num2;
		return res;
	}
}