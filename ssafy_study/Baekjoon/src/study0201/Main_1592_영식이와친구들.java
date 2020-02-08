package study0201;

import java.util.Scanner;

public class Main_1592_영식이와친구들 {

	static int N, M, L;
	static int[] ball;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();
		ball = new int[N];
		int cur = 0;
		ball[cur]++; //1번이 공을 받음
		while(!isFin()){
			if(ball[cur]%2==1){
				cur +=L;
				if(cur>=N)
					cur = cur-N;
			}else{
				cur-=L;
				if(cur<0)
					cur = N+cur;
			}
			ball[cur]++;
			cnt++;
		}
		System.out.println(cnt);
	}
	public static boolean isFin(){
		for(int i=0;i<N;i++){
			if(ball[i]==M)
				return true;
		}
		return false;
	}

}
