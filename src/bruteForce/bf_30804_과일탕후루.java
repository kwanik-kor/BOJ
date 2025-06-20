package bruteForce;

import java.io.*;
import java.util.Arrays;

public class bf_30804_과일탕후루 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static boolean completed(int[] cnt) {
        int n = 0;

        for (int i = 0; i < 10; i++) {
            if (cnt[i] > 0) {
                n++;
            }
        }

        return n > 2;
    }

    public static void main(String[] args) throws IOException {
        final int N = Integer.parseInt(br.readLine());
        final int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        final int[] cnt = new int[10];

        int left = 0;
        int right = 0;
        int max = 0;

        while (left < N) {
            while (right < N) {
                cnt[arr[right++]]++;

                if (completed(cnt)) {
                    right--;
                    cnt[arr[right]]--;
                    break;
                }
            }

            max = Math.max(max, right - left);
            cnt[arr[left++]]--;
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
