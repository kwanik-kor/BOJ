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
 * 1. 문제 링크 : https://www.acmicpc.net/problem/7669
 * 2. 풀이
 *  1) 바둑알이 놓인 지점에서 네 방향으로 탐색을 했을 때, 빈공간이 있으면 영역을 확인한다.
 *  2) 탐색을 시작한 시점의 바둑알 색깔을 플래그로 넘겨서, 빈공간 영역의 너비를 탐색 중
 *     다른 색깔을 발견할 경우 공역(누구의 영역도 아님)으로 return 한다.
 *     > 단, 탐색 도중 return 할 경우 추후 불필요한 탐색을 진행하게 되므로 flag로 판별
 *  3) 공역이 아닌경우 각 탐색 시점의 돌 색깔에 맞게 영역의 너비를 더하고 최종적으로 답을 산출한다.
 */
public class bfs_07669_go {

    static final int BLACK = 1, WHITE = 2;
    static int N, B, W;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int[][] map;
    static boolean[][] visit;

    static int setTerritory(int y, int x, int type) {
        int cnt = 1;
        boolean flag = true;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(y, x));
        visit[y][x] = true;

        while(!q.isEmpty()) {
            Point now = q.poll();
            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                if(isOutBound(ny, nx) || visit[ny][nx]) continue;
                if(map[ny][nx] != 0 && map[ny][nx] != type)
                    flag = false;

                if(map[ny][nx] == 0) {
                    visit[ny][nx] = true;
                    cnt++;
                    q.add(new Point(ny, nx));
                }
            }
        }

        return flag? cnt : -1;
    }

    static boolean isOutBound(int y, int x) {
        return y < 0 || x < 0 || N <= y || N <= x;
    }

    static void setStone(StringTokenizer st, int cnt, int type) {
        if(cnt == 0) return;
        for(int i = 0; i < cnt; i++) {
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = type;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String line = br.readLine();
            if(line == null || line.equals(""))
                continue;

            StringTokenizer st = new StringTokenizer(line);
            N = Integer.parseInt(st.nextToken());
            if(N == 0)
                break;

            B = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            visit = new boolean[N][N];

            setStone(new StringTokenizer(br.readLine()), B, BLACK);
            setStone(new StringTokenizer(br.readLine()), W, WHITE);

            int black = 0;
            int white = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] == 0) continue;

                    for(int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if(isOutBound(ny, nx) || visit[ny][nx] || map[ny][nx] != 0) continue;

                        int result = setTerritory(ny, nx, map[i][j]);
                        if(result == -1) continue;

                        if(map[i][j] == BLACK) black += result;
                        else white += result;
                    }
                }
            }

            bw.write(black == white? "Draw\n"
                    : (black > white ? String.format("Black wins by %d\n", black - white) : String.format("White wins by %d\n", white - black)));
        }


        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int y, x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
