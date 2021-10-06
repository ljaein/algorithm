package study_2021_10;

import java.util.*;
class kakao_2018_프렌즈4블록 {
    static int cnt = 0;
    static char[][] map;
    static int N,M;
    static int[] dy = {0,1,1};
    static int[] dx = {1,1,0};
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        N=n;
        M=m;
        map = new char[M][N];
        for(int i=0;i<M;i++){
            map[i] = board[i].toCharArray();
        }
        while(true){
            boolean r = remove();
            if(r)
                push();
            else
                break;
        }
        answer = cnt;
        return answer;
    }
    
    static boolean remove(){
        boolean flag = false;
        Queue<Point> q = new LinkedList<>();
        for(int i=0;i<M-1;i++){
            for(int j=0;j<N-1;j++){
                char cur = map[i][j];
                if(cur=='0')
                    continue;
                boolean eq = true;
                for(int d=0;d<3;d++){
                    int ny = i+dy[d];
                    int nx = j+dx[d];
                    if(cur != map[ny][nx]){
                        eq = false;
                        break;
                    }
                }
                if(eq){
                    flag = true;
                    q.add(new Point(i,j));
                    // map[i][j] = '0';
                    for(int d=0;d<3;d++){
                        int ny = i+dy[d];
                        int nx = j+dx[d];
                        q.add(new Point(ny,nx));
                        // map[ny][nx] = '0';
                    }
                }
            }
        }
        while(!q.isEmpty()){
            Point cur = q.poll();
            if(map[cur.y][cur.x]!='0'){
                map[cur.y][cur.x] = '0';
                cnt++;
            }
        }
        return flag;
    }
    
    static void push(){
        char[][] temp = new char[M][N];
        for(int i=0;i<M;i++){
            System.arraycopy(map[i],0,temp[i],0,N);
        }
        for(int i=0;i<N;i++){
            int down = M-1;
            int up = 0;
            for(int j=M-1;j>=0;j--){
                if(temp[j][i]=='0'){
                    map[up++][i] = '0';
                }else{
                    map[down--][i] = temp[j][i];
                }
            }
        }
    }
    static class Point{
        int y, x;
        public Point(int y, int x){
            this.y=y;
            this.x=x;
        }
    }
}