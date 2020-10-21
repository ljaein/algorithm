package study0201;

import java.util.Scanner;

public class Main_8320_직사각형을만드는방법 {

	static int N, cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i=1;i<=N;i++){
			for(int j=i;j<=N;j++){
				if(i * j <= N)
					cnt++;
			}
		}
		System.out.println(cnt);
	}

}