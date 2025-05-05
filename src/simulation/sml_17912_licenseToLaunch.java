package simulation;

import java.io.*;
import java.util.Arrays;

public class sml_17912_licenseToLaunch {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        final int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            return;
        }

        final int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int idx = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
                idx = i;
            }
        }

        bw.write(idx + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
