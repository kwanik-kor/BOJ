package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/4672
 * 2. 풀이
 *  - BFS로도 분류가 되어 있지만 백트래킹이 메인인 문제였다.,
 *   - 현재 노드를 방문했을 경우, 그리고 방문하지 않았을 경우(룩을 배치 or 노배치)에 대한 처리를 순차적으로 진행해준다.
 */
public class bfs_04672_dontGetRooked {

    static final char WALL = 'X', PLAIN = '.', ROOK = 'O';

    static int N, max = 0;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static char[][] map;
    static boolean[][] visit;

    static void dfs(int cnt) {
        for(int i = 0; i < N; i++) {
            for(int j =0; j < N; j++) {
                if(map[i][j] != WALL && !visit[i][j]) {
                    cnt++;
                    if(max < cnt) max = cnt;

                    map[i][j] = ROOK;
                    resetMap();
                    dfs(cnt);
                    map[i][j] = PLAIN;
                    resetMap();
                    cnt--;
                }
            }
        }
    }

    static void resetMap() {
        for(int i = 0; i < N; i++) {
            Arrays.fill(visit[i], false);
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == ROOK) {
                    visit[i][j] = true;
                    for(int dir = 0; dir < 4; dir++) {
                        int ny = i + dy[dir];
                        int nx = j + dx[dir];
                        while(true) {
                            if(isOutBound(ny, nx) || map[ny][nx] == WALL) break;
                            visit[ny][nx] = true;
                            ny += dy[dir];
                            nx += dx[dir];
                        }
                    }
                }
            }
        }
    }

    static boolean isOutBound(int y, int x) {
        return y < 0 || x < 0 || N <= y || N <= x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            max = 0;
            map = new char[N][N];
            visit = new boolean[N][N];

            for(int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
                for(int j = 0; j < N; j++) {
                    if(map[i][j] == WALL)
                        visit[i][j] = true;
                }
            }

            dfs(0);
            bw.write(max + "\n");
        }

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
