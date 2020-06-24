package study0201;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class test {

	public static void main(String[] args) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(1));
		q.add(new Point(3));
		q.add(new Point(2));
		while(!q.isEmpty()){
			System.out.println(q.poll().a);
		}
	}

	static class Point implements Comparable<Point>{
		int a;

		public Point(int a) {
			super();
			this.a = a;
		}

		@Override
		public int compareTo(Point o) {
			return this.a-o.a;
		}
		
	}
}
