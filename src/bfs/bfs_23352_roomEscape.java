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
 * 1. 문제 링크 : https://www.acmicpc.net/problem/23352
 * 2. 풀이
 *  - 최장 길이가 여러개가 있을 수 있기 때문에, brute force로 각 지점마다 bfs를 실행함
 */
public class bfs_23352_roomEscape {

    static int N, M;
    static int maxLen = 0;
    static int pwd;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int[][] map;

    static void search(int y, int x) {
        boolean[][] visit = new boolean[N][M];

        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(y, x, 1));
        visit[y][x] = true;

        int init = map[y][x];

        while(!q.isEmpty()) {
            Node now = q.poll();
            if(maxLen < now.len) {
                maxLen = now.len;
                pwd = init + map[now.y][now.x];
            } else if(maxLen == now.len) {
                pwd = Math.max(pwd, init + map[now.y][now.x]);
            }

            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(outOfRange(ny, nx) || visit[ny][nx] || map[ny][nx] == 0) continue;
                visit[ny][nx] = true;
                q.add(new Node(ny, nx, now.len + 1));
            }
        }

    }

    static boolean outOfRange(int y, int x) {
        return y < 0 || N <= y || x < 0 || M <= x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i< N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] != 0)
                    search(i, j);
            }
        }

        bw.write(pwd + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int y, x, len;
        public Node(int y, int x, int len) {
            this.y = y;
            this.x = x;
            this.len = len;
        }
    }
}
