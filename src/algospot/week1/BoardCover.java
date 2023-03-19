package algospot.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BoardCover {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final char WHITE = '.', BLACK = '#';
    static final int[][] dy = {{0, 1}, {0, 1}, {1, 1}, {1, 1}};
    static final int[][] dx = {{1, 0}, {1, 1}, {0, 1}, {-1, 0}};

    static int H, W;
    static char[][] map;

    void solve() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        int cnt = 0;
        for (int i = 0; i < H; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                if (map[i][j] == WHITE) cnt++;
            }
        }

        if (cnt % 3 != 0) {
            System.out.println(0);
            return;
        }

        System.out.println(cover(cnt / 3));
    }

    int cover(int remainedBlock) {
        if (remainedBlock == 0) {
            return 1;
        }

        int startIdx = findWhiteAreaIdx();
        int y = startIdx / W;
        int x = startIdx % W;

        int cnt = 0;
        for (int type = 0; type < 4; type++) {
            if (!isAvailableToPut(y, x, type)) continue;
            map[y][x] = map[y + dy[type][0]][x + dx[type][0]] = map[y + dy[type][1]][x + dx[type][1]] = BLACK;

            cnt += cover(remainedBlock - 1);

            map[y][x] = map[y + dy[type][0]][x + dx[type][0]] = map[y + dy[type][1]][x + dx[type][1]] = WHITE;
        }

        return cnt;
    }

    boolean isAvailableToPut(int y, int x, int type) {
        for (int dir = 0; dir < 2; dir++) {
            int ny = y + dy[type][dir];
            int nx = x + dx[type][dir];
            if (ny < 0 || nx < 0 || H <= ny || W <= nx || map[ny][nx] == BLACK) return false;
        }
        return true;
    }

    int findWhiteAreaIdx() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == WHITE) {
                    return i * W + j;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine().trim());

        BoardCover boardCover = new BoardCover();
        while (t-- > 0) {
            boardCover.solve();
        }
    }
}
