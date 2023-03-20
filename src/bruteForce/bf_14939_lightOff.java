package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/14939
 */
public class bf_14939_lightOff {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int SIZE = 10;
    static final char ON = 'O', OFF = '#';
    static int ans = Integer.MAX_VALUE;
    static int[] map = new int[SIZE];
    static int[] bulb = new int[SIZE];

    public static void main(String[] args) throws Exception {
        new bf_14939_lightOff().solve();
    }

    private void solve() throws Exception {
        initializeMap();
        for (int selectedBit = 0, n = (1 << SIZE); selectedBit < n; selectedBit++) {
            checkCanOffAllLights(selectedBit);
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    private void checkCanOffAllLights(int selectedBit) {
        copyOriginMapToTemp();

        int cnt = 0;
        for (int i = SIZE - 1; i >= 0; i--) {
            if ((selectedBit & (1 << i)) != 0) {
                cnt++;
                pressBulb(0, i);
            }
        }

        for (int i = 1; i < SIZE; i++) {
            for (int j = SIZE - 1; j >= 0; j--) {
                if ((bulb[i - 1] & (1 << j)) > 0) {
                    cnt++;
                    pressBulb(i, j);
                }

                if (ans <= cnt) return;
            }
        }

        if (bulb[SIZE - 1] == 0) {
            ans = Math.min(ans, cnt);
        }
    }

    private void pressBulb(int y, int x) {
        bulb[y] ^= (1 << x);
        if (0 < y) {
            bulb[y - 1] ^= (1 << x);
        }
        if (y < SIZE - 1) {
            bulb[y + 1] ^= (1 << x);
        }
        if (x < SIZE - 1) {
            bulb[y] ^= (1 << (x + 1));
        }
        if (0 < x) {
            bulb[y] ^= (1 << (x - 1));
        }
    }

    private void initializeMap() throws Exception {
        for (int i = 0; i < SIZE; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < SIZE; j++) {
                if (line[j] == ON) {
                    map[i] |= (1 << (SIZE - j - 1));
                }
            }
        }
    }

    private void copyOriginMapToTemp() {
        bulb = Arrays.stream(map).toArray();
    }

}
