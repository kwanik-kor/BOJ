package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/1035
 * 2. 풀이
 *  - 5 x 5의 작은 배열이기 때문에 만들 수 있는 모든 조각의 형태에 대해 탐색을 진행함
 */
public class bfs_01035_movePiece {

    static final char PIECE = '*', PLAIN = '.';
    static final int MAX = Integer.MAX_VALUE;
    static char[][] map = new char[5][5];
    static boolean[][] visit = new boolean[5][5];

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static List<Node> pieces = new ArrayList<>();
    static int ans = 0;
    static int pieceCnt = 0;

    static void bfs(int y, int x) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x));
        visit[y][x] = true;
        while(!q.isEmpty()) {
            Node now = q.poll();
            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(ny < 0 || nx < 0 || 5 <= ny || 5 <= nx || map[ny][nx] != PIECE || visit[ny][nx]) continue;
                visit[ny][nx] = true;
                q.add(new Node(ny, nx));
            }
        }
    }

    static boolean isConnected() {
        int cnt = 0;

        for(int i = 0; i < 5; i++) {
            Arrays.fill(visit[i], false);
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(map[i][j] == PIECE && !visit[i][j]) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        return cnt == 1;
    }

    static void dfs(int size, int cost) {
        if (ans <= cost) return;
        if (size == pieceCnt) {
            if (isConnected()) {
                ans = Math.min(ans, cost);
            }
            return;
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(map[i][j] == PLAIN) {
                    map[i][j] = PIECE;
                    dfs(size + 1, cost + calcDist(i, j, pieces.get(size).y, pieces.get(size).x));
                    map[i][j] = PLAIN;
                }
            }
        }
    }

    static int calcDist(int y1, int x1, int y2, int x2) {
        return Math.abs(y1 - y2) + Math.abs(x1 - x2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < 5; j++) {
                if(map[i][j] == PIECE) {
                    pieces.add(new Node(i, j));
                    map[i][j] = PLAIN;
                }
            }
        }
        ans = MAX;
        pieceCnt = pieces.size();
        dfs(0, 0);

        bw.write(ans + "");
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
