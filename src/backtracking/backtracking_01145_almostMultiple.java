package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1145
 */
public class backtracking_01145_almostMultiple {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        new backtracking_01145_almostMultiple().solve();
    }

    private void solve() throws Exception {
        arr = getInputArray();
        backtracking(0, 0, 1);
        System.out.println(ans);
    }

    private void backtracking(int cnt, int idx, int lcm) {
        if (ans <= lcm) return;
        if (cnt == 3) {
            ans = Math.min(ans, lcm);
            return;
        }

        for (int i = idx; i < 5; i++) {
            backtracking(cnt + 1, i + 1, lcm(lcm, arr[i]));
        }
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private int gcd(int a, int b) {
        if (b > a) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        int c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }

        return a;
    }

    private int[] getInputArray() throws IOException {
        return Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
