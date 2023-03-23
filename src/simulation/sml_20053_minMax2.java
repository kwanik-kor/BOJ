package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/20053
 */
public class sml_20053_minMax2 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new sml_20053_minMax2().solve();
    }

    private void solve() throws Exception {
        int T = Integer.parseInt(br.readLine());

        int min;
        int max;

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int n = Integer.parseInt(st.nextToken());
                min = Math.min(min, n);
                max = Math.max(max, n);
            }

            System.out.printf("%d %d\n", min, max);
        }
    }
}
