package study0404;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D4_4050_재관이의대량할인 {

	static int T, N, sum, sale;
	static int[] price;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			sum = sale = 0;
			price = new int[N];
			for (int i = 0; i < N; i++){
				price[i] = sc.nextInt();
				sum += price[i];
			}
			Arrays.sort(price);
			for (int i = N - 3; i >= 0; i -= 3) {
				sale += price[i];
			}
			System.out.println("#"+t+" "+(sum-sale));
		}
	}

}
