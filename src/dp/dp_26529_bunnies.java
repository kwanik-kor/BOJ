package dp;

import java.io.*;

public class dp_26529_bunnies {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[] dp;

    static {
        dp = new long[46];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    }

    public static void main(String[] args) throws IOException {
        final int sequence = Integer.parseInt(br.readLine());

        for (int i = 0; i < sequence; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
