package study_2021_09;

import java.util.*;
class kakao_2021_합승택시요금 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j] = 20000000;
            }
            dist[i][i] = 0;
        }
        for(int i=0;i<fares.length;i++){
            int y = fares[i][0]-1;
            int x = fares[i][1]-1;
            int d = fares[i][2];
            dist[y][x] = d;
            dist[x][y] = d;
            
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                if(i==k)
                    continue;
                for(int j=0;j<n;j++){
                    if(i==j || j==k)
                        continue;
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }
        for(int i=0; i<n; i++) {
            int current = dist[s-1][i] + dist[i][a-1] + dist[i][b-1];
            if(answer >= current ) {
                answer = current;
            }
        }

        return answer;
    }
    
    
}