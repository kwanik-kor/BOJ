package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfs_2178_searchMaze {

    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static char[][] map;
    static boolean[][] visit;

    static int solve(int N, int M) {
        Node start = new Node(0, 0);

        Queue<Node> q = new LinkedList<>();
        q.add(start);
        visit[0][0] = true;

        int length = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                Node now = q.poll();
                if (now.y == N - 1 && now.x == M - 1) {
                    return length + 1;
                }

                for (int dir = 0; dir < 4; dir++) {
                    int ny = now.y + dy[dir];
                    int nx = now.x + dx[dir];

                    if (ny < 0 || nx < 0 || N <= ny || M <= nx || visit[ny][nx] || map[ny][nx] == '0') continue;

                    q.add(new Node(ny, nx));
                    visit[ny][nx] = true;
                }
            }

            length++;
        }

        return length;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        bw.write(solve(N, M) + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
