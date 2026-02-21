package BOJ_34700;

import java.io.*;

public class BOJ_34750 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int n = Integer.parseInt(br.readLine());
        int parent;
        if (n >= 1_000_000) {
            parent = n * 2 / 10;
        } else if (n >= 500_000) {
            parent = n * 15 / 100;
        } else if (n >= 100_000) {
            parent = n / 10;
        } else {
            parent = n * 5 / 100;
        }

        bw.write(parent + " " + (n - parent));
        bw.flush();
        bw.close();
        br.close();
    }

}
