package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1. 문제 링크: https://www.acmicpc.net/problem/1783
 */
public class greedy_01783_sickKnight {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (N == 1) {
            bw.write("1");
        } else if (N == 2) {
            bw.write(Math.min(4, (M + 1) / 2) + "");
        } else {
            if (M < 7) {
                bw.write(Math.min(4, M) + "");
            } else {
                bw.write((M - 7 + 5) + "");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
