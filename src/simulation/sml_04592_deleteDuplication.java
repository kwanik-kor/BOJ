package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/4592
 */
public class sml_04592_deleteDuplication {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) break;

            int last = 0;
            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    bw.write(n + " ");
                } else if (n != last) {
                    bw.write(n + " ");
                }
                last = n;
            }
            bw.write("$\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
