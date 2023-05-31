package programmers.level2;


import java.util.LinkedList;
import java.util.Queue;

/**
 * [문제명] 미로 탈출
 * [풀이시간] 18분
 * [한줄평] BFS 기초 문제였다.
 * 1_v1. BFS(성공)
 * @See <a href="https://school.programmers.co.kr/learn/courses/30/lessons/159993">문제</a>
 */
class Solution159993 {
    public static void main(String[] args) {
        //
        System.out.println();
    }

    // 1_v1
    class P {
        int x;
        int y;
        P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    char[][] map;
    int n, m;
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        P s = null;
        P l = null;
        P e = null;
        map = new char[n][m];
        // 1. map 초기화, 시작/레버/출구 좌표 초기화
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'S') s = new P(i, j);
                else if(map[i][j] == 'L') l = new P(i, j);
                else if(map[i][j] == 'E') e = new P(i, j);
            }
        }
        // 2. 시작 -> 레버 최단거리
        int d1 = bfs(s, l);
        if(d1 == 0) return -1;
        // 3. 레버 -> 출구 최단거리
        int d2 = bfs(l, e);
        if(d2 == 0) return -1;
        return d1 + d2;
    }

    public int bfs(P start, P end) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        // 1. 시작 지점 방문처리
        Queue<P> q = new LinkedList<>();
        q.add(new P(start.x, start.y));
        int[][] visited = new int[n][m];
        visited[start.x][start.y] = 1;
        //
        while(!q.isEmpty()) {
            P p = q.poll();
            int x = p.x;
            int y = p.y;
            // 2. 출구 찾으면 최단거리 리턴
            if(x == end.x && y == end.y) return visited[x][y] - 1;
            // 3. 인접 좌표 탐색
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if(map[nx][ny] != 'X' && visited[nx][ny] == 0) {
                        q.add(new P(nx, ny));
                        visited[nx][ny] = visited[x][y] + 1;
                    }
                }
            }
        }
        return 0;
    }
}