package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1917
 */
public class dfs_01917_planarFigure {

    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static int[][] map;
    static int[] pos, face;
    static boolean[][] visit;
    static boolean ans;

    static String solve() {
        ans = true;

        for (int i = 1; i <= 6; i++) {
            for (int dir = 0; dir < 4; dir++) {
                int ny = pos[i] / 6 + dy[dir];
                int nx = pos[i] % 6 + dx[dir];

                if (isOutOfRange(ny, nx)) continue;

                dfs(ny, nx, i, dir, 1);
            }
        }

        for (int i = 1; i <= 6; i++) {
            if (face[i] == 0) {
                ans = false;
                break;
            }
        }

        return ans ? "yes\n" : "no\n";
    }

    static void dfs(int y, int x, int originNode, int originDir, int cnt) {
        if (cnt >= 2) return;

        for (int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if (isOutOfRange(ny, nx) || visit[originNode][map[ny][nx]]) continue;
            
            int nextNode = map[ny][nx];

            visit[originNode][nextNode] = true;

            if (cnt == 1 && dir == originDir) {
                if (face[nextNode] == 0 || face[nextNode] == originNode) {
                    face[nextNode] = originNode;
                    face[originNode] = nextNode;
                } else {
                    ans = false;
                }
                return;
            } else {
                dfs(ny, nx, originNode, originDir, cnt);
            }
        }
    }

    static boolean isOutOfRange(int y, int x) {
        return y < 0 || x < 0 || 6 <= y || 6 <= x || map[y][x] == 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        map = new int[6][6];

        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            clearArray();

            int num = 0;

            for (int j = 0; j < 6; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 6; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                    if (map[j][k] == 1) {
                        pos[++num] = j * 6 + k;
                        visit[num][num] = true;
                        map[j][k] = num;
                    }
                }
            }

            ret.append(solve());
        }

        bw.write(ret.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void clearArray() {
        pos = new int[7];
        face = new int[7];
        map = new int[6][6];
        visit = new boolean[7][7];
    }
}
