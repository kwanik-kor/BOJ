package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/14927
 */
public class bf_14927_lightOff {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static int n, ans = Integer.MAX_VALUE;
    static int[] board, bulb;

    public static void main(String[] args) throws IOException {
        new bf_14927_lightOff().solve();
    }

    private void solve() throws IOException {
        initializeBoard();
        for (int selectBit = 0, max = (1 << n); selectBit < max; selectBit++) {
            checkCanOffAllLights(selectBit);
        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    private void checkCanOffAllLights(int selectedBit) {
        copyOriginToTemp();

        int cnt = 0;

        // first row
        for (int i = n - 1; i >= 0; i--) {
            if ((selectedBit & (1 << i)) > 0) {
                cnt++;
                pressBulb(0, i);
            }
        }

        // for rest rows
        for (int i = 1; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if ((bulb[i - 1] & (1 << j)) > 0) {
                    pressBulb(i, j);
                    cnt++;

                    if (ans <= cnt) {
                        return;
                    }
                }
            }
        }

        if (bulb[n - 1] == 0) {
            ans = Math.min(ans, cnt);
        }
    }

    private void pressBulb(int y, int x) {
        bulb[y] ^= (1 << x);
        if (y > 0) {
            bulb[y - 1] ^= (1 << x);
        }
        if (x < n - 1) {
            bulb[y] ^= (1 << (x + 1));
        }
        if (y < n - 1) {
            bulb[y + 1] ^= (1 << x);
        }
        if (x > 0) {
            bulb[y] ^= (1 << (x - 1));
        }
    }

    private void initializeBoard() throws IOException {
        n = Integer.parseInt(br.readLine());

        board = new int[n];
        bulb = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = n - 1; j >= 0; j--) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    board[i] |= (1 << j);
                }
            }
        }
    }

    private void copyOriginToTemp() {
        bulb = Arrays.stream(board).toArray();
    }

}
