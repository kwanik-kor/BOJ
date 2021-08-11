package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/21736
 * 2. 풀이
 *  - 시작점으로부터 BFS로 순회를 하며, 방문한 노드가 친구라면 리턴 값을 증가시켜준다다 */
public class bfs_21736_fossilNeedsFriend {

    static int N, M;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static char[][] map;
    static boolean[][] visit;

    static Point start;

    static int solve() {
        int ret = 0;

        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visit[start.y][start.x] = true;

        while(!q.isEmpty()) {
            Point now = q.poll();
            if(map[now.y][now.x] == 'P')
                ret++;

            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || N <= ny || M <= nx || map[ny][nx] == 'X' || visit[ny][nx]) continue;
                visit[ny][nx] = true;
                q.add(new Point(ny, nx));
            }
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visit = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 'I') {
                    map[i][j] = 'O';
                    start = new Point(i, j);
                }
            }
        }

        int ans = solve();

        bw.write(ans == 0? "TT" : (ans + ""));
        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int y;
        int x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
