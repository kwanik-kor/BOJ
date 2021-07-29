package bfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크 : https://www.acmicpc.net/problem/10789
 * 2. 풀이
 *  - 문제의 핵심은 다른 알파벳이 나타날때까지 계속해서 이동을 해야 한다는 것이다.
 *    > 이를 위해 움직임의 가중치를 미리 계산해둠
 *  - 그리고 입력해야 하는 문자열 길이만큼 배열을 생성해서 visit 처리를 해줌
 */
public class bfs_10789_virtualKeyboardInput {

    static final int INF = Integer.MAX_VALUE;

    static int R, C;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static char[][] keyboard;
    static int[][][] move;
    static int[][][] map;

    static int ans;
    static char[] target;

    static void solve() {
        ans = INF;
        map = new int[R][C][target.length + 1];
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                Arrays.fill(map[i][j], INF);
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0));
        map[0][0][0] = 0;
        while(!q.isEmpty()) {
            Point now = q.poll();

            if(now.idx == target.length) {
                ans = Math.min(ans, map[now.y][now.x][now.idx]);
                continue;
            }
            if(keyboard[now.y][now.x] == target[now.idx] && map[now.y][now.x][now.idx + 1] == INF) {
                map[now.y][now.x][now.idx + 1] = map[now.y][now.x][now.idx] + 1;
                q.add(new Point(now.y, now.x, now.idx + 1));
            }

            for(int dir = 0; dir < 4; dir++) {
                if(move[now.y][now.x][dir] == -1) continue;
                int ny = now.y + dy[dir] * move[now.y][now.x][dir];
                int nx = now.x + dx[dir] * move[now.y][now.x][dir];
                if(map[ny][nx][now.idx] != INF) continue;
                map[ny][nx][now.idx] = map[now.y][now.x][now.idx] + 1;
                q.add(new Point(ny, nx, now.idx));
            }
        }

    }

    // 진행방향에 같은 알파벳이 있다면, 다른 알파벳을 만날때까지 이동하기 때문에 이동 횟수를 미리 잡아놓음
    static void setMovement() {
        move = new int[R][C][4];
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                Arrays.fill(move[i][j], -1);
            }
        }

        for(int y = 0; y < R; y++) {
            for(int x = 0; x < C; x++) {
                for(int dir = 0; dir < 4; dir++) {
                    int ny = y;
                    int nx = x;
                    int n = 0;
                    while(true) {
                        if(ny < 0 || nx < 0 || R <= ny || C <= nx) break;
                        if(keyboard[y][x] != keyboard[ny][nx]) {
                            move[y][x][dir] = n;
                            break;
                        }
                        n++;
                        ny += dy[dir];
                        nx += dx[dir];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        keyboard = new char[R][C];
        for(int i = 0; i < R; i++) {
            keyboard[i] = br.readLine().toCharArray();
        }

        String targetTxt = br.readLine();
        target = new char[targetTxt.length() + 1];
        for(int i = 0; i < target.length - 1; i++)
            target[i] = targetTxt.charAt(i);
        target[target.length - 1] = '*';

        setMovement();
        solve();

        bw.write(ans + "");

        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int y;
        int x;
        int idx;

        public Point(int y, int x, int idx) {
            this.y = y;
            this.x = x;
            this.idx = idx;
        }
    }
}
