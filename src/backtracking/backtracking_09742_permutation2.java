package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/9742
 */
public class backtracking_09742_permutation2 {

    static int[] fact = new int[11];
    static char[] chars;
    static boolean[] visit;
    static String ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        calcFactorial();

        String line = "";
        while ((line = br.readLine()) != null && !line.equals("")) {
            bw.write(String.format("%s = ", line));

            StringTokenizer st = new StringTokenizer(line);
            chars = st.nextToken().toCharArray();
            int targetIdx = Integer.parseInt(st.nextToken());

            visit = new boolean[chars.length];
            if (targetIdx > fact[chars.length]) {
                bw.write("No permutation\n");
            } else {
                solve(targetIdx - 1, visit.length, "");
                bw.write(ans + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void calcFactorial() {
        fact[0] = 1;
        for (int i = 1; i <= 10; i++) {
            fact[i] = fact[i - 1] * i;
        }
    }

    static void solve(int idx, int len, String str) {
        if (len < 1) {
            ans = str;
            return;
        }

        int i = idx / fact[len - 1];

        int cnt = 0;
        for (int t = 0; t < visit.length; t++) {
            if (visit[t]) continue;

            if (i == cnt) {
                visit[t] = true;
                str += chars[t];
                break;
            }

            cnt++;
        }

        solve(idx % fact[len - 1], len - 1, str);
    }
}
