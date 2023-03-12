package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/25513
 */
public class bfs_25513_quickAscendSearch {
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    static int[][] map = new int[5][5];
    static boolean[][][] visit = new boolean[5][5][7];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        bw.write(bfs(y, x) + "");
        bw.close();
        br.close();
    }

    static int bfs(int y, int x) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x, 0, 0));
        visit[y][x][0] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int idx = now.idx;

            if (idx == 6) {
                return now.cnt;
            }

            for (int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];

                if (isOutOfRange(ny, nx) || visit[ny][nx][idx]) continue;

                visit[ny][nx][idx] = true;

                int nIdx = idx;
                if (map[ny][nx] == idx + 1) nIdx++;

                q.add(new Node(ny, nx, nIdx, now.cnt + 1));
            }
        }

        return -1;
    }

    static boolean isOutOfRange(int y, int x) {
        return y < 0 || x < 0 || 5 <= y || 5 <= x || map[y][x] == -1;
    }

    static class Node {
        int y, x, idx, cnt;

        public Node(int y, int x, int idx, int cnt) {
            this.y = y;
            this.x = x;
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}
