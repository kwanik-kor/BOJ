package BOJ_01600;

import java.io.*;
import java.util.*;

public class BOJ_01679 {

    private static int play(List<Integer> nums, int k) {
        final Set<Integer> set = new HashSet<>(nums);
        final int max = nums.get(nums.size() - 1);
        final int[] dp = new int[max * k + 2];
        dp[0] = 50_000;
        for (int i = 1, n = dp.length; i < n; i++) {
            dp[i] = 50_000;
            if (set.contains(i)) {
                dp[i] = 1;
                continue;
            }

            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }
            if (dp[i] > k) {
                return i;
            }
        }
        return max * k + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        final List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        final int k = Integer.parseInt(br.readLine());

        final int roundResult = play(nums, k);
        bw.write(String.format("%s win at %d", roundResult % 2 == 0 ? "holsoon" : "jjaksoon", roundResult));

        bw.flush();
        bw.close();
        br.close();
    }
}
