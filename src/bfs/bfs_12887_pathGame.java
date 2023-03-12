package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/12887
 */
public class bfs_12887_pathGame {
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static final char WHITE = '.', BLACK = '#';
    static char[][] map;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());

        map = new char[2][M];
        int white = 0;
        for (int i = 0; i < 2; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == WHITE) {
                    white++;
                }
            }
        }

        int shortestLength = bfs();

        System.out.println(white - shortestLength + "");
        br.close();
    }

    static int bfs() {
        int len = 0;

        Queue<Integer> q = new LinkedList<>();
        boolean[][] visit = new boolean[2][M];
        for (int i = 0; i < 2; i++) {
            if (map[i][0] == WHITE) {
                q.add(i * M);
                visit[i][0] = true;
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int now = q.poll();
                int y = now / M;
                int x = now % M;

                if (x == M - 1) {
                    return len + 1;
                }

                for (int dir = 0; dir < 4; dir++) {
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];

                    if (ny < 0 || nx < 0 || 2 <= ny || M <= nx || visit[ny][nx] || map[ny][nx] == BLACK) continue;

                    visit[ny][nx] = true;
                    q.add(ny * M + nx);
                }
            }

            len++;
        }

        return len;
    }

}
