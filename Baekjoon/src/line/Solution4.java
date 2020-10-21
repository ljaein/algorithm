package line;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] road = sc.next().toCharArray();
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < road.length; i++)
			if (road[i] == '0') {
				list.add(i);
			}
		int n = 3;
		int zero = n;
		int answer = 0, cnt = 0;
		for (int i = 0; i < road.length; i++) {
			if (road[i] == '1') {
				cnt++;
			} else if (road[i] == '0') {
				if (n == 0) {
					cnt = 0;
				} else {
					if (zero == 0) {
						cnt = cnt - list.poll();
					} else {
						cnt++;
						zero--;
					}
				}
			}
			answer = Math.max(cnt, answer);
		}
		System.out.println(answer);
	}

}
