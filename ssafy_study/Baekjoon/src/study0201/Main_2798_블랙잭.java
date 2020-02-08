package study0201;

import java.util.Scanner;

public class Main_2798_∫Ì∑¢¿Ë {

	static int N, M, clo, res;
	static int[] card;
	static int[] sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		clo = Integer.MAX_VALUE;
		res = 0;
		card = new int[N];
		sel = new int[3];
		for (int i = 0; i < N; i++) {
			card[i] = sc.nextInt();
		}
		Combi(0,0);
		System.out.println(res);

	}

	public static void Combi(int start, int cnt) {
		if (cnt == 3) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += card[sel[i]];
			}
			if (M >= sum && clo > M - sum) {
				clo = M - sum;
				res = sum;
			}
			return;
		}
		for (int i = start; i < N; i++) {
			sel[cnt] = i;
			Combi(i + 1, cnt + 1);
		}
	}

}
