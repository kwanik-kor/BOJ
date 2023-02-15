package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class backtracking_09742_permutation {

    static int[] dp = new int[11];

    static char[] arr;
    static int n, cnt;
    static String ans;

    static void calcFactorial() {
        dp[0] = 1;
        for (int i = 1; i <= 10; i++) {
            dp[i] = dp[i - 1] * i;
        }
    }

    static void solveWithBacktracking(int len, String str, boolean[] visit) {
        if (len == arr.length) {
            cnt++;
            if (cnt == n) {
                ans = str;
                return;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (visit[i]) continue;

            visit[i] = true;
            solveWithBacktracking(len + 1, str + arr[i], visit);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        calcFactorial();

        String line = "";
        while ((line = br.readLine()) != null && !line.equals("")) {
            bw.write(String.format("%s = ", line));

            StringTokenizer st = new StringTokenizer(line);
            arr = st.nextToken().toCharArray();
            n = Integer.parseInt(st.nextToken());
            ans = "";
            cnt = 0;

            if (n > dp[arr.length]) {
                bw.write("No permutation\n");
            } else {
                solveWithBacktracking(0, "", new boolean[arr.length]);
                bw.write(ans + "\n");
            }
        }

        bw.close();
        br.close();
    }
}
