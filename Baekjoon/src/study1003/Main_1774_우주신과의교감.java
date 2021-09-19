package study1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1774_우주신과의교감 {
	static int N, M;
	static double ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Point[] list = new Point[N];
		int[] ver = new int[N];
		PriorityQueue<Point> pq = new PriorityQueue<>();
		for (int i = 0; i <N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[i] = new Point(a,b);
			ver[i] = i;
		}
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int a = ver[Integer.parseInt(st.nextToken())-1];
			int b = ver[Integer.parseInt(st.nextToken())-1];
			if(a!=b){
				for (int j = 0; j < N; j++) {
					if (ver[j] == b)
						ver[j] = a;
				}
			}
		}
		for(int i =0;i<N;i++){
			for(int j=i+1;j<N;j++){
				double dist = calc(list[i],list[j]);
				pq.add(new Point(i,j,dist));
			}
		}
		int cnt = 0;
		while(!pq.isEmpty()){
			Point cur = pq.poll();
			int a = ver[cur.a];
			int b = ver[cur.b];
			if(a!=b){
				cnt++;
				ans += cur.d;
				for(int i=0;i<N;i++){
					if(ver[i]==b)
						ver[i]=a;
				}
			}
			if(cnt == N-1)
				break;
		}
		System.out.println(String.format("%.2f", ans));
	}
	
	static double calc(Point i, Point j){
		double d = Math.pow(i.a-j.a,2)+Math.pow(i.b-j.b,2);
		return Math.sqrt(d);
	}
	static class Point implements Comparable<Point>{
		int a, b;
		double d ;

		public Point(int a, int b, double d) {
			super();
			this.a = a;
			this.b = b;
			this.d = d;
		}
		public Point(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
		public int compareTo(Point p) {
			if(this.d>p.d){
				return 1;
			}else
				return -1;
		}
		
	}

}
