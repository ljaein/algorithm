package kakao;

import java.util.HashMap;

public class Solution3 {

	public static void main(String[] args) {
		String[] gems = { "AA", "AB", "AC", "AA", "AC" };
		int[] ans = solution(gems);
		System.out.println(ans[0] + " " + ans[1]);
	}

	public static int[] solution(String[] gems) {
		int[] answer = {0, Integer.MAX_VALUE};
		int len = gems.length;
		HashMap<String, Integer> map = new HashMap<>();
		int idx = 0;
		while (true) {
			boolean flag = false;
			int cnt = 0;
			int start = 0;
			int end = Integer.MAX_VALUE;
			for (int i = 0; i < len; i++) {
				map.put(gems[i], 0);
			}
			for (int i = idx; i < len; i++) {
				if (map.get(gems[i]) == 0)
					cnt++;
				map.put(gems[i], map.get(gems[i]) + 1);
				if (cnt == map.size()) {
					flag = true;
					end = i;
					break;
				}
			}
			if (!flag)
				break;
			for (int i = idx; i <= end; i++) {
				map.put(gems[i], map.get(gems[i])-1);
				if (map.get(gems[i]) == 0) {
					start = i;
					break;
				}
			}
			if (answer[1] - answer[0] > end - start) {
				answer[0] = start + 1;
				answer[1] = end + 1;
			}
			idx = start + 1;
		}
		return answer;
	}
}
