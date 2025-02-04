package study0601;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1120_문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		String b = st.nextToken();
		int len = b.length() - a.length();
		int idx = 0;
		int min = Integer.MAX_VALUE;
		for (int j = 0; j <= len; j++) {
			int cnt = 0;
			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) != b.charAt(i + idx))
					cnt++;
			}
			min = Math.min(min, cnt);
			idx++;
		}
		System.out.println(min);
	}
}
