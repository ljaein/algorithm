package study0304;

import java.util.Scanner;

public class Main_15649_N과M1 {

	static int N, M;
	static int[] sel;
	static boolean[] flag;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sel = new int[M];
		flag = new boolean[N];
		Perm(0,0);
		System.out.println(sb.toString());
	}

	static void Perm(int flag, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++)
				sb.append(sel[i]).append(" ");
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if ((flag & (1 << i)) == 0) {
				sel[cnt] = i + 1;
				Perm(flag | (1 << i), cnt + 1);
			}
		}
	}

	static void Perm(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++)
				sb.append(sel[i]).append(" ");
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!flag[i]) {
				flag[i] = true;
				sel[cnt] = i + 1;
				Perm(cnt + 1);
				flag[i] = false;
			}
		}
	}

}
