package simulation;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1173
 */
public class sml_01173_exercise {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int tot = 0;
        int purse = m;
        while (N > 0) {
            if (m + T > M) {
                break;
            }

            tot++;

            if (purse + T <= M) {
                purse += T;
                N--;
            } else {
                purse = Math.max(m, purse - R);
            }
        }

        bw.write(N > 0 ? "-1" : tot + "");
        bw.close();
        br.close();
    }

}
