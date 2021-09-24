package study_2021_09;

import java.util.*;
class kakao인턴_2021_거리두기확인하기 {
    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0};
    
    static boolean[][] visit;
    static Queue<Point> q;
    static char[][] map;
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int T =0;T<places.length;T++){
            int res = 1;
            map = new char[5][5];
            List<Point> plist = new LinkedList<>();
            for(int i=0;i<5;i++){
                map[i] = places[T][i].toCharArray();
                for(int j=0;j<5;j++){
                    if(map[i][j]=='P'){
                        plist.add(new Point(i,j,0));
                    }
                }
            }
            for(Point p : plist){
                q = new LinkedList<>();
                visit = new boolean[5][5];
                if(dfs(p)==0){
                    res = 0;
                    break;
                }
            }
            System.out.println(res);
            answer[T] = res;
        }
        return answer;
    }
    
    static int dfs(Point p){
        q.add(p);
        visit[p.y][p.x] = true;
        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int d=0;d<4;d++){
                int ny = cur.y+dy[d];
                int nx = cur.x+dx[d];
                if(ny<0||nx<0||ny>=5||nx>=5||map[ny][nx]=='X'||visit[ny][nx])
                    continue;
                if(cur.cnt>=2)
                    continue;
                if(map[ny][nx]=='P'){
                    return 0;
                }
                q.add(new Point(ny,nx,cur.cnt+1));
                visit[ny][nx] = true;
                
            }
        }
        return 1;
    }
    static class Point{
        int y, x, cnt;
        public Point(int y, int x, int cnt){
            this.y =y;
            this.x=x;
            this.cnt=cnt;
        }
    }
}