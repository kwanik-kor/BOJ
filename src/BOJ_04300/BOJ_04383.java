package BOJ_04300;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_04383 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            bw.write(solve(line) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static String solve(String input) {
        final StringTokenizer st = new StringTokenizer(input);
        final int n = Integer.parseInt(st.nextToken());
        final boolean[] check = new boolean[n];
        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i == 0) continue;

            int abs = Math.abs(arr[i] - arr[i - 1]);
            if (abs == 0 || abs >= n || check[abs]) return "Not jolly";
            check[abs] = true;
        }

        return "Jolly";
    }

}
