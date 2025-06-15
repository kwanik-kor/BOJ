package simulation;

import java.io.*;
import java.util.StringTokenizer;

public class sml_30979_유치원생_파댕이_돌보기 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        int n  = Integer.parseInt(br.readLine());

        final StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            t -= Integer.parseInt(st.nextToken());
        }

        bw.write(t > 0 ? "Padaeng_i Cry" : "Padaeng_i Happy");

        bw.flush();
        bw.close();
        br.close();
    }
}
