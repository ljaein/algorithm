package study_2021_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916_최소비용구하기 {
	static int N, M, s, e;
	static List<Point>[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		list = new LinkedList[N];
		for(int i=0;i<N;i++){
			list[i] = new LinkedList<>();
		}
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[y-1].add(new Point(x-1,w));
		}
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken())-1;
		e = Integer.parseInt(st.nextToken())-1;
		boolean[] visit = new boolean[N];
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(s,0));
		dist[s] = 0;
		while(!pq.isEmpty()){
			Point cur = pq.poll();
			if(visit[cur.n])
				continue;
			visit[cur.n] = true;
			for(Point p : list[cur.n]){
				if(dist[cur.n]+p.c<dist[p.n]){
					dist[p.n] = dist[cur.n]+p.c;
					pq.add(new Point(p.n,dist[p.n]));
				}
			}
		}
		System.out.println(dist[e]);
		
	}
	static class Point implements Comparable<Point>{
		int n, c;
		public Point(int n, int c){
			this.n=n;
			this.c=c;
		}
		
		public int compareTo(Point p){
			return this.c-p.c;
		}
	}

}
