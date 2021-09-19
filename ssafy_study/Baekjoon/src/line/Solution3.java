package line;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution3 {

	public static void main(String[] args) {
		String[][] dt = { { "doc1", "t1", "t2", "t3" }, { "doc2", "t0", "t2", "t3" }, { "doc3", "t1", "t2", "t7" },
				{ "doc4", "t1", "t2", "t3" }, { "doc5", "t6", "t100", "t8" } };
		String[] t = { "t1", "t2", "t3" };
		solution(dt, t);
	}

	static String[] solution(String[][] dataSource, String[] tags) {
		String[] answer;
		LinkedList<Paper> cnt = new LinkedList<>();
		for (int i = 0; i < dataSource.length; i++) {
			cnt.add(new Paper(dataSource[i][0], 0));
			for (int j = 1; j < dataSource[i].length; j++) {
				for (int k = 0; k < tags.length; k++) {
					if (dataSource[i][j].equals(tags[k])) {
						cnt.get(i).c++;
					}
				}
			}
		}
		cnt.sort(new Comparator<Paper>() {

			@Override
			public int compare(Paper o1, Paper o2) {
				if (o1.c < o2.c)
					return 1;
				else if (o1.c == o2.c) {
					return o1.name.compareTo(o2.name);
				} else
					return -1;
			}

		});
		int cc = 0;

		for (int i = 0; i < cnt.size(); i++) {
			if (cc == 10)
				break;
			if (cnt.get(i).c >= 1) {
				cc++;
			}
		}
		answer = new String[cc];
		for (int i = 0; i < cc; i++)
			answer[cc] = cnt.get(i).name;

		return answer;
	}

	static class Paper {
		String name;
		int c;

		public Paper() {

		}

		public Paper(String name, int c) {
			super();
			this.name = name;
			this.c = c;
		}

	}

}
