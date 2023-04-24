package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bf_01505_lightOn {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final char ON = '*', OFF = '.';
    static int N, M;
    static int[] map, bulb;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        new bf_01505_lightOn().solve();
    }

    private void solve() throws Exception {
        initializeBoard();

        for (int selectedBulb = 0, tot = (1 << M); selectedBulb < tot; selectedBulb++) {
            checkCanOnAllLights(selectedBulb);
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    private void checkCanOnAllLights(int selectedBulb) {
        copyOriginToTemp();

        int cnt = 0;
        for (int i = M - 1; i >= 0; i--) {
            if ((selectedBulb & (1 << i)) > 0) {
                cnt++;
                pressBulb(0, i);
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = M - 2; j >= 0; j--) {
                if ((bulb[i - 1] & (1 << (j + 1))) > 0) {
                    cnt++;
                    pressBulb(i, j);
                }

                if (ans <= cnt) {
                    return;
                }
            }
        }

        System.out.println("===========");
        System.out.println(String.format("%3s", Integer.toBinaryString(selectedBulb)).replace(' ', '0'));
        System.out.println("=---------=");
        for (int i = 0; i < N; i++) {
            System.out.println(String.format("%3s", Integer.toBinaryString(bulb[i])).replace(' ', '0'));
        }

        if (bulb[M - 1] == 0) {
            ans = Math.min(ans, cnt);
        }
    }

    private void pressBulb(int y, int x) {
        bulb[y] ^= (1 << x);
        if (y > 0) {
            bulb[y - 1] ^= (1 << x);
            if (x < M - 1) {
                bulb[y - 1] ^= (1 << (x + 1));
            }
            if (x > 0) {
                bulb[y - 1] ^= (1 << (x - 1));
            }
        }
        if (y < M - 1) {
            bulb[y + 1] ^= (1 << x);
            if (x < M - 1) {
                bulb[y + 1] ^= (1 << (x + 1));
            }
            if (x > 0) {
                bulb[y + 1] ^= (1 << (x - 1));
            }
        }
        if (x < M - 1) {
            bulb[y] ^= (1 << (x + 1));
        }
        if (x > 0) {
            bulb[y] ^= (1 << (x - 1));
        }
    }

    private void initializeBoard() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N];
        bulb = new int[N];

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (line[j] == OFF) {
                    map[i] |= (1 << M - j - 1);
                }
            }
        }
    }

    private void copyOriginToTemp() {
        bulb = Arrays.stream(map).toArray();
    }
}
