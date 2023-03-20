package algospot.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ClockSync {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int[][] SWITCHES = {
            {0, 1, 2}, {3, 7, 9, 11}, {4, 10, 14, 15}, {0, 4, 5, 6, 7}, {6, 7, 8, 10, 12}, {0, 2, 14, 15}, {3, 14, 15}, {4, 5, 7, 14, 15}, {1, 2, 3, 4, 5}, {3, 4, 5, 9, 13}
    };
    static int ans;

    void solve() throws IOException {
        int[] clocks = getClockStatus();
        ans = Integer.MAX_VALUE;

        clockSync(clocks, 0, 0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    // {12, 3, 6, 9} -> {0, 1, 2, 3}
    private int[] getClockStatus() throws IOException {
        return Arrays.stream(br.readLine().split(" "))
                .mapToInt(str -> {
                    int tmp = Integer.parseInt(str);
                    tmp %= 12;
                    return tmp /= 3;
                })
                .toArray();
    }

    private void clockSync(int[] clocks, int idx, int pressedCnt) {
        if (idx == 10) {
            if (isAllTwelve(clocks)) {
                ans = Math.min(ans, pressedCnt);
            }
            return;
        }

        clockSync(clocks, idx + 1, pressedCnt);
        for (int i = 1; i <= 3; i++) {
            pressSwitch(clocks, idx, i, false);
            clockSync(clocks, idx + 1, pressedCnt + i);
            pressSwitch(clocks, idx, i, true);
        }
    }

    private void pressSwitch(int[] clocks, int switchIdx, int cnt, boolean isReverse) {
        for (int i = 0, n = SWITCHES[switchIdx].length; i < n; i++) {
            clocks[SWITCHES[switchIdx][i]] = isReverse
                    ? (clocks[SWITCHES[switchIdx][i]] + 4 - cnt) % 4
                    : (clocks[SWITCHES[switchIdx][i]] + cnt) % 4;
        }
    }

    private boolean isAllTwelve(int[] clocks) {
        for (int i = 0; i < 16; i++) {
            if (clocks[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        ClockSync clockSync = new ClockSync();

        int c = Integer.parseInt(br.readLine().trim());
        while (c-- > 0) {
            clockSync.solve();
        }
    }
}
