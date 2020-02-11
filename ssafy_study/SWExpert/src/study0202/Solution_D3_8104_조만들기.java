package study0202;

import java.util.Scanner;

public class Solution_D3_8104_조만들기 {

	static int T, N, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt(); // 한 조의 인원
			K = sc.nextInt(); // 조 개수
			int[] grade = new int[K];
			int num = 1;

			boolean rev = false;
			for (int i = 0; i < N; i++) {
				if (!rev) {
					for (int j = 0; j < K; j++) {
						grade[j] += num;
						num++;
						rev = true;

					}
				} else if (rev) {
					for (int j = K - 1; j >= 0; j--) {
						grade[j] += num;
						num++;
						rev = false;
					}
				}
			}
			System.out.print("#" + t + " ");
			for (int i : grade)
				System.out.print(i + " ");
			System.out.println();
		}
	}

}
