package simulation;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sml_30802_웰컴키트 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] sizes = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int tot = 0;
        for (int i = 0; i < 6; i++) {
            tot += sizes[i] / T + (sizes[i] % T == 0 ? 0 : 1);
        }

        bw.write(tot + "\n");
        bw.write(N / P + " " + (N % P));

        bw.flush();
        bw.close();
        br.close();
    }
}
