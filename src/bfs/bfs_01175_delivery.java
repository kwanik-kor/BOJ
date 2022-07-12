package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1175
 */
public class bfs_01175_delivery {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int N, M;
    static char[][] map;
    static boolean[][][][] visit;

    static int solve(int y, int x) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x, -1, 0, 0));
        for (int i = 0; i < 4; i++) {
            visit[y][x][i][0] = true;
        }

        while(!q.isEmpty()) {
            Node now = q.poll();

            int stat = now.status;
            if (map[now.y][now.x] == 'C') {
                stat |= 1;
            } else if (map[now.y][now.x] == 'D') {
                stat |= 2;
            }

            if (stat == 3) {
                return now.cnt;
            }

            for (int dir = 0; dir < 4; dir++) {
                if (now.dir == dir) continue;
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if (ny < 0 || nx < 0 || N <= ny || M <= nx || map[ny][nx] == '#' || visit[ny][nx][dir][stat]) continue;
                visit[ny][nx][dir][stat] = true;
                q.add(new Node(ny, nx, dir, now.cnt + 1, stat));
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visit = new boolean[N][M][4][3];
        int cnt = 0;
        int startY = -1, startX = -1;
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'C') {
                    cnt++;
                    if (cnt == 2) {
                        map[i][j] = 'D';
                    }
                } else if (map[i][j] == 'S') {
                    startY = i;
                    startX = j;
                    map[i][j] = '.';
                }
            }
        }

        bw.write(solve(startY, startX) + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int y, x, dir, cnt, status;

        public Node(int y, int x, int dir, int cnt, int status) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.cnt = cnt;
            this.status = status;
        }
    }

}
