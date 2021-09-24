package study_2021_09;

class kakao인턴_2021_로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int lower = 0, upper = 0;
        int zero = 0;
        int win_cnt = 0;
        boolean[] isWin = new boolean[46];
        for(int i=0;i<6;i++){
            isWin[win_nums[i]] = true;
        }
        
        for(int i=0;i<6;i++){
            int lot = lottos[i];
            if(lot==0)
                zero++;
            else if(isWin[lot])
                win_cnt++;
        }
        lower = win_cnt;
        upper = win_cnt+zero;
        answer[0] = checkLank(upper);
        answer[1] = checkLank(lower);
        return answer;
    }
    
    static int checkLank(int cnt){
        if(cnt >= 2)
            return 7-cnt;
        else
            return 6;
    }
}