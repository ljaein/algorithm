package study_2021_10;

class weekly_1주차_부족한금액계산하기 {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long M = money;
        long P = price;
        long sum = 0;
        long C = count;
        for(int i=1;i<=C;i++){
            sum += (price*i);
        }
        if(sum<money)
            answer = 0;
        else
            answer=sum-money;
        
        return answer;
    }
}