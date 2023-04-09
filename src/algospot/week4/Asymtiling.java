package algospot.week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Asymtiling {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int MOD = 1000000007;

    static int[] tileMemo = new int[101];

    public static void main(String[] args) throws Exception {
        initializeTiling();

        Asymtiling main = new Asymtiling();

        int C = Integer.parseInt(br.readLine());
        while (C-- > 0) {
            main.solve();
        }

        bw.close();
        br.close();
    }

    private static void initializeTiling() {
        Arrays.fill(tileMemo, -1);

        tileMemo[0] = tileMemo[1] = 1;
        tiling(100);
    }

    private static int tiling(int length) {
        if (length <= 1 || tileMemo[length] != -1) {
            return tileMemo[length];
        }

        return tileMemo[length] = (tiling(length - 2) + tiling(length - 1)) % MOD;
    }

    private void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        bw.write(calculateAsymmetric(n) + "\n");
    }

    private int calculateAsymmetric(int length) {
        int totalCnt = tileMemo[length];

        totalCnt = (totalCnt - tileMemo[length / 2] + MOD) % MOD;

        return length % 2 == 1
                ? totalCnt
                : (totalCnt - tileMemo[length / 2 - 1] + MOD) % MOD;
    }

}
