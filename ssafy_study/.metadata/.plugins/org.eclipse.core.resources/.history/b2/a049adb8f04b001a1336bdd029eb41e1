package study0201;

import java.util.Scanner;

public class Main_2804_크로스워드만들기 {

	static String A, B;
	static int N, M;
	static char[] Ac, Bc;
	static char[][] res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.next();
		B = sc.next();
		Ac = A.toCharArray();
		Bc = B.toCharArray();
		N = Ac.length;
		M = Bc.length;
		res = new char[M][N];
		int samey = 0;
		int samex = 0;
		f:for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (Ac[i] == Bc[j]) {
					samex = i;
					samey = j;
					break f;
				}
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (i == samey) {
					res[i][j]=Ac[j];

				} else {
					if (j == samex) {
						res[i][j] = Bc[i];
					} else {
						res[i][j] = '.';
					}
				}
			}
		}
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				System.out.print(res[i][j]);
			}
			System.out.println();
		}

	}

}
