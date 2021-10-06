package study_2021_10;

import java.util.*;
class kakao인턴_2019_크레인인형뽑기게임 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int N = board[0].length;
        int M = board.length;
        List<Integer>[] list = new LinkedList[N];
        Stack<Integer> q = new Stack<>();
        for(int i=0;i<N;i++)
            list[i] = new LinkedList<>();
        for(int j=0;j<N;j++){
            for(int i=0;i<M;i++){
                if(board[i][j]==0)
                    continue;
                list[j].add(board[i][j]);
            }
        }
        for(int i=0;i<moves.length;i++){
            int idx = moves[i]-1;
            if(list[idx].size() !=0){
                if(!q.isEmpty()){
                    int up = q.peek();
                    if(up == list[idx].get(0)){
                        q.pop();
                        answer+=2;
                    }else{
                        q.add(list[idx].get(0));
                    }
                }else{
                    q.add(list[idx].get(0));
                }
                list[idx].remove(0);
            }
        }
        
        return answer;
    }
}